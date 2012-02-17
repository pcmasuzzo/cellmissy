/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ugent.maf.limsdesktop.repository;

import be.ugent.maf.limsdesktop.entity.User;

/**
 *
 * @author niels
 */
public interface UserRepository extends GenericRepository<User, Long> {
    
    User findByFullName(String firstName, String lastName);
    User findByFirstName (String firstName);
    User findByLastName (String lastName);
            
}
