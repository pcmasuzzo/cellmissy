/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.service;

import be.ugent.maf.cellmissy.entity.Ecm;
import be.ugent.maf.cellmissy.entity.EcmComposition;
import be.ugent.maf.cellmissy.entity.MatrixDimension;
import java.util.List;

/**
 *
 * @author Paola
 */
public interface EcmService extends GenericService<Ecm, Long> {

    public List<MatrixDimension> findAllMatrixDimension();

    public List<EcmComposition> findAllEcmComposition();
}
