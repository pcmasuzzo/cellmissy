/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.parser.impl;

import be.ugent.maf.cellmissy.entity.TimeStep;
import be.ugent.maf.cellmissy.exception.FileParserException;
import be.ugent.maf.cellmissy.parser.GenericInputFileParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * This is parsing a single generic input file.
 *
 * @author Paola Masuzzo
 */
@Service("genericInputFileParser")
public class GenericInputFileParserImpl implements GenericInputFileParser {

    private static final Logger LOG = Logger.getLogger(GenericInputFileParser.class);

    @Override
    public List<TimeStep> parseBulkCellFile(File bulkCellFile) throws FileParserException {
        List<TimeStep> timeStepList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(bulkCellFile))) {
            String strRead;
            while ((strRead = bufferedReader.readLine()) != null) {
                //check if the line is the header
                if (strRead.startsWith("Time")) {
                    continue;
                }
                String[] splitarray = strRead.split("\t");
                // check for number of columns in generic file 
                if (splitarray.length == 2) {
                    //create new timestep object and set class members
                    TimeStep timeStep = new TimeStep();
                    try {
                        timeStep.setTimeStepSequence(Integer.parseInt(splitarray[0]));
                        timeStep.setArea(Double.parseDouble(splitarray[1]));
                        //add timestep to the list
                        timeStepList.add(timeStep);
                    } catch (NumberFormatException ex) {
                        LOG.error(ex.getMessage(), ex);
                        throw new FileParserException("Please make sure each line of your import file contains numbers!");
                    }
                } else {
                    throw new FileParserException("Please make sure your import file has 2 columns!");
                }
            }
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new FileParserException(ex.getMessage());
        }
        return timeStepList;
    }
}
