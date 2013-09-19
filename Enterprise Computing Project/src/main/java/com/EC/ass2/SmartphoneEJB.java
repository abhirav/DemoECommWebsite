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
public class SmartphoneEJB {
    @PersistenceContext(unitName = "ECAss2PU")
    private EntityManager em;
    
    // get all smartphones
    public List<Smartphone> findAllSmartphones(){
        TypedQuery<Smartphone> query = em.createNamedQuery("getStockSmartphone",Smartphone.class);
        return query.getResultList();
    }
    
    //find smartphone
    public List<Smartphone> findSmartphone(String param_title){
        TypedQuery<Smartphone> query = em.createNamedQuery("searchSmartphone",Smartphone.class).setParameter("param_title", param_title);
        return query.getResultList();
    }
    
    // create smartphone (persist)
    public Smartphone createSmartphone(Smartphone smartphone){
        em.persist(smartphone);
        return smartphone;
    }
}