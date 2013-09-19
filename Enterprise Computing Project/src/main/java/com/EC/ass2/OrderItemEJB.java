/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.util.ArrayList;
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
public class OrderItemEJB {
    @PersistenceContext(unitName = "ECAss2PU")
    private EntityManager em;
    
    // find all orders
    public List<OrderItem> findOrders(){
        TypedQuery<OrderItem> query = em.createNamedQuery("getOrderOfCustomer",OrderItem.class);
        return query.getResultList();
    }
    
    // find order based on order number
    public List<OrderItem> findOrder(int param_orderNo){
        TypedQuery<OrderItem> query = em.createNamedQuery("searchOrder",OrderItem.class).setParameter("param_orderNo", param_orderNo);
        return query.getResultList();
    }
    
    // find all the customers and return them as list
    public List<Customer> findAllCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("getCustomers",Customer.class);
        return (List<Customer>) query.getResultList();
    }
    
    // find all items and return them as list
    public List<Electronic> findAllItems(){
        TypedQuery<Electronic> query = em.createNamedQuery("getElectronics",Electronic.class);
        return query.getResultList();
    }
    
    // find perticular customer
    public Customer findCustomer(Long param_id){
        TypedQuery<Customer> query = em.createNamedQuery("getCustomersById",Customer.class).setParameter("param_id", param_id);
        return query.getSingleResult();
    }
    
    // find particular item
    public Electronic findItem(int param_id){
        TypedQuery<Electronic> query = em.createNamedQuery("getElectronicById",Electronic.class).setParameter("param_id", param_id);
        return query.getSingleResult();
    }
    
    // set deducted quantity in Electronic table when order is made
    public void setQuantityOfItem(int param_id, OrderItem orderItem){
        Electronic e;
        TypedQuery<Electronic> query = em.createNamedQuery("getElectronicById",Electronic.class).setParameter("param_id", param_id);
        e = query.getSingleResult();
        e.setQuantity(e.getQuantity()-orderItem.getQuantity());
        em.merge(e);
    }
    
    // add quantity of electronic when order is deleted
    public void restoreItemQuantity(OrderItem orderItem){
        Electronic e;
        TypedQuery<Electronic> query = em.createNamedQuery("getElectronicById",Electronic.class).setParameter("param_id", orderItem.getElectronicItem().getId());
        e = query.getSingleResult();
        e.setQuantity(e.getQuantity()+orderItem.getQuantity());
        em.merge(e);
    }
    
    // create order (persist)
    public OrderItem createOrder(OrderItem order){
        em.persist(order);
        return order;
    }
    
    // delete order (remove)
    public void deleteOrder(OrderItem order){
        em.remove(em.merge(order));
    }
}
