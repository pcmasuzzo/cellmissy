/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.analysis.impl;

import be.ugent.maf.cellmissy.analysis.AnalysisUtils;
import be.ugent.maf.cellmissy.analysis.OutliersHandler;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author Paola Masuzzo
 */
@Component("outliersHandler")
public class OutliersHandlerImpl implements OutliersHandler {

    @Override
    public List<Double[]> handleOutliers(Double[] data) {
        List<Double[]> list = new ArrayList<>();

        //List for outliers
        List<Double> outliers = new ArrayList<>();
        //List for new corrected data
        List<Double> correctedData = new ArrayList<>();
        final double k = 1.5;
        double IQR = AnalysisUtils.computeIQR(ArrayUtils.toPrimitive(data));
        double firstQuartile = AnalysisUtils.computeFirstQuartile(ArrayUtils.toPrimitive(data));
        double thirdQuartile = AnalysisUtils.computeThirdQuartile(ArrayUtils.toPrimitive(data));
        for (int i = 0; i < data.length; i++) {
            //check if value is outside the range: [Q1-k*IQR], [Q3+k*IQR]
            if (data[i] < (firstQuartile - k * IQR) || data[i] > (thirdQuartile + k * IQR)) {
                outliers.add(data[i]);
            } else {
                correctedData.add(data[i]);
            }
        }
        //caste list to arrays and add arrays to the List
        Double[] outliersToArray = outliers.toArray(new Double[outliers.size()]);
        list.add(outliersToArray);
        Double[] correctedDataToArray = correctedData.toArray(new Double[correctedData.size()]);
        list.add(correctedDataToArray);

        return list;
    }
}
