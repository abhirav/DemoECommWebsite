/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Abhi
 */
@ManagedBean(name = "customerController", eager = true)
@SessionScoped
public class CustomerController {
    @EJB
    private CustomerEJB cejb;
    private String param_fname;
    private Customer customer = new Customer();
    private Customer customerDetail = new Customer();
    private List<Customer> customerlist = new ArrayList<Customer>();
    private List<OrderItem> orderListOfCustomer = new ArrayList<OrderItem>();
    private int noOfOrders;

    // Create Customer
    public String doCreateCustomer(){
        customer = cejb.createCustomer(customer);
        customerlist = cejb.findCustomers();
        customer = new Customer();
        return "getCustomerList";
    }
    
    // find All cutomers from database
    public String findAllCustomers(){
        customerlist = cejb.findCustomers();
        return "getCustomerList";
    }
    
    // find specific customer from database
    public String findCustomer(){
        customerlist = cejb.findCustomer(param_fname);
        return "getCustomerList";
    }
    
    // find customer based on CustomerID provided
    public String findCustomerById(Long id){
        customerlist = new ArrayList<Customer>();
        customerDetail = cejb.findCustomer(id);
        orderListOfCustomer = new ArrayList<OrderItem>();
        orderListOfCustomer = cejb.findOrdersOfCustomer(id);
        return "customerDesc";
    }
    
    // get number of orders of particular customer.
    public int getNoOfOrders(Long id){
        orderListOfCustomer = cejb.findOrdersOfCustomer(id);
        return orderListOfCustomer.size();
    }
    
    // generate getter-setter methods
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(List<Customer> customerlist) {
        this.customerlist = customerlist;
    }

    public String getParam_fname() {
        return param_fname;
    }

    public void setParam_fname(String param_fname) {
        this.param_fname = param_fname;
    }

    public List<OrderItem> getOrderListOfCustomer() {
        return orderListOfCustomer;
    }

    public void setOrderListOfCustomer(List<OrderItem> orderListOfCustomer) {
        this.orderListOfCustomer = orderListOfCustomer;
    }   

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }

    public Customer getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(Customer customerDetail) {
        this.customerDetail = customerDetail;
    }
}