/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.controller;

import be.ugent.maf.cellmissy.config.PropertiesConfigurationHolder;
import be.ugent.maf.cellmissy.entity.Experiment;
import be.ugent.maf.cellmissy.entity.ExperimentStatus;
import be.ugent.maf.cellmissy.entity.Instrument;
import be.ugent.maf.cellmissy.entity.Magnification;
import be.ugent.maf.cellmissy.entity.PlateCondition;
import be.ugent.maf.cellmissy.entity.PlateFormat;
import be.ugent.maf.cellmissy.entity.Project;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.utils.GuiUtils;
import be.ugent.maf.cellmissy.utils.ValidationUtils;
import be.ugent.maf.cellmissy.gui.experiment.setup.ExperimentInfoPanel;
import be.ugent.maf.cellmissy.gui.experiment.setup.SetupExperimentPanel;
import be.ugent.maf.cellmissy.gui.experiment.setup.SetupPanel;
import be.ugent.maf.cellmissy.gui.plate.SetupPlatePanel;
import be.ugent.maf.cellmissy.gui.plate.WellGui;
import be.ugent.maf.cellmissy.gui.view.renderer.ExperimentsListRenderer;
import be.ugent.maf.cellmissy.gui.view.renderer.SetupTableRenderer;
import be.ugent.maf.cellmissy.service.ExperimentService;
import be.ugent.maf.cellmissy.service.ProjectService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.persistence.PersistenceException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import org.apache.log4j.Logger;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * SetupExperiment Panel Controller: set up a new experiment. 
 * Parent controller: CellMissy Controller (main controller)
 * Child controllers: Conditions Controller, Setup Plate Controller
 * @author Paola
 */
@Controller("setupExperimentController")
public class SetupExperimentController {

    private static final Logger LOG = Logger.getLogger(SetupExperimentController.class);
    //model
    private Experiment experiment;
    private ObservableList<Project> projectBindingList;
    private ObservableList<Experiment> experimentBindingList;
    private ObservableList<Instrument> instrumentBindingList;
    private ObservableList<Magnification> magnificationBindingList;
    private BindingGroup bindingGroup;
    private File mainDirectory;
    //view
    private SetupExperimentPanel setupExperimentPanel;
    private ExperimentInfoPanel experimentInfoPanel;
    private SetupPanel setupPanel;
    private JTable conditionsTable;
    //parent controller
    @Autowired
    private CellMissyController cellMissyController;
    //child controllers
    @Autowired
    private SetupConditionsController setupConditionsController;
    @Autowired
    private SetupPlateController setupPlateController;
    @Autowired
    private SetupReportController setupReportController;
    //services
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ExperimentService experimentService;
    private GridBagConstraints gridBagConstraints;

    /**
     * initialize Controller
     */
    public void init() {
        bindingGroup = new BindingGroup();
        gridBagConstraints = GuiUtils.getDefaultGridBagConstraints();
        mainDirectory = new File(PropertiesConfigurationHolder.getInstance().getString("mainDirectory"));
        experimentService.init(mainDirectory);

        //create panels
        experimentInfoPanel = new ExperimentInfoPanel();
        setupExperimentPanel = new SetupExperimentPanel();
        setupPanel = new SetupPanel();

        //init views
        initExperimentInfoPanel();
        initSetupExperimentPanel();

        //init child controllers
        setupPlateController.init();
        setupConditionsController.init();
    }

    /**
     * setters and getters
     *  
     * @return 
     */
    public SetupExperimentPanel getSetupExperimentPanel() {
        return setupExperimentPanel;
    }

