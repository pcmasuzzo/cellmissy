/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.analysis.impl;

import be.ugent.maf.cellmissy.analysis.StatisticsCalculator;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.inference.MannWhitneyUTest;
import org.springframework.stereotype.Component;

/**
 * Implementation for Statistics Calculator
 * @author Paola Masuzzo
 */
@Component("statisticsCalculator")
public class StatisticsCalculatorImpl implements StatisticsCalculator {

    @Override
    public double executeMannWhitneyUTest(double[] x, double[] y) {

        MannWhitneyUTest mannWhitneyUTest = new MannWhitneyUTest();
        double pValue = mannWhitneyUTest.mannWhitneyUTest(x, y);
        return pValue;
    }

    @Override
    public StatisticalSummary getSummaryStatistics(double[] x) {
        SummaryStatistics summaryStatistics = new SummaryStatistics();
        for (int i = 0; i < x.length; i++) {
            summaryStatistics.addValue(x[i]);
        }
        StatisticalSummary summary = summaryStatistics.getSummary();
        return summary;
    }

    @Override
    public boolean[][] detectSignificance(Double[][] data, double alpha) {
        boolean[][] significances = new boolean[data.length][data[0].length];
        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < data[0].length; columnIndex++) {
                Double pValue = data[rowIndex][columnIndex];
                // if p value is not null and it's less than alpha level, set boolean to true:
                // correspondent pairwise comparison is statistically significant
                if (pValue != null && pValue <= alpha) {
                    significances[rowIndex][columnIndex] = true;
                }
            }
        }
        return significances;
    }
}
