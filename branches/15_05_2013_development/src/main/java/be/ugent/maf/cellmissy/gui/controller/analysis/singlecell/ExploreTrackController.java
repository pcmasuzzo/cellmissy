/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.controller.analysis.singlecell;

import be.ugent.maf.cellmissy.entity.Track;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.entity.result.singlecell.ConvexHull;
import be.ugent.maf.cellmissy.entity.result.singlecell.GeometricPoint;
import be.ugent.maf.cellmissy.entity.result.singlecell.StepCentricDataHolder;
import be.ugent.maf.cellmissy.entity.result.singlecell.TrackDataHolder;
import be.ugent.maf.cellmissy.gui.experiment.analysis.singlecell.ExploreTrackPanel;
import be.ugent.maf.cellmissy.gui.experiment.analysis.singlecell.PlotSettingsRendererGiver;
import be.ugent.maf.cellmissy.gui.experiment.analysis.singlecell.PlotSettingsMenuBar;
import be.ugent.maf.cellmissy.gui.view.renderer.jfreechart.TimePointTrackXYLineAndShapeRenderer;
import be.ugent.maf.cellmissy.gui.view.renderer.jfreechart.TrackXYLineAndShapeRenderer;
import be.ugent.maf.cellmissy.gui.view.renderer.list.PlottedTracksListRenderer;
import be.ugent.maf.cellmissy.gui.view.renderer.table.TableHeaderRenderer;
import be.ugent.maf.cellmissy.gui.view.renderer.table.SingleCellDataTableRenderer;
import be.ugent.maf.cellmissy.gui.view.table.model.ConvexHullTableModel;
import be.ugent.maf.cellmissy.gui.view.table.model.TrackDataHolderTableModel;
import be.ugent.maf.cellmissy.utils.AnalysisUtils;
import be.ugent.maf.cellmissy.utils.GuiUtils;
import be.ugent.maf.cellmissy.utils.JFreeChartUtils;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.commons.lang.ArrayUtils;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JListBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * This controller takes care of logic for exploring a track. Parent controller:
 * track coordinates controller.
 *
 * @author Paola Masuzzo <paola.masuzzo@ugent.be>
 */
