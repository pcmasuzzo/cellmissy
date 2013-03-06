/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.experiment.analysis;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Paola Masuzzo
 */
public class MetaDataAnalysisPanel extends javax.swing.JPanel {

    public JComboBox getAlgorithmComboBox() {
        return algorithmComboBox;
    }

    public JRadioButton getCellCoveredAreaRadioButton() {
        return cellCoveredAreaRadioButton;
    }

    public JList getExperimentJList() {
        return experimentJList;
    }

    public JComboBox getImagingTypeComboBox() {
        return imagingTypeComboBox;
    }

    public JList getProjectJList() {
        return projectJList;
    }

    public JRadioButton getOpenAreaRadioButton() {
        return openAreaRadioButton;
    }

    public JTextArea getPurposeTextArea() {
        return purposeTextArea;
    }

    public JTextField getTimeFramesTextField() {
        return timeFramesTextField;
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JComboBox getAreaUnitOfMeasurementComboBox() {
        return areaUnitOfMeasurementComboBox;
    }

    public JTextField getInstrumentTextField() {
        return instrumentTextField;
    }

    public JTextField getMagnificationTextField() {
        return magnificationTextField;
    }

    /**
     * Creates new form MetaDataAnalysisPanel
     */
    public MetaDataAnalysisPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        generalPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectJList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        experimentJList = new javax.swing.JList();
        detailsPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        purposeTextArea = new javax.swing.JTextArea();
        userTextField = new javax.swing.JTextField();
        timeFramesTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        instrumentTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        magnificationTextField = new javax.swing.JTextField();
        userSelectionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        algorithmComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        imagingTypeComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cellCoveredAreaRadioButton = new javax.swing.JRadioButton();
        openAreaRadioButton = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        areaUnitOfMeasurementComboBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        generalPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        generalPanel.setOpaque(false);
        generalPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Select a project");

        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jScrollPane1.setViewportView(projectJList);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Select an experiment");

        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        experimentJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(experimentJList);

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(80, 80, 0, 0);
        add(generalPanel, gridBagConstraints);

        detailsPanel.setMinimumSize(new java.awt.Dimension(20, 20));
        detailsPanel.setOpaque(false);
        detailsPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel6.setText("Time frames");

        jLabel7.setText("Purpose:");

        jLabel10.setText("User:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Details of selected experiment");

        jScrollPane3.setOpaque(false);

        purposeTextArea.setEditable(false);
        purposeTextArea.setColumns(20);
        purposeTextArea.setRows(5);
        purposeTextArea.setOpaque(false);
        purposeTextArea.setPreferredSize(new java.awt.Dimension(170, 94));
        jScrollPane3.setViewportView(purposeTextArea);

        userTextField.setEditable(false);
        userTextField.setOpaque(false);

        timeFramesTextField.setEditable(false);
        timeFramesTextField.setOpaque(false);

        jLabel11.setText("Instrument");

        instrumentTextField.setEditable(false);
        instrumentTextField.setOpaque(false);

        jLabel12.setText("Magnification");

        magnificationTextField.setEditable(false);
        magnificationTextField.setOpaque(false);

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userTextField)
                            .addComponent(jScrollPane3)
                            .addComponent(instrumentTextField)
                            .addComponent(magnificationTextField)
                            .addComponent(timeFramesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        detailsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel6});

        detailsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {instrumentTextField, magnificationTextField, timeFramesTextField, userTextField});

        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(22, 22, 22)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(instrumentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(magnificationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(timeFramesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(80, 0, 0, 80);
        add(detailsPanel, gridBagConstraints);

        userSelectionPanel.setMaximumSize(new java.awt.Dimension(20, 20));
        userSelectionPanel.setOpaque(false);
        userSelectionPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel1.setText("Select a dataset");

        jLabel2.setText("Select an imaging type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Measured area is");

        cellCoveredAreaRadioButton.setText("cell covered area (wound closure)");

        openAreaRadioButton.setText("open area (wound area)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Area unit of measurement");

        javax.swing.GroupLayout userSelectionPanelLayout = new javax.swing.GroupLayout(userSelectionPanel);
        userSelectionPanel.setLayout(userSelectionPanelLayout);
        userSelectionPanelLayout.setHorizontalGroup(
            userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSelectionPanelLayout.createSequentialGroup()
                .addGroup(userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userSelectionPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)))
                .addGroup(userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cellCoveredAreaRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openAreaRadioButton)
                    .addComponent(areaUnitOfMeasurementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        userSelectionPanelLayout.setVerticalGroup(
            userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userSelectionPanelLayout.createSequentialGroup()
                        .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagingTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cellCoveredAreaRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openAreaRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(areaUnitOfMeasurementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(userSelectionPanelLayout.createSequentialGroup()
                        .addGroup(userSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userSelectionPanelLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2))
                            .addGroup(userSelectionPanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 80, 80, 80);
        add(userSelectionPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox algorithmComboBox;
    private javax.swing.JComboBox areaUnitOfMeasurementComboBox;
    private javax.swing.JRadioButton cellCoveredAreaRadioButton;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JList experimentJList;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JComboBox imagingTypeComboBox;
    private javax.swing.JTextField instrumentTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField magnificationTextField;
    private javax.swing.JRadioButton openAreaRadioButton;
    private javax.swing.JList projectJList;
    private javax.swing.JTextArea purposeTextArea;
    private javax.swing.JTextField timeFramesTextField;
    private javax.swing.JPanel userSelectionPanel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
