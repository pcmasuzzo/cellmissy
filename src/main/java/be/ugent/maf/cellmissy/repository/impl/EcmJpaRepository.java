/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.cellmissy.repository.impl;

import be.ugent.maf.cellmissy.entity.Ecm;
import be.ugent.maf.cellmissy.repository.EcmRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paola
 */
@Repository("ecmRepository")
public class EcmJpaRepository extends GenericJpaRepository<Ecm, Long> implements EcmRepository {
    
}
