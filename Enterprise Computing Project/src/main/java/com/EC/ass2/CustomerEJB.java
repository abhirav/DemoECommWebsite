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
public class CustomerEJB {
    @PersistenceContext(unitName = "ECAss2PU")
    private EntityManager em;
    
    // find all customers and return them as list
    public List<Customer> findCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("getCustomers",Customer.class);
        return query.getResultList();
    }
    
    // find all customers where name is param_fname
    public List<Customer> findCustomer(String param_fname){
        TypedQuery<Customer> query = em.createNamedQuery("searchCustomer",Customer.class).setParameter("param_fname", param_fname);
        return query.getResultList();
    }
    
    // find customer based on id provided
    public Customer findCustomer(Long param_id){
        TypedQuery<Customer> query = em.createNamedQuery("getCustomersById",Customer.class).setParameter("param_id", param_id);
        return query.getSingleResult();
    }
    
    // find orders of particular customer
    public List<OrderItem> findOrdersOfCustomer(Long param_id){
        TypedQuery<OrderItem> query = em.createNamedQuery("getCustomerOrders",OrderItem.class).setParameter("param_id", param_id);
        return query.getResultList();
    }
    
    // create customer (persist)
    public Customer createCustomer(Customer customer){
        em.persist(customer);
        return customer;
    }
}
