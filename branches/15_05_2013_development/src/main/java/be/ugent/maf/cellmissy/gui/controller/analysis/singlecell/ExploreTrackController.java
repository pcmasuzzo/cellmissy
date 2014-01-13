/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.gui.controller.analysis.singlecell;

import be.ugent.maf.cellmissy.entity.Track;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.entity.result.singlecell.ConvexHull;
import be.ugent.maf.cellmissy.entity.result.singlecell.GeometricPoint;
import be.ugent.maf.cellmissy.entity.result.singlecell.TrackDataHolder;
import be.ugent.maf.cellmissy.gui.experiment.analysis.singlecell.ExploreTrackPanel;
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
import java.awt.GridBagConstraints;
import java.text.DecimalFormat;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
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
    // view
    private ExploreTrackPanel exploreTrackPanel;
    private ChartPanel coordinatesChartPanel;
    private ChartPanel xYTCoordinateChartPanel;
    private ChartPanel singleTrackCoordinatesChartPanel;
    private ChartPanel convexHullChartPanel;
    // parent controller
    @Autowired
    private TrackCoordinatesController trackCoordinatesController;
    // services
    private GridBagConstraints gridBagConstraints;

    /**
     * Initialize controller
     */
    public void init() {
        bindingGroup = new BindingGroup();
        gridBagConstraints = GuiUtils.getDefaultGridBagConstraints();
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
     * Public methods
     */
    /**
     * Action performed on selection of a single track: set the renderer for the
     * x y plot and control some GUI elements.
     *
     * @param selectedTrackIndex: the index of the selected track
     */
    public void onSelectedTrack(int selectedTrackIndex) {
        TrackXYLineAndShapeRenderer trackXYLineAndShapeRenderer = new TrackXYLineAndShapeRenderer(true, false, false, null, selectedTrackIndex, JFreeChartUtils.getLineWidths().get(2));
        coordinatesChartPanel.getChart().getXYPlot().setRenderer(trackXYLineAndShapeRenderer);
        TrackDataHolder selectedTrackDataHolder = trackCoordinatesController.getTrackDataHolderBindingList().get(selectedTrackIndex);
        // set up and enable the time /slider here
        setupTimeSlider(selectedTrackDataHolder);
        updateTrackData(selectedTrackDataHolder);
        updateConvexHullData(selectedTrackDataHolder);
    }

    /**
     * Private classes and methods
     */
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
        singleTrackCoordinatesChartPanel = new ChartPanel(null);
        singleTrackCoordinatesChartPanel.setOpaque(false);
        convexHullChartPanel = new ChartPanel(null);
        convexHullChartPanel.setOpaque(false);

        exploreTrackPanel.getxYTCoordinatesParentPanel().add(xYTCoordinateChartPanel, gridBagConstraints);
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

        // select a track and highlight it in the current plot
        exploreTrackPanel.getTracksList().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedTrackIndex = exploreTrackPanel.getTracksList().getSelectedIndex();
                    if (selectedTrackIndex != -1) {
                        trackCoordinatesController.getTrackCoordinatesPanel().getPlottedTracksJList().setSelectedIndex(selectedTrackIndex);
                        onSelectedTrack(selectedTrackIndex);
                    }
                }
            }
        });
        // add view to parent panel
        trackCoordinatesController.getTrackCoordinatesPanel().getExploreTrackParentPanel().add(exploreTrackPanel, gridBagConstraints);
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
        double[] timeIndexes = selectedTrackDataHolder.getTimeIndexes();
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
        TimePointTrackXYLineAndShapeRenderer timePointTrackXYLineAndShapeRenderer = new TimePointTrackXYLineAndShapeRenderer(selectedTrackIndex, timePoint, JFreeChartUtils.getLineWidths().get(2));
        xyPlot.setRenderer(timePointTrackXYLineAndShapeRenderer);
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
     *
     * @param trackDataHolder
     */
    private void updateConvexHullData(TrackDataHolder trackDataHolder) {
        // upate convex hull data in table
        ConvexHull convexHull = trackDataHolder.getConvexHull();
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
    }

    /**
     * Plot x and y coordinates in time for the given track. The track is
     * actually get from the track data holder object.
     *
     * @param track
     */
    private void plotCoordinatesInTime(TrackDataHolder trackDataHolder) {
        // get the selected track data holder, and thus the track to plot in time
        Track track = trackDataHolder.getTrack();
        // get the track coordinates matrix
        Double[][] trackCoordinatesMatrix = trackDataHolder.getCoordinatesMatrix();
        // we need to transpose the matrix
        Double[][] transpose2DArray = AnalysisUtils.transpose2DArray(trackCoordinatesMatrix);
        // we get the x coordinates and the time information
        double[] xCoordinates = ArrayUtils.toPrimitive(AnalysisUtils.excludeNullValues(transpose2DArray[0]));
        double[] timeIndexes = trackDataHolder.getTimeIndexes();
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
     * Plot the shifted track coordinates for the current track. We get the
     * current track from the selected track data holder object.
     *
     * @param trackDataHolder
     */
    private void plotCoordinatesInSpace(TrackDataHolder trackDataHolder) {
        // get the coordinates matrix
        Double[][] shiftedCoordinatesMatrix = trackDataHolder.getShiftedCooordinatesMatrix();
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
        ConvexHull convexHull = trackDataHolder.getConvexHull();
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
        Double[][] coordinatesMatrix = trackDataHolder.getCoordinatesMatrix();
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
}
