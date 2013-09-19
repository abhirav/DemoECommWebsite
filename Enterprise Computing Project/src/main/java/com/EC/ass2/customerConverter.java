/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Abhi
 */

// This class is used to get the ID from the CUSTOMER object when it is displayed in newOrder.xhtml selectOneMenu and when we need to persist order.
@ManagedBean
@FacesConverter(value="customerConverter")
public class customerConverter implements Converter{

    @PersistenceContext
    private transient EntityManager em;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return em.find(Customer.class, new Long(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        Customer customer;
        customer = (Customer) value;
        return String.valueOf(customer.getCustomerId());

    }
}
