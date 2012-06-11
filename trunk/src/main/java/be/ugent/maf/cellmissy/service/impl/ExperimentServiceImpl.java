/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.service.impl;

import be.ugent.maf.cellmissy.entity.Experiment;
import be.ugent.maf.cellmissy.entity.Instrument;
import be.ugent.maf.cellmissy.entity.Magnification;
import be.ugent.maf.cellmissy.repository.ExperimentRepository;
import be.ugent.maf.cellmissy.repository.InstrumentRepository;
import be.ugent.maf.cellmissy.repository.MagnificationRepository;
import be.ugent.maf.cellmissy.service.ExperimentService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Paola
 */
@Service("experimentService")
@Transactional
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    private ExperimentRepository experimentRepository;
    @Autowired
    private InstrumentRepository instrumentRepository;
    @Autowired
    private MagnificationRepository magnificationRepository;

    @Override
    public Experiment createNewExperiment(int experimentNumber, File projectFolder) {

        // create new experiment entity and set experiment number
        Experiment newExperiment = new Experiment();
        newExperiment.setExperimentNumber(experimentNumber);

        // create experiment folder from project folder
        String experimentFolder = projectFolder.getName() + "_E" + Integer.toString(experimentNumber);
        File subdirectory = new File(projectFolder, experimentFolder);
        subdirectory.mkdir();

        return newExperiment;
    }

    @Override
    public Experiment findById(Long id) {
        return experimentRepository.findById(id);
    }

    @Override
    public List<Experiment> findAll() {
        return experimentRepository.findAll();
    }

    @Override
    public Experiment save(Experiment entity) {
        return experimentRepository.save(entity);
    }

    @Override
    public void delete(Experiment entity) {
        entity = experimentRepository.save(entity);
        experimentRepository.delete(entity);
    }

    @Override
    public List<Instrument> findAllInstruments() {
        return instrumentRepository.findAll();        
    }

    @Override
    public List<Magnification> findAllMagnifications() {
        return magnificationRepository.findAll();
    }

    @Override
    public List<Integer> findExperimentNumbersByProjectId(Integer projectId) {
        return experimentRepository.findExperimentNumbersByProjectId(projectId);
    }
}
