/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.analysis.singlecell.preprocessing.impl;

import be.ugent.maf.cellmissy.analysis.singlecell.preprocessing.SingleCellConditionPreProcessor;
import be.ugent.maf.cellmissy.analysis.singlecell.preprocessing.SingleCellWellPreProcessor;
import be.ugent.maf.cellmissy.entity.TrackPoint;
import be.ugent.maf.cellmissy.entity.Well;
import be.ugent.maf.cellmissy.entity.result.singlecell.SingleCellConditionDataHolder;
import be.ugent.maf.cellmissy.entity.result.singlecell.SingleCellWellDataHolder;
import be.ugent.maf.cellmissy.entity.result.singlecell.StepCentricDataHolder;
import be.ugent.maf.cellmissy.entity.result.singlecell.TrackDataHolder;
import be.ugent.maf.cellmissy.utils.AnalysisUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * An implementation for the single cell condition preprocessor.
 *
 * @author Paola
 */
@Component("singleCellConditionPreProcessor")
public class SingleCellConditionPreProcessorImpl implements SingleCellConditionPreProcessor {

    @Autowired
    private SingleCellWellPreProcessor singleCellWellPreProcessor;

    @Override
    public void generateDataHolders(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        List<SingleCellWellDataHolder> singleCellWellDataHolders = new ArrayList<>();
        List<Well> singleCellAnalyzedWells = singleCellConditionDataHolder.getPlateCondition().getSingleCellAnalyzedWells();
        for (Well well : singleCellAnalyzedWells) {
            singleCellWellDataHolders.add(new SingleCellWellDataHolder(well));
        }
        singleCellConditionDataHolder.setSingleCellWellDataHolders(singleCellWellDataHolders);
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.generateTrackDataHolders(singleCellWellDataHolder);
        }
        List<TrackDataHolder> trackDataHolders = new ArrayList<>();
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            trackDataHolders.addAll(singleCellWellDataHolder.getTrackDataHolders());
        }
        singleCellConditionDataHolder.setTrackDataHolders(trackDataHolders);
    }

    @Override
    public void generateDataStructure(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.generateDataStructure(singleCellWellDataHolder);
        }
        // for a single condition, compute first the total number of track points
        int trackPointsNumber = computeTotalTrackPointsNumber(singleCellConditionDataHolder);
        Object[][] dataStructure = new Object[trackPointsNumber][3];
        int counter = 0;
        for (TrackDataHolder trackDataHolder : singleCellConditionDataHolder.getTrackDataHolders()) {
            List<TrackPoint> trackPointList = trackDataHolder.getTrack().getTrackPointList();
            for (TrackPoint trackPoint : trackPointList) {
                dataStructure[counter][0] = trackDataHolder.getTrack().getWellHasImagingType().getWell().toString();
                dataStructure[counter][1] = trackPoint.getTrack().getTrackNumber();
                dataStructure[counter][2] = trackPoint.getTimeIndex();
                counter++;
            }
        }
        singleCellConditionDataHolder.setDataStructure(dataStructure);
    }

    @Override
    public void preProcessStepsAndCells(SingleCellConditionDataHolder singleCellConditionDataHolder, double conversionFactor, double timeLapse) {
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.preProcessStepsAndCells(singleCellWellDataHolder, conversionFactor, timeLapse);
        }
    }

    @Override
    public void generateRawTrackCoordinatesMatrix(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.generateRawTrackCoordinatesMatrix(singleCellWellDataHolder);
        }
        Double[][] rawTrackCoordinatesMatrix = new Double[singleCellConditionDataHolder.getDataStructure().length][2];
        int counter = 0;
        for (TrackDataHolder trackDataHolder : singleCellConditionDataHolder.getTrackDataHolders()) {
            StepCentricDataHolder stepCentricDataHolder = trackDataHolder.getStepCentricDataHolder();
            Double[][] trackCoordinatesMatrix = stepCentricDataHolder.getCoordinatesMatrix();
            for (Double[] aTrackCoordinatesMatrix : trackCoordinatesMatrix) {
                rawTrackCoordinatesMatrix[counter] = aTrackCoordinatesMatrix;
                counter++;
            }
        }
        singleCellConditionDataHolder.setRawTrackCoordinatesMatrix(rawTrackCoordinatesMatrix);
    }

    @Override
    public void generateShiftedTrackCoordinatesMatrix(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.generateShiftedTrackCoordinatesMatrix(singleCellWellDataHolder);
        }
        Double[][] shiftedTrackCoordinatesMatrix = new Double[singleCellConditionDataHolder.getDataStructure().length][2];
        int counter = 0;
        for (TrackDataHolder trackDataHolder : singleCellConditionDataHolder.getTrackDataHolders()) {
            Double[][] shiftedTrackCoordinates = trackDataHolder.getStepCentricDataHolder()
                      .getShiftedCoordinatesMatrix();
            for (Double[] shiftedTrackCoordinate : shiftedTrackCoordinates) {
                shiftedTrackCoordinatesMatrix[counter] = shiftedTrackCoordinate;
                counter++;
            }
        }
        singleCellConditionDataHolder.setShiftedTrackCoordinatesMatrix(shiftedTrackCoordinatesMatrix);
    }

    @Override
    public void generateRawCoordinatesRanges(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.generateRawCoordinatesRanges(singleCellWellDataHolder);
        }
        Double[][] transposedMatrix = AnalysisUtils.transpose2DArray(singleCellConditionDataHolder.getRawTrackCoordinatesMatrix());
        // compute the min and the max coordinates
        Double xMin = Collections.min(Arrays.asList(transposedMatrix[0]));
        Double xMax = Collections.max(Arrays.asList(transposedMatrix[0]));
        Double yMin = Collections.min(Arrays.asList(transposedMatrix[1]));
        Double yMax = Collections.max(Arrays.asList(transposedMatrix[1]));
        Double[][] rawCoordinatesRanges = new Double[2][2];
        rawCoordinatesRanges[0] = new Double[]{xMin, xMax};
        rawCoordinatesRanges[1] = new Double[]{yMin, yMax};
        singleCellConditionDataHolder.setRawCoordinatesRanges(rawCoordinatesRanges);
    }

    @Override
    public void generateShiftedCoordinatesRanges(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        for (SingleCellWellDataHolder singleCellWellDataHolder : singleCellConditionDataHolder.getSingleCellWellDataHolders()) {
            singleCellWellPreProcessor.generateShiftedCoordinatesRanges(singleCellWellDataHolder);
        }
        Double[][] transposedMatrix = AnalysisUtils.transpose2DArray(singleCellConditionDataHolder.getShiftedTrackCoordinatesMatrix());
        // compute the min and the max coordinates
        Double xMin = Collections.min(Arrays.asList(transposedMatrix[0]));
        Double xMax = Collections.max(Arrays.asList(transposedMatrix[0]));
        Double yMin = Collections.min(Arrays.asList(transposedMatrix[1]));
        Double yMax = Collections.max(Arrays.asList(transposedMatrix[1]));
        Double[][] shiftedCoordinatesRanges = new Double[2][2];
        shiftedCoordinatesRanges[0] = new Double[]{xMin, xMax};
        shiftedCoordinatesRanges[1] = new Double[]{yMin, yMax};
        singleCellConditionDataHolder.setShiftedCoordinatesRanges(shiftedCoordinatesRanges);
    }

    /**
     * Calculate the total number of track points.
     *
     * @param singleCellConditionDataHolder
     * @return an integer
     */
    private int computeTotalTrackPointsNumber(SingleCellConditionDataHolder singleCellConditionDataHolder) {
        int trackPointsNumber = 0;
        for (TrackDataHolder trackDataHolder : singleCellConditionDataHolder.getTrackDataHolders()) {
            trackPointsNumber += trackDataHolder.getTrack().getTrackPointList().size();
        }
        return trackPointsNumber;
    }
}