@Controller("exploreTrackController")
public class ExploreTrackController {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ExploreTrackController.class);
    // model
    private BindingGroup bindingGroup;
    private PlayTrackSwingWorker playTrackSwingWorker;
    // view
    private ExploreTrackPanel exploreTrackPanel;
    private PlotSettingsMenuBar plotSettingsMenuBar;
    private ChartPanel coordinatesChartPanel;
    private ChartPanel xYTCoordinateChartPanel;
    private ChartPanel directionalityRatioChartPanel;
    private ChartPanel directionAutocorrelationsChartPanel;
    private ChartPanel singleTrackCoordinatesChartPanel;
    private ChartPanel convexHullChartPanel;
    // parent controller
    @Autowired
    private TrackCoordinatesController trackCoordinatesController;
    // child controller
    // services
    private GridBagConstraints gridBagConstraints;

    /**
     * Initialize controller
     */
    public void init() {
        bindingGroup = new BindingGroup();
        gridBagConstraints = GuiUtils.getDefaultGridBagConstraints();
        initPlotSettingsMenuBar();
        // init main view
        initExploreTrackPanel();
    }

    /**
     * Getters
     */
    public ChartPanel getCoordinatesChartPanel() {
        return coordinatesChartPanel;
    }

    public ExploreTrackPanel getExploreTrackPanel() {
        return exploreTrackPanel;
    }

    /**
     * Set cursor from main controller
     *
     * @param type
     */
    public void setCursor(Cursor cursor) {
        trackCoordinatesController.setCursor(cursor);
    }

    /**
     * Show message through the main controller
     *
     * @param message
     * @param title
     * @param messageType
     */
    public void showMessage(String message, String title, Integer messageType) {
        trackCoordinatesController.showMessage(message, title, messageType);
    }

    /**
     * Private methods
     */
    /**
     * Action performed on selection of a single track: set the renderer for the
     * x y plot and control some GUI elements.
     *
     * @param selectedTrackIndex: the index of the selected track
     */
    private void onSelectedTrack(int selectedTrackIndex) {
        TrackDataHolder selectedTrackDataHolder = trackCoordinatesController.getTrackDataHolderBindingList().get(selectedTrackIndex);
        // set up and enable the time /slider here
        setupTimeSlider(selectedTrackDataHolder);
        updateTrackData(selectedTrackDataHolder);
        updateConvexHullData(selectedTrackDataHolder);
        boolean plotLines = plotSettingsMenuBar.getPlotLinesCheckBoxMenuItem().isSelected();
        boolean plotPoints = plotSettingsMenuBar.getPlotPointsCheckBoxMenuItem().isSelected();
        boolean showEndPoints = plotSettingsMenuBar.getShowEndPointsCheckBoxMenuItem().isSelected();
        Float lineWidth = plotSettingsMenuBar.getSelectedLineWidth();
        TrackXYLineAndShapeRenderer trackXYLineAndShapeRenderer = new TrackXYLineAndShapeRenderer(plotLines, plotPoints, showEndPoints, trackCoordinatesController.getEndPoints(), selectedTrackIndex, lineWidth);
        coordinatesChartPanel.getChart().getXYPlot().setRenderer(trackXYLineAndShapeRenderer);
    }

    /**
     * Private classes and methods
     */
    /**
     * Initialize plot settings menu bar
     */
    private void initPlotSettingsMenuBar() {
        // create new object
        plotSettingsMenuBar = new PlotSettingsMenuBar();
        /**
         * Add item listeners to the menu items
         */
        ItemActionListener itemActionListener = new ItemActionListener();
        plotSettingsMenuBar.getPlotLinesCheckBoxMenuItem().addItemListener(itemActionListener);
        plotSettingsMenuBar.getPlotPointsCheckBoxMenuItem().addItemListener(itemActionListener);
        plotSettingsMenuBar.getShowEndPointsCheckBoxMenuItem().addItemListener(itemActionListener);
        for (Enumeration<AbstractButton> buttons = plotSettingsMenuBar.getLinesButtonGroup().getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.addItemListener(itemActionListener);
        }
    }

    /**
     * Initialize main view
     */
    private void initExploreTrackPanel() {
        // new view
        exploreTrackPanel = new ExploreTrackPanel();
        ObservableList<TrackDataHolder> trackDataHolderBindingList = trackCoordinatesController.getTrackDataHolderBindingList();
        // init jlist binding: track data holders
        JListBinding jListBinding = SwingBindings.createJListBinding(AutoBinding.UpdateStrategy.READ_WRITE, trackDataHolderBindingList, exploreTrackPanel.getTracksList());
        bindingGroup.addBinding(jListBinding);
        // do the binding
        bindingGroup.bind();
        // set cell renderer for the tracks list
        exploreTrackPanel.getTracksList().setCellRenderer(new PlottedTracksListRenderer(trackDataHolderBindingList));
        //init chart panels
        coordinatesChartPanel = new ChartPanel(null);
        coordinatesChartPanel.setOpaque(false);
        exploreTrackPanel.getGraphicsParentPanel().add(coordinatesChartPanel, gridBagConstraints);
        xYTCoordinateChartPanel = new ChartPanel(null);
        xYTCoordinateChartPanel.setOpaque(false);
        directionalityRatioChartPanel = new ChartPanel(null);
        directionalityRatioChartPanel.setOpaque(false);
        directionAutocorrelationsChartPanel = new ChartPanel(null);
        directionAutocorrelationsChartPanel.setOpaque(false);
        singleTrackCoordinatesChartPanel = new ChartPanel(null);
        singleTrackCoordinatesChartPanel.setOpaque(false);
        convexHullChartPanel = new ChartPanel(null);
        convexHullChartPanel.setOpaque(false);

        exploreTrackPanel.getxYTCoordinatesParentPanel().add(xYTCoordinateChartPanel, gridBagConstraints);
        exploreTrackPanel.getDirectionalityRatioGraphicsParentPanel().add(directionalityRatioChartPanel, gridBagConstraints);
        exploreTrackPanel.getDirectionAutocorrelationsGraphicsParentPanel().add(directionAutocorrelationsChartPanel, gridBagConstraints);
        exploreTrackPanel.getCoordinatesParentPanel().add(singleTrackCoordinatesChartPanel, gridBagConstraints);
        exploreTrackPanel.getConvexHullGraphicsParentPanel().add(convexHullChartPanel, gridBagConstraints);

        exploreTrackPanel.getTrackDataTable().getTableHeader().setDefaultRenderer(new TableHeaderRenderer(SwingConstants.RIGHT));
        exploreTrackPanel.getTrackDataTable().getTableHeader().setReorderingAllowed(false);
        exploreTrackPanel.getConvexHullTable().getTableHeader().setDefaultRenderer(new TableHeaderRenderer(SwingConstants.RIGHT));
        exploreTrackPanel.getConvexHullTable().getTableHeader().setReorderingAllowed(false);

        // add chart mouse listener to the chart panel: clicking on a track will make the track selected in the list and it will be highlighed in the plot
        coordinatesChartPanel.addChartMouseListener(new ChartMouseListener() {
            @Override
            public void chartMouseClicked(ChartMouseEvent e) {
                // get the entity on from which the chart mouse event has been generated
                ChartEntity chartEntity = e.getEntity();
                // check that we don't click just on the background of the plot
                if (chartEntity instanceof XYItemEntity) {
                    XYItemEntity xYItemEntity = (XYItemEntity) e.getEntity();
                    // get the series to highlight in the list and in the plot
                    int seriesIndex = xYItemEntity.getSeriesIndex();
                    exploreTrackPanel.getTracksList().setSelectedIndex(seriesIndex);
                    // scroll the list to the selected index
                    exploreTrackPanel.getTracksList().ensureIndexIsVisible(seriesIndex);
                    onSelectedTrack(seriesIndex);
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent e) {
            }
        });

        exploreTrackPanel.getGraphicsParentPanel().add(coordinatesChartPanel, gridBagConstraints);
        // add change listener to the slider
        exploreTrackPanel.getTimeSlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                // we don't check for the adjustment of the value, because we want a continuous time scale
                int selectedTrackIndex = exploreTrackPanel.getTracksList().getSelectedIndex();
                if (selectedTrackIndex != -1) {
                    // get the current time value from the slider
                    int timePoint = (int) source.getValue();
                    // show the track point in time: basically set the renderer for the chart
                    showTrackPointInTime(selectedTrackIndex, timePoint);
                    // update x and y coordinates field
                    updateCoordinatesInfoInTime(selectedTrackIndex, timePoint);
                }
            }
        });

        // action listeners
        exploreTrackPanel.getPlayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTrackIndex = exploreTrackPanel.getTracksList().getSelectedIndex();
                if (selectedTrackIndex != -1) {
                    playTrack(selectedTrackIndex);
                }
            }
        });

        exploreTrackPanel.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check for the status of the start button, if enables, worker is ongoing, we can stop it
                if (!exploreTrackPanel.getPlayButton().isEnabled()) {
                    // stop the worker
                    playTrackSwingWorker.cancel(true);
                    // enable the play button
                    exploreTrackPanel.getPlayButton().setEnabled(true);
                }
            }
        });

        // select a track and highlight it in the current plot
        exploreTrackPanel.getTracksList().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedTrackIndex = exploreTrackPanel.getTracksList().getSelectedIndex();
                    if (selectedTrackIndex != -1) {
                        onSelectedTrack(selectedTrackIndex);
                    }
                }
            }
        });

        // clear selection on the tracks list
        exploreTrackPanel.getClearSelectionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClearSelection();
            }
        });

        exploreTrackPanel.getPlotSettingsPanel().add(plotSettingsMenuBar, BorderLayout.EAST);

        // add view to parent panel
        trackCoordinatesController.getTrackCoordinatesPanel().getExploreTrackParentPanel().add(exploreTrackPanel, gridBagConstraints);
    }

    /**
     * On clear selection on the list
     */
    private void onClearSelection() {
        // clear the selection on the list
        exploreTrackPanel.getTracksList().clearSelection();
        // refresh the plot
        JFreeChart coordinatesChart = coordinatesChartPanel.getChart();
        JFreeChartUtils.setupTrackChart(coordinatesChart);
        boolean plotLines = plotSettingsMenuBar.getPlotLinesCheckBoxMenuItem().isSelected();
        boolean plotPoints = plotSettingsMenuBar.getPlotPointsCheckBoxMenuItem().isSelected();
        boolean showEndPoints = plotSettingsMenuBar.getShowEndPointsCheckBoxMenuItem().isSelected();
        int selectedTrackIndex = exploreTrackPanel.getTracksList().getSelectedIndex();
        Float lineWidth = plotSettingsMenuBar.getSelectedLineWidth();
        TrackXYLineAndShapeRenderer trackXYLineAndShapeRenderer = new TrackXYLineAndShapeRenderer(plotLines, plotPoints, showEndPoints, trackCoordinatesController.getEndPoints(), selectedTrackIndex, lineWidth);
        coordinatesChart.getXYPlot().setRenderer(trackXYLineAndShapeRenderer);
        // @todo: reset the time slider, null pointer exception !
//        exploreTrackPanel.getTimeSlider().setLabelTable(null);
    }

    /**
     * Action Listener for MenuItems
     */
    private class ItemActionListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            int selectedTrackIndex = exploreTrackPanel.getTracksList().getSelectedIndex();
            List<Integer> endPoints = trackCoordinatesController.getEndPoints();
            PlotSettingsRendererGiver plotSettingsRendererGiver = new PlotSettingsRendererGiver(selectedTrackIndex, plotSettingsMenuBar, endPoints);
            TrackXYLineAndShapeRenderer renderer = plotSettingsRendererGiver.getRenderer(e);
            coordinatesChartPanel.getChart().getXYPlot().setRenderer(renderer);
        }
    }

    /**
     * Given a track and a time point, get current x and y positions and update
     * info.
     *
     * @param selectedTrackIndex
     * @param timePoint
     */
    private void updateCoordinatesInfoInTime(int selectedTrackIndex, int timePoint) {
        // update x and y coordinates field
        XYDataset dataset = coordinatesChartPanel.getChart().getXYPlot().getDataset();
        double xValue = dataset.getXValue(selectedTrackIndex, timePoint);
        double yValue = dataset.getYValue(selectedTrackIndex, timePoint);
        exploreTrackPanel.getxTextField().setText(" " + xValue);
        exploreTrackPanel.getyTextField().setText(" " + yValue);
    }

    /**
     * Set up a time slider: this will depend on the selected track data, since
     * each track has been detected for a different time interval.
     *
     * @param selectedTrackDataHolder
     */
    private void setupTimeSlider(TrackDataHolder selectedTrackDataHolder) {
        JSlider timeSlider = exploreTrackPanel.getTimeSlider();
        double[] timeIndexes = selectedTrackDataHolder.getStepCentricDataHolder().getTimeIndexes();
        timeSlider.setMinimum(0);
        int numberOfTimePoints = timeIndexes.length;
        int spacing = (int) numberOfTimePoints / 5;
        timeSlider.setMaximum(numberOfTimePoints - 1); // this triggers the stateChanged
        timeSlider.setMajorTickSpacing(spacing);
        timeSlider.setPaintTicks(true);
        timeSlider.setPaintLabels(true);
        timeSlider.setValue(0); // this triggers the stateChanged
        Hashtable labelsTable = new Hashtable();
        // adjust the labels of the time slider to actually show the real time points
        for (int i = 0; i < numberOfTimePoints - 1; i++) {
            double actualTimePoint = timeIndexes[i];
            labelsTable.put(i, new JLabel("" + actualTimePoint));
            i += spacing - 1;
        }
        timeSlider.setLabelTable(labelsTable);
    }

    /**
     * Show the evolution of a track in time: while sliding on the time slide, a
     * cell is followed in time and a spot is highlighted.
     *
     * @param trackSeriesIndex: the series (track) index
     * @param currentTimePoint: the actual time point to highlight
     */
    private void showTrackPointInTime(int selectedTrackIndex, int timePoint) {
        // get the xyplot from the chart and set it up
        XYPlot xyPlot = coordinatesChartPanel.getChart().getXYPlot();
        Float selectedLineWidth = plotSettingsMenuBar.getSelectedLineWidth();
        TimePointTrackXYLineAndShapeRenderer timePointTrackXYLineAndShapeRenderer = new TimePointTrackXYLineAndShapeRenderer(selectedTrackIndex, timePoint, selectedLineWidth);
        xyPlot.setRenderer(timePointTrackXYLineAndShapeRenderer);
    }

    /**
     * Play a track in time (using a swing worker).
     *
     * @param selectedTrackIndex
     */
    private void playTrack(int selectedTrackIndex) {
        // create a bnew instance of the play swing worker and execute it
        playTrackSwingWorker = new PlayTrackSwingWorker(selectedTrackIndex);
        playTrackSwingWorker.execute();
    }

    /**
     * Update data in the table for the selected track.
     *
     * @param trackDataHolder
     */
    private void updateTrackData(TrackDataHolder trackDataHolder) {
        // plot the data associated with the current track
        plotSingleTrackData(trackDataHolder);
        // update model for the track table
        exploreTrackPanel.getTrackDataTable().setModel(new TrackDataHolderTableModel(trackDataHolder));
        SingleCellDataTableRenderer singleCellDataTableRenderer = new SingleCellDataTableRenderer(new DecimalFormat("###.###"));
        for (int i = 0; i < exploreTrackPanel.getTrackDataTable().getColumnCount(); i++) {
            exploreTrackPanel.getTrackDataTable().getColumnModel().getColumn(i).setCellRenderer(singleCellDataTableRenderer);
        }
        for (int i = 0; i < exploreTrackPanel.getTrackDataTable().getColumnCount(); i++) {
            GuiUtils.packColumn(exploreTrackPanel.getTrackDataTable(), i, 1);
        }
    }

    /**
     * Update measurements of convex hull for a given selected track.
     *
     * @param trackDataHolder
     */
    private void updateConvexHullData(TrackDataHolder trackDataHolder) {
        // upate convex hull data in table
        ConvexHull convexHull = trackDataHolder.getCellCentricDataHolder().getConvexHull();
        exploreTrackPanel.getConvexHullTable().setModel(new ConvexHullTableModel(convexHull));
        SingleCellDataTableRenderer singleCellDataTableRenderer = new SingleCellDataTableRenderer(new DecimalFormat("###.###"));
        for (int i = 0; i < exploreTrackPanel.getConvexHullTable().getColumnCount(); i++) {
            exploreTrackPanel.getConvexHullTable().getColumnModel().getColumn(i).setCellRenderer(singleCellDataTableRenderer);
        }
        for (int i = 0; i < exploreTrackPanel.getConvexHullTable().getColumnCount(); i++) {
            GuiUtils.packColumn(exploreTrackPanel.getConvexHullTable(), i, 1);
        }
    }

    /**
     * Make the plots for the single track.
     *
     * @param trackDataHolder
     */
    private void plotSingleTrackData(TrackDataHolder trackDataHolder) {
        // plot the shifted track coordinates
        plotCoordinatesInSpace(trackDataHolder);
        // plot x and y coordinates in time
        plotCoordinatesInTime(trackDataHolder);
        // plot the convex hull of the track
        plotConvexHull(trackDataHolder);
        // plot the directionality ratio in time
        plotDirectionalityRatioInTime(trackDataHolder);
        // plot the direction autocorrelation coefficients in time
        plotDirectionAutocorrelationInTime(trackDataHolder);
    }

    /**
     * Plot x and y coordinates in time for the given track.
     *
     * @param track
     */
    private void plotCoordinatesInTime(TrackDataHolder trackDataHolder) {
        // get the selected track data holder, and thus the track to plot in time
        Track track = trackDataHolder.getTrack();
        // get the track coordinates matrix
        Double[][] trackCoordinatesMatrix = trackDataHolder.getStepCentricDataHolder().getCoordinatesMatrix();
        // we need to transpose the matrix
        Double[][] transpose2DArray = AnalysisUtils.transpose2DArray(trackCoordinatesMatrix);
        // we get the x coordinates and the time information
        double[] xCoordinates = ArrayUtils.toPrimitive(AnalysisUtils.excludeNullValues(transpose2DArray[0]));
        double[] timeIndexes = trackDataHolder.getStepCentricDataHolder().getTimeIndexes();
        // we create the series and set its key
        XYSeries xtSeries = JFreeChartUtils.generateXYSeries(timeIndexes, xCoordinates);
        int trackNumber = track.getTrackNumber();
        Well well = track.getWellHasImagingType().getWell();
        String seriesKey = "track " + trackNumber + ", well " + well;
        xtSeries.setKey(seriesKey);
        // we then create the XYSeriesCollection and use it to make a new line chart
        XYSeriesCollection xtSeriesCollection = new XYSeriesCollection(xtSeries);
        XYItemRenderer renderer = new StandardXYItemRenderer();
        NumberAxis xAxis = new NumberAxis("x (µm)");
        XYPlot xTPlot = new XYPlot(xtSeriesCollection, null, xAxis, renderer);
        // y axis
        NumberAxis yAxis = new NumberAxis("y (µm)");
        // we repeat exactly the same with the y coordinates in time
        double[] yCoordinates = ArrayUtils.toPrimitive(AnalysisUtils.excludeNullValues(transpose2DArray[1]));
        XYSeries ytSeries = JFreeChartUtils.generateXYSeries(timeIndexes, yCoordinates);
        ytSeries.setKey(seriesKey);
        XYSeriesCollection ytSeriesCollection = new XYSeriesCollection(ytSeries);
        XYPlot yTPlot = new XYPlot(ytSeriesCollection, null, yAxis, renderer);
        // domain axis
        NumberAxis domainAxis = new NumberAxis("time index");
        CombinedDomainXYPlot combinedDomainXYPlot = new CombinedDomainXYPlot(domainAxis);
        combinedDomainXYPlot.setRenderer(new XYLineAndShapeRenderer());
        combinedDomainXYPlot.add(xTPlot);
        combinedDomainXYPlot.add(yTPlot);
        combinedDomainXYPlot.setOrientation(PlotOrientation.VERTICAL);
        JFreeChart combinedChart = new JFreeChart(seriesKey, JFreeChartUtils.getChartFont(), combinedDomainXYPlot, Boolean.FALSE);
        JFreeChartUtils.setupCombinedChart(combinedChart, trackCoordinatesController.getTrackDataHolderBindingList().indexOf(trackDataHolder));
        xYTCoordinateChartPanel.setChart(combinedChart);
    }

    /**
     * Plot Directionality Ratio in time for a given track.
     *
     * @param trackDataHolder
     */
    private void plotDirectionalityRatioInTime(TrackDataHolder trackDataHolder) {
        StepCentricDataHolder stepCentricDataHolder = trackDataHolder.getStepCentricDataHolder();
        Track track = trackDataHolder.getTrack();
        Double[] directionalityRatios = stepCentricDataHolder.getDirectionalityRatios(); // y axis: the directionality values
        double[] timeIndexes = stepCentricDataHolder.getTimeIndexes(); // x axis: time points
        double[] directionalityValues = ArrayUtils.toPrimitive(AnalysisUtils.excludeNullValues(directionalityRatios));
        // we create the series and set its key
        XYSeries ytSeries = JFreeChartUtils.generateXYSeries(timeIndexes, directionalityValues);
        int trackNumber = track.getTrackNumber();
        Well well = track.getWellHasImagingType().getWell();
        String seriesKey = "track " + trackNumber + ", well " + well;
        ytSeries.setKey(seriesKey);
        // we then create the XYSeriesCollection and use it to make a new line chart
        XYSeriesCollection ytSeriesCollection = new XYSeriesCollection(ytSeries);
        JFreeChart directionalityRatioChart = ChartFactory.createXYLineChart(seriesKey + " - Directionality Ratio", "time index", "directionality ratio", ytSeriesCollection, PlotOrientation.VERTICAL, false, true, false);
        JFreeChartUtils.setupSingleTrackPlot(directionalityRatioChart, trackCoordinatesController.getTrackDataHolderBindingList().indexOf(trackDataHolder), true);
        directionalityRatioChartPanel.setChart(directionalityRatioChart);
    }

    /**
     * Plot the Direction autocorrelation coefficients in time for a given
     * track.F
     *
     * @param trackDataHolder
     */
    private void plotDirectionAutocorrelationInTime(TrackDataHolder trackDataHolder) {
        StepCentricDataHolder stepCentricDataHolder = trackDataHolder.getStepCentricDataHolder();
        Track track = trackDataHolder.getTrack();
        int trackNumber = track.getTrackNumber();
        Well well = track.getWellHasImagingType().getWell();
        // each element of the list is an array of double containing the coefficients computed at overlapping time intervals
        List<Double[]> directionAutocorrelationsList = stepCentricDataHolder.getDirectionAutocorrelations();
        Double[] meanDirectionAutocorrelations = stepCentricDataHolder.getMeanDirectionAutocorrelations();
        double[] timeIndexes = stepCentricDataHolder.getTimeIndexes(); // x axis: time points
        double[] timePoints = new double[timeIndexes.length];
        for (int i = 0; i < timePoints.length; i++) {
            timePoints[i] = i + 1;
        }
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        // first series with the mean coefficients
        XYSeries xySeries = JFreeChartUtils.generateXYSeries(timePoints, ArrayUtils.toPrimitive(meanDirectionAutocorrelations));
        String seriesKey = "track " + trackNumber + ", well " + well + "_mean coefficient";
        xySeries.setKey(seriesKey);
        xySeriesCollection.addSeries(xySeries);
        // now all the rest
        for (int i = 0; i < directionAutocorrelationsList.size(); i++) {
            Double[] coefficients = directionAutocorrelationsList.get(i);
            double[] toPrimitive = ArrayUtils.toPrimitive(coefficients);
            xySeries = JFreeChartUtils.generateXYSeries(timePoints[i], toPrimitive);
            seriesKey = "track " + trackNumber + ", well " + well + "_" + i;
            xySeries.setKey(seriesKey);
            xySeriesCollection.addSeries(xySeries);
        }
        JFreeChart directionAutocorrelationsChart = ChartFactory.createScatterPlot("Direction Autocorrelation", "time index", "direction autocorrelation", xySeriesCollection, PlotOrientation.VERTICAL, false, true, false);
        JFreeChartUtils.setupDirectionAutocorrelationPlot(directionAutocorrelationsChart, trackCoordinatesController.getTrackDataHolderBindingList().indexOf(trackDataHolder));
        directionAutocorrelationsChartPanel.setChart(directionAutocorrelationsChart);
    }

    /**
     * Plot the shifted track coordinates for the current track. We get the
     * current track from the selected track data holder object.
     *
     * @param trackDataHolder
     */
    private void plotCoordinatesInSpace(TrackDataHolder trackDataHolder) {
        // get the coordinates matrix
        Double[][] shiftedCoordinatesMatrix = trackDataHolder.getStepCentricDataHolder().getShiftedCooordinatesMatrix();
        XYSeries xYSeries = JFreeChartUtils.generateXYSeries(shiftedCoordinatesMatrix);
        Track track = trackDataHolder.getTrack();
        int trackNumber = track.getTrackNumber();
        Well well = track.getWellHasImagingType().getWell();
        String seriesKey = "track " + trackNumber + ", well " + well;
        xYSeries.setKey(seriesKey);
        XYSeriesCollection ySeriesCollection = new XYSeriesCollection(xYSeries);
        JFreeChart shiftedCoordinatesChart = ChartFactory.createXYLineChart(seriesKey + " - shifted coordinates", "x (µm)", "y (µm)", ySeriesCollection, PlotOrientation.VERTICAL, false, true, false);
        JFreeChartUtils.setupSingleTrackPlot(shiftedCoordinatesChart, trackCoordinatesController.getTrackDataHolderBindingList().indexOf(trackDataHolder), false);
        singleTrackCoordinatesChartPanel.setChart(shiftedCoordinatesChart);
    }

    /**
     * Given a track data holder, plot the track coordinates surrounded by the
     * convex hull computed for the set of points that belong to the track.
     *
     * @param trackDataHolder
     */
    private void plotConvexHull(TrackDataHolder trackDataHolder) {
        ConvexHull convexHull = trackDataHolder.getCellCentricDataHolder().getConvexHull();
        Iterable<GeometricPoint> cHull = convexHull.getHull();
        int M = 0;
        for (GeometricPoint point : cHull) {
            M++;
        }
        // the hull, in counterclockwise order
        GeometricPoint[] hull = new GeometricPoint[M];
        int m = 0;
        for (GeometricPoint point : cHull) {
            hull[m++] = point;
        }
        // generate xy coordinates for the points of the hull
        double[] x = new double[m + 1];
        double[] y = new double[m + 1];
        for (int i = 0; i < m; i++) {
            GeometricPoint point = hull[i];
            x[i] = point.getX();
            y[i] = point.getY();
        }
        // repeat fisrt coordinates at the end, to close the polygon
        x[m] = hull[0].getX();
        y[m] = hull[0].getY();
        // get info for the title of the plot
        Track track = trackDataHolder.getTrack();
        int trackNumber = track.getTrackNumber();
        Well well = track.getWellHasImagingType().getWell();
        String seriesKey = "track " + trackNumber + ", well " + well;
        // dataset for the convex hull
        XYSeries hullSeries = JFreeChartUtils.generateXYSeries(x, y);
        XYSeriesCollection hullDataset = new XYSeriesCollection(hullSeries);
        JFreeChart convexHullChart = ChartFactory.createXYLineChart(seriesKey + " - convex hull", "x (µm)", "y (µm)", hullDataset, PlotOrientation.VERTICAL, false, true, false);
        // dataset for the coordinates
        Double[][] coordinatesMatrix = trackDataHolder.getStepCentricDataHolder().getCoordinatesMatrix();
        XYSeries coordinatesSeries = JFreeChartUtils.generateXYSeries(coordinatesMatrix);
        XYSeriesCollection coordinatesDataset = new XYSeriesCollection(coordinatesSeries);
        // use both datasets for the plot
        XYPlot xyPlot = convexHullChart.getXYPlot();
        xyPlot.setDataset(0, coordinatesDataset);
        xyPlot.setDataset(1, hullDataset);
        // set up the chart
        int trackIndex = trackCoordinatesController.getTrackDataHolderBindingList().indexOf(trackDataHolder);
        JFreeChartUtils.setupConvexHullChart(convexHullChart, trackIndex);
        convexHullChartPanel.setChart(convexHullChart);
    }

    /**
     *
     */
    private class PlayTrackSwingWorker extends SwingWorker<Void, Void> {

        private int selectedTrackIndex;

        public PlayTrackSwingWorker(int selectedTrackIndex) {
            this.selectedTrackIndex = selectedTrackIndex;
        }

        @Override
        protected Void doInBackground() throws Exception {
            // disable play button
            exploreTrackPanel.getPlayButton().setEnabled(false);
            TrackDataHolder trackDataHolder = trackCoordinatesController.getTrackDataHolderBindingList().get(selectedTrackIndex);
            double[] timeIndexes = trackDataHolder.getStepCentricDataHolder().getTimeIndexes();
            for (int i = 0; i < timeIndexes.length; i++) {
                showTrackPointInTime(selectedTrackIndex, i);
                Thread.sleep(50);
            }
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
                // enable play button
                exploreTrackPanel.getPlayButton().setEnabled(true);
            } catch (InterruptedException | ExecutionException | CancellationException ex) {
                LOG.error("play track cancelled");
            }
        }
    }
}
