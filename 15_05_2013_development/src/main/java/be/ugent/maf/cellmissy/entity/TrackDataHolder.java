/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.entity;

/**
 * This object keeps pre processing results on the track level.
 *
 * @author Paola Masuzzo <paola.masuzzo@ugent.be>
 */
public class TrackDataHolder {

    // track
    private Track track;
    // time indexes
    private double[] timeIndexes;
    // matrix for track coordinates (x, y)
    private Double[][] trackCoordinatesMatrix;
    // matrix for normalized track coordinates
    private Double[][] shiftedTrackCoordinates;
    // matrix for delta movements in (x, y) direction
    private Double[][] deltaMovements;
    // array for  the instantaneous velocities
    private Double[] instantaneousVelocities;
    // boolean for outliers: TRUE is data point is an outlier
    private boolean[] outliers;
    // array for velocities filtered for non motile steps
    private double trackVelocity;
    // double for cumulative distance (between first and last time point of the track)
    private double cumulativeDistance;
    // double for euclidean distance (between first and last time point of the track)
    private double euclideanDistance;
    // array for angles
    private Double[] angles;

    public TrackDataHolder(Track track) {
        this.track = track;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public double[] getTimeIndexes() {
        return timeIndexes;
    }

    public void setTimeIndexes(double[] timeIndexes) {
        this.timeIndexes = timeIndexes;
    }

    public Double[][] getTrackCoordinatesMatrix() {
        return trackCoordinatesMatrix;
    }

    public void setTrackCoordinatesMatrix(Double[][] trackCoordinatesMatrix) {
        this.trackCoordinatesMatrix = trackCoordinatesMatrix;
    }

    public Double[][] getShiftedTrackCoordinates() {
        return shiftedTrackCoordinates;
    }

    public void setShiftedTrackCoordinates(Double[][] shiftedTrackCoordinates) {
        this.shiftedTrackCoordinates = shiftedTrackCoordinates;
    }

    public Double[][] getDeltaMovements() {
        return deltaMovements;
    }

    public void setDeltaMovements(Double[][] deltaMovements) {
        this.deltaMovements = deltaMovements;
    }

    public Double[] getInstantaneousVelocities() {
        return instantaneousVelocities;
    }

    public void setInstantaneousVelocities(Double[] instantaneousVelocities) {
        this.instantaneousVelocities = instantaneousVelocities;
    }

    public boolean[] getOutliers() {
        return outliers;
    }

    public void setOutliers(boolean[] outliers) {
        this.outliers = outliers;
    }

    public double getTrackVelocity() {
        return trackVelocity;
    }

    public void setTrackVelocity(double trackVelocity) {
        this.trackVelocity = trackVelocity;
    }

    public double getCumulativeDistance() {
        return cumulativeDistance;
    }

    public void setCumulativeDistance(double cumulativeDistance) {
        this.cumulativeDistance = cumulativeDistance;
    }

    public double getEuclideanDistance() {
        return euclideanDistance;
    }

    public void setEuclideanDistance(double euclideanDistance) {
        this.euclideanDistance = euclideanDistance;
    }

    public Double[] getAngles() {
        return angles;
    }

    public void setAngles(Double[] angles) {
        this.angles = angles;
    }

    @Override
    public String toString() {
        int trackNumber = track.getTrackNumber();
        Well well = track.getWellHasImagingType().getWell();
        return "track " + trackNumber + ", well " + well;
    }
}
