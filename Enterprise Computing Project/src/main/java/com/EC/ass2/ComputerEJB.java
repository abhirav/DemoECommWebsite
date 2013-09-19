/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abhi
 */
@Stateless
public class ComputerEJB {
    @PersistenceContext(unitName = "ECAss2PU")
    private EntityManager em;
    
    // find all computers
    public List<Computer> findComputers(){
        TypedQuery<Computer> query = em.createNamedQuery("getStockComputer",Computer.class);
        return query.getResultList();
    }
    
    // find computer based on title provided
    public List<Computer> findComputer(String param_title){
        TypedQuery<Computer> query = em.createNamedQuery("searchComputer",Computer.class).setParameter("param_title", param_title);
        return query.getResultList();
    }
    
    // create computer (persist)
    public Computer createComputer(Computer computer){
        em.persist(computer);
        return computer;
    }
}