    public SetupPanel getSetupPanel() {
        return setupPanel;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public JTable getConditionsTable() {
        return conditionsTable;
    }

    /**
     * public methods
     */
    /**
     * 
     * if the user adds a new condition, add a new entry to the map: new condition-empty list of rectangles
     * @param conditionToAdd added to the list
     */
    public void onNewConditionAdded(PlateCondition conditionToAdd) {
        setupPlateController.addNewRectangleEntry(conditionToAdd);
    }

    /**
     * if the user removes a condition from the list, wells conditions are set back to null, rectangles are removed from the map and repaint is called
     * @param conditionToRemove 
     */
    public void onConditionToRemove(PlateCondition conditionToRemove) {
        //set back to null the condition of the wells selected 
        resetWellsCondition(conditionToRemove);
        //remove the rectangles from the map
        setupPlateController.removeRectangleEntry(conditionToRemove);
        //repaint
        setupPlateController.getSetupPlatePanel().repaint();
    }

    /**
     * get the current condition from the child controller
     * @return the current condition
     */
    public PlateCondition getCurrentCondition() {
        return setupConditionsController.getCurrentCondition();
    }

    /**
     * get the setup plate panel from the child controller
     * @return setup plate panel
     */
    public SetupPlatePanel getSetupPlatePanel() {
        return setupPlateController.getSetupPlatePanel();
    }

    /**
     * show a message through the main frame
     * @param message
     * @param messageType  
     */
    public void showMessage(String message, Integer messageType) {
        cellMissyController.showMessage(message, messageType);
    }

    /**
     * When the mouse is released and the rectangle has been drawn, this method is called:
     * set well collection of the current condition and set the condition of the selected wells
     * @param plateCondition 
     * @param rectangle 
     * @return true if the selection of wells is valid, else show a message
     */
    public boolean updateWellCollection(PlateCondition plateCondition, Rectangle rectangle) {
        boolean isSelectionValid = true;
        Collection<Well> wellCollection = plateCondition.getWellCollection();
        outerloop:
        for (WellGui wellGui : setupPlateController.getSetupPlatePanel().getWellGuiList()) {
            //get only the bigger default ellipse2D
            Ellipse2D ellipse = wellGui.getEllipsi().get(0);
            if (rectangle.contains(ellipse.getX(), ellipse.getY(), ellipse.getWidth(), ellipse.getHeight())) {
                //check if the collection already contains that well
                if (!wellCollection.contains(wellGui.getWell())) {
                    //the selection is valid if the wells do not have a condition yet
                    if (!hasCondition(wellGui)) {
                        //in this case, add the well to the collection and set the condition of the well
                        wellCollection.add(wellGui.getWell());
                        wellGui.getWell().setPlateCondition(plateCondition);
                    } else {
                        //if the wells do have a condition already, the selection is not valid
                        isSelectionValid = false;
                        //in this case, show a message through the main controller
                        cellMissyController.showMessage("Some wells already have a condition\nPlease make another selection", JOptionPane.WARNING_MESSAGE);
                        //exit from the outer loop
                        break outerloop;
                    }
                }
            }
        }
        return isSelectionValid;
    }

    /**
     * set back to null the condition of the wells selected (for a certain Condition)
     * @param plateCondition 
     */
    public void resetWellsCondition(PlateCondition plateCondition) {
        //set plate condition of wells again to null
        for (WellGui wellGui : setupPlateController.getSetupPlatePanel().getWellGuiList()) {
            //get only the bigger default ellipse2D
            Ellipse2D ellipse = wellGui.getEllipsi().get(0);
            for (Rectangle rectangle : setupPlateController.getSetupPlatePanel().getRectangles().get(plateCondition)) {
                if (rectangle.contains(ellipse.getX(), ellipse.getY(), ellipse.getWidth(), ellipse.getHeight())) {
                    wellGui.getWell().setPlateCondition(null);
                }
            }
        }
    }

    /**
     * set back to null the conditions of all wells selected (for all conditions)
     */
    public void resetAllWellsCondition() {
        //set plate condition of all wells selected again to null
        for (PlateCondition plateCondition : setupConditionsController.getPlateConditionBindingList()) {
            resetWellsCondition(plateCondition);
        }
    }

    /**
     * this method checks experiment Info
     * @return messages to show if validation was not successful 
     */
    public List<String> validateExperimentInfo() {
        List<String> messages = new ArrayList<>();
        try {
            //if the selected project does not have already the current experiment number, set the experiment number
            if (!projectHasExperiment(((Project) experimentInfoPanel.getProjectJList().getSelectedValue()).getProjectid(), Integer.parseInt(experimentInfoPanel.getNumberTextField().getText()))) {
                experiment.setExperimentNumber(Integer.parseInt(experimentInfoPanel.getNumberTextField().getText()));
            } else {
                String message = "Experiment number " + experimentInfoPanel.getNumberTextField().getText() + " already exists for this project";
                messages.add(message);
                experimentInfoPanel.getNumberTextField().requestFocusInWindow();
            }

        } catch (NumberFormatException e) {
            messages.add("Please insert a valid Experiment Number");
            experimentInfoPanel.getNumberTextField().requestFocusInWindow();
        }
        if (messages.isEmpty()) {
            messages.addAll(ValidationUtils.validateObject(experiment));
        }
        return messages;
    }

    /**
     * validate PlateCondition, if PlateCondition is not valid, go back to the previous one
     * @param plateCondition
     * @return 
     */
    public boolean validateCondition(PlateCondition plateCondition) {
        boolean isValid = false;

        if (setupConditionsController.validateCondition(plateCondition).isEmpty()) {
            isValid = true;
        } else {
            String message = "";
            for (String string : setupConditionsController.validateCondition(plateCondition)) {
                message += string + "\n";
            }
            cellMissyController.showMessage(message, JOptionPane.WARNING_MESSAGE);
            setupConditionsController.getConditionsPanel().getConditionsJList().setSelectedIndex(setupConditionsController.getPreviousConditionIndex());
        }
        return isValid;
    }

    /*
     * private methods and classes
     */
    /**
     * initializes the experiment info panel
     */
    private void initExperimentInfoPanel() {
        //init projectJList
        projectBindingList = ObservableCollections.observableList(projectService.findAll());
        JListBinding jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE, projectBindingList, experimentInfoPanel.getProjectJList());
        bindingGroup.addBinding(jListBinding);
        //init instrument combo box
        instrumentBindingList = ObservableCollections.observableList(experimentService.findAllInstruments());
        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, instrumentBindingList, experimentInfoPanel.getInstrumentComboBox());
        bindingGroup.addBinding(jComboBoxBinding);
        //init magnification combo box
        magnificationBindingList = ObservableCollections.observableList(experimentService.findAllMagnifications());
        jComboBoxBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, magnificationBindingList, experimentInfoPanel.getMagnificationComboBox());
        bindingGroup.addBinding(jComboBoxBinding);

        bindingGroup.bind();
        //add experimentInfoPanel to parent panel
        setupExperimentPanel.getTopPanel().add(experimentInfoPanel, gridBagConstraints);

        //select first project in the ProjectList
        experimentInfoPanel.getProjectJList().setSelectedIndex(0);

        //set cell renderer for experimentJList
        experimentInfoPanel.getExperimentJList().setCellRenderer(new ExperimentsListRenderer());

        //date cannot be modified manually
        experimentInfoPanel.getDateChooser().getDateEditor().setEnabled(false);

        //get current date with Date()
        Date date = new Date();
        experimentInfoPanel.getDateChooser().setDate(date);

        ExperimentListener experimentListener = new ExperimentListener(setupExperimentPanel.getNextButton());
        experimentListener.registerDoc(experimentInfoPanel.getNumberTextField().getDocument());
        experimentListener.registerDoc(experimentInfoPanel.getPurposeTextArea().getDocument());
        experimentListener.registerDoc(((JTextField) experimentInfoPanel.getDateChooser().getDateEditor().getUiComponent()).getDocument());

        /**
         * add action listeners
         */
        //create new project: save it to DB and create folder on the server
        experimentInfoPanel.getCreateProjectButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!experimentInfoPanel.getProjectNumberTextField().getText().isEmpty()) {
                    try {
                        int projectNumber = Integer.parseInt(experimentInfoPanel.getProjectNumberTextField().getText());
                        //project description is not mandatory
                        String projectDescription = experimentInfoPanel.getDescriptionTextField().getText();
                        Project savedProject = projectService.setupProject(projectNumber, projectDescription, mainDirectory);

                        projectBindingList.add(savedProject);
                        experimentInfoPanel.getProjectNumberTextField().setText("");
                    } catch (PersistenceException exception) {
                        cellMissyController.showMessage("Project already present in the DB", JOptionPane.WARNING_MESSAGE);
                        experimentInfoPanel.getProjectNumberTextField().setText("");
                        experimentInfoPanel.getProjectNumberTextField().requestFocusInWindow();
                    } catch (NumberFormatException exception) {
                        cellMissyController.showMessage("Please insert a valid number", JOptionPane.WARNING_MESSAGE);
                        experimentInfoPanel.getProjectNumberTextField().setText("");
                        experimentInfoPanel.getProjectNumberTextField().requestFocusInWindow();
                    }
                } else {
                    cellMissyController.showMessage("Please insert a number for the project you want to create", JOptionPane.WARNING_MESSAGE);
                    experimentInfoPanel.getProjectNumberTextField().requestFocusInWindow();
                }
            }
        });

        /**
         * add mouse listeners
         */
        //show experiments for the project selected
        experimentInfoPanel.getProjectJList().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                //init experimentJList
                int locationToIndex = experimentInfoPanel.getProjectJList().locationToIndex(e.getPoint());
                if (experimentService.findExperimentNumbersByProjectId(projectBindingList.get(locationToIndex).getProjectid()) != null) {
                    experimentBindingList = ObservableCollections.observableList(experimentService.findExperimentsByProjectId(projectBindingList.get(locationToIndex).getProjectid()));
                    JListBinding jListBinding = SwingBindings.createJListBinding(UpdateStrategy.READ_WRITE, experimentBindingList, experimentInfoPanel.getExperimentJList());
                    bindingGroup.addBinding(jListBinding);
                    bindingGroup.bind();
                } else {
                    cellMissyController.showMessage("There are no experiments yet for this project!", JOptionPane.INFORMATION_MESSAGE);
                    if (experimentBindingList != null && !experimentBindingList.isEmpty()) {
                        experimentBindingList.clear();
                    }
                }
            }
        });
    }

    /**
     * Initialize the experiment set up panel
     */
    private void initSetupExperimentPanel() {
        //disable Next and Previous buttons
        setupExperimentPanel.getNextButton().setEnabled(false);
        setupExperimentPanel.getPreviousButton().setEnabled(false);
        //hide Report and Finish buttons
        setupExperimentPanel.getFinishButton().setVisible(false);
        setupExperimentPanel.getFinishButton().setEnabled(false);
        setupExperimentPanel.getReportButton().setVisible(false);
        setupExperimentPanel.getReportButton().setEnabled(false);
        setupExperimentPanel.getConditionsOverviewButton().setVisible(false);
        cellMissyController.updateInfoLabel(setupExperimentPanel.getInfolabel(), "Please select a project from the list and fill in experiment data");

        /**
         * add action listeners
         */
        setupExperimentPanel.getNextButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //create a new experiment (in progress)
                experiment = new Experiment();
                //check if the info was filled in properly
                if (cellMissyController.validateExperimentInfo()) {
                    experiment.setExperimentStatus(ExperimentStatus.IN_PROGRESS);
                    //set the User of the experiment
                    //@todo: need to set the user like this NOW, to be changed!!!=====================================================================================
                    experiment.setUser(cellMissyController.getAUser());
                    experiment.setProject((Project) experimentInfoPanel.getProjectJList().getSelectedValue());
                    experiment.setInstrument((Instrument) experimentInfoPanel.getInstrumentComboBox().getSelectedItem());
                    experiment.setMagnification((Magnification) experimentInfoPanel.getMagnificationComboBox().getSelectedItem());
                    experiment.setExperimentDate(experimentInfoPanel.getDateChooser().getDate());
                    experiment.setPurpose(experimentInfoPanel.getPurposeTextArea().getText());

                    //create experiment's folder structure on the server (the report needs to be saved in the setup subfolder)
                    experimentService.createFolderStructure(experiment);

                    //show the setupPanel and hide the experimentInfoPanel
                    GuiUtils.switchChildPanels(setupExperimentPanel.getTopPanel(), setupPanel, experimentInfoPanel);
                    cellMissyController.updateInfoLabel(setupExperimentPanel.getInfolabel(), "Add conditions and select wells for each condition. Conditions details can be chosen in the right panel.");
                    //enable the Previous Button
                    setupExperimentPanel.getPreviousButton().setEnabled(true);
                    setupExperimentPanel.getNextButton().setEnabled(false);
                    setupExperimentPanel.getFinishButton().setVisible(true);
                    if (setupExperimentPanel.getFinishButton().isEnabled()) {
                        setupExperimentPanel.getFinishButton().setEnabled(true);
                    } else {
                        setupExperimentPanel.getFinishButton().setEnabled(false);
                    }
                    setupExperimentPanel.getReportButton().setVisible(true);
                    setupExperimentPanel.getConditionsOverviewButton().setVisible(true);
                    setupExperimentPanel.getTopPanel().revalidate();
                    setupExperimentPanel.getTopPanel().repaint();
                }
            }
        });

        setupExperimentPanel.getPreviousButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiUtils.switchChildPanels(setupExperimentPanel.getTopPanel(), experimentInfoPanel, setupPanel);
                cellMissyController.updateInfoLabel(setupExperimentPanel.getInfolabel(), "Please select a project from the list and provide microscope/experiment data");
                setupExperimentPanel.getPreviousButton().setEnabled(false);
                setupExperimentPanel.getNextButton().setEnabled(true);
                setupExperimentPanel.getFinishButton().setVisible(false);
                setupExperimentPanel.getReportButton().setVisible(false);
                setupExperimentPanel.getConditionsOverviewButton().setVisible(false);
                setupExperimentPanel.getTopPanel().revalidate();
                setupExperimentPanel.getTopPanel().repaint();
            }
        });

        // show overview of conditions
        setupExperimentPanel.getConditionsOverviewButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateCondition(setupConditionsController.getCurrentCondition())) {
                    //update last condition of the experiment
                    updateLastCondition();
                    // new dialog
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);
                    dialog.setModal(true);
                    dialog.getContentPane().setBackground(Color.white);
                    dialog.getContentPane().setLayout(new BorderLayout());
                    //center the dialog on the main screen
                    dialog.setLocationRelativeTo(null);

                    createConditionsTable();
                    // add table to dialog
                    dialog.getContentPane().add(conditionsTable.getTableHeader(), BorderLayout.NORTH);
                    dialog.getContentPane().add(conditionsTable, BorderLayout.CENTER);
                    // show the dialog
                    dialog.pack();
                    dialog.setVisible(true);
                    setupExperimentPanel.getReportButton().setEnabled(true);
                }
            }
        });

        //create a pdf from the plate panel (ONLY if experiment set up is OK)
        setupExperimentPanel.getReportButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //set the experiment for each plate condition in the List
                for (PlateCondition plateCondition : setupConditionsController.getPlateConditionBindingList()) {
                    plateCondition.setExperiment(experiment);
                }
                //set experiment plate format
                experiment.setPlateFormat((PlateFormat) setupPlateController.getPlatePanelGui().getPlateFormatComboBox().getSelectedItem());
                //set the condition's collection of the experiment
                experiment.setPlateConditionCollection(setupConditionsController.getPlateConditionBindingList());

                //create PDF report, execute SwingWorker
                SetupReportWorker setupReportWorker = new SetupReportWorker();
                setupReportWorker.execute();

            }
        });

        //click on Finish button: save the experiment
        setupExperimentPanel.getFinishButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //save the new experiment to the DB
                experimentService.save(experiment);
                //disable button
                setupExperimentPanel.getFinishButton().setEnabled(false);
                showMessage("Experiment was successfully saved to DB.", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * this method checks if a well already has a condition
     * @param wellGui
     * @return true if a well already has a condition assigned
     */
    private boolean hasCondition(WellGui wellGui) {
        boolean hasCondition = false;
        Ellipse2D ellipse = wellGui.getEllipsi().get(0);
        for (List<Rectangle> list : setupPlateController.getSetupPlatePanel().getRectangles().values()) {
            for (Rectangle rectangle : list) {
                if (rectangle.contains(ellipse.getX(), ellipse.getY(), ellipse.getWidth(), ellipse.getHeight()) && wellGui.getWell().getPlateCondition() != null) {
                    hasCondition = true;
                }
            }
        }
        return hasCondition;
    }

    /**
     * add mouse listener to setup plate panel (Only when a condition is selected)
     */
    public void addMouseListener() {
        setupPlateController.addMouseListener();
    }

    /**
     * this class extends a document listener 
     * on "next" button
     */
    private class ExperimentListener implements DocumentListener {

        private List<Document> documentList = new ArrayList<>();
        private JButton button;

        public ExperimentListener(JButton button) {
            this.button = button;
        }

        public void registerDoc(Document document) {
            documentList.add(document);
            document.addDocumentListener(this);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            update();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            update();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            update();
        }

        //for each document check the lenght, when it's not zero enable the button
        private void update() {
            for (Document document : documentList) {
                if (document.getLength() == 0) {
                    button.setEnabled(false);
                    return;
                }
            }
            button.setEnabled(true);
        }
    }

    /**
     * this method checks if a project already has a certain experiment (checking for experiment number)
     * @param projectId
     * @param experimentNumber
     * @return 
     */
    private boolean projectHasExperiment(Integer projectId, Integer experimentNumber) {
        boolean hasExperiment = false;
        if (experimentService.findExperimentNumbersByProjectId(projectId) != null) {
            for (Integer number : experimentService.findExperimentNumbersByProjectId(projectId)) {
                if (number == experimentNumber) {
                    hasExperiment = true;
                }
            }
        }
        return hasExperiment;
    }

    /**
     * update last condition before creating the PDf report and saving the experiment
     */
    private void updateLastCondition() {
        setupConditionsController.updateCondition(setupConditionsController.getPlateConditionBindingList().size() - 1);
    }

    /**
     * SwingWorker to create PDF file (REPORT)
     */
    private class SetupReportWorker extends SwingWorker<File, Void> {

        private File setupReport;

        @Override
        protected File doInBackground() throws Exception {

            //disable the pdf report button and show a waiting cursor
            setupExperimentPanel.getReportButton().setEnabled(false);
            cellMissyController.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            setupReport = setupReportController.createSetupReport(experiment.getSetupFolder());
            return setupReport;
        }

        @Override
        protected void done() {
            try {
                get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
            try {
                //if export to PDF was successfull, open the PDF file from the desktop
                Desktop.getDesktop().open(setupReport);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            cellMissyController.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            setupExperimentPanel.getFinishButton().setEnabled(true);
            setupExperimentPanel.getReportButton().setEnabled(true);
        }
    }

    /**
     * reportPanel contains a JTable listing all the conditions and their setup details
     * @return 
     */
    private void createConditionsTable() {
        //creta a JTable
        //column names
        Object columnNames[] = {"Condition", "Cell Line", "MD", "Assay", "ECM", "Treatments", "Assay"};
        ObservableList<PlateCondition> plateConditionBindingList = setupConditionsController.getPlateConditionBindingList();
        //row data
        Object[][] data = new Object[plateConditionBindingList.size()][];
        for (int i = 0; i < data.length; i++) {
            PlateCondition plateCondition = plateConditionBindingList.get(i);
            data[i] = new Object[]{plateCondition.getName(), plateCondition.getCellLine(), plateCondition.getMatrixDimension(), plateCondition.getAssay().getAssayType(), plateCondition.getEcm(), plateCondition.getTreatmentCollection(), plateCondition.getAssayMedium()};
        }
        conditionsTable = new JTable(data, columnNames);
        conditionsTable.getColumnModel().setColumnSelectionAllowed(false);

        conditionsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        conditionsTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        conditionsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        conditionsTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        conditionsTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        conditionsTable.getColumnModel().getColumn(4).setPreferredWidth(90);
        conditionsTable.getColumnModel().getColumn(6).setPreferredWidth(90);
        
        conditionsTable.getColumnModel().getColumn(0).setMinWidth(50);
        conditionsTable.getColumnModel().getColumn(1).setMinWidth(50);
        conditionsTable.getColumnModel().getColumn(2).setMinWidth(50);
        conditionsTable.getColumnModel().getColumn(3).setMinWidth(50);
        conditionsTable.getColumnModel().getColumn(4).setMinWidth(90);
        conditionsTable.getColumnModel().getColumn(6).setMinWidth(90);

        //adjust table columns width (still need to set proper size) ***********
        for (int i = 0; i < conditionsTable.getColumnCount(); i++) {
            //set Cell Renderer for each column of the table
            conditionsTable.getColumnModel().getColumn(i).setCellRenderer(new SetupTableRenderer());
        }

    }
}
