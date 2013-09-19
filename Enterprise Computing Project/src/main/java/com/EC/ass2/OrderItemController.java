/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Abhi
 */
@ManagedBean(name = "orderItemController", eager = true)
@SessionScoped
public class OrderItemController{
    @EJB
    private OrderItemEJB oejb;
    private int param_orderNo;
    private OrderItem orderItem = new OrderItem();
    private List<OrderItem> orderItemlist = new ArrayList<OrderItem>();
    private String customerMenu;
    private String itemMenu;
    private List<Customer> customerList = null;
    private List<Electronic> electronicList = null;
    private List itemList = null;
    private Customer cus = new Customer();
    private Electronic ele = new Electronic();
    
    // default constructor
    public OrderItemController(){
    }
    
    // initialize comboboxes of customer and electronic items while creating new order
    @PostConstruct
    public void init(){
        customerList = oejb.findAllCustomers();
        electronicList = oejb.findAllItems();
    }
    
    // create NEW ORDER
    public String doCreateOrder(){
        cus = oejb.findCustomer(orderItem.getCustomerWhoOrderedItem().getCustomerId());
        ele = oejb.findItem(orderItem.getElectronicItem().getId());
        System.out.println(ele.getId());
        orderItem.setItem(ele.getTitle());
        orderItem.setUnitPrice(ele.getPrice());
        orderItem.setTotalPrice(ele.getPrice() * orderItem.getQuantity());
        orderItem.setCustomerName(cus.getFirstName()+" "+cus.getLastName());
        oejb.setQuantityOfItem(ele.getId(), orderItem);
        orderItem.setOrderDate(new Date());
        orderItem = oejb.createOrder(orderItem);
        orderItemlist = oejb.findOrders();
        orderItem = new OrderItem();
        return "getOrderList";
    }
    
    // Delete order 
    public String deleteOrder(OrderItem o){
        oejb.restoreItemQuantity(o);
        oejb.deleteOrder(o);
        orderItemlist = oejb.findOrders();
        return "getOrderList";
    }
    
    // get all order in list
    public String findAllOrder(){
        orderItemlist = oejb.findOrders();
        return "getOrderList";
    }
    
    // get all customers and all electronic items in list
    public String getAllLists(){
        customerList = oejb.findAllCustomers();
        electronicList = oejb.findAllItems();
        return "newOrder";
    }
    
    // find item description based on ID provided
    public String getItemDesc(int electronicId){
        ele = oejb.findItem(electronicId);
        return "foundElectronic";
    }
    
    // find order based on order number provided
    public String findOrder(){
        orderItemlist = oejb.findOrder(param_orderNo);
        return "foundOrder";
    }

    // generate getter-setter methods
    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public List<OrderItem> getOrderItemlist() {
        return orderItemlist;
    }

    public void setOrderItemlist(List<OrderItem> orderItemlist) {
        this.orderItemlist = orderItemlist;
    }

    public int getParam_orderNo() {
        return param_orderNo;
    }

    public void setParam_orderNo(int param_orderNo) {
        this.param_orderNo = param_orderNo;
    }

    public String getCustomerMenu() {
        return customerMenu;
    }

    public void setCustomerMenu(String customerMenu) {
        this.customerMenu = customerMenu;
    }

    public String getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(String itemMenu) {
        this.itemMenu = itemMenu;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<SelectItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SelectItem> itemList) {
        this.itemList = itemList;
    }

    public List<Electronic> getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(List<Electronic> electronicList) {
        this.electronicList = electronicList;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public Electronic getEle() {
        return ele;
    }

    public void setEle(Electronic ele) {
        this.ele = ele;
    }   
}