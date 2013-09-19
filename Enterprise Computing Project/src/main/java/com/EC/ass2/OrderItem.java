/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Abhi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getOrderOfCustomer", query = "select o from OrderItem o"),
    @NamedQuery(name = "searchOrder", query = "select o from OrderItem o where o.orderId = :param_orderNo"),
    @NamedQuery(name = "getCustomerOrders", query = "select o from OrderItem o where o.customerWhoOrderedItem.customerId = :param_id")
})
public class OrderItem implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Column(name = "Order_Date", length = 100)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "Quantity", length = 50)
    private int quantity;
    @Column(name = "Unit_Price", length = 50)
    private double unitPrice;
    @Column(name = "Customer_Name", length = 50)
    private String customerName;
    @Column(name = "Item_Name", length = 50)
    private String item;
    @Column(name = "Total_Price")
    private double totalPrice;
    
    
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    private Customer customerWhoOrderedItem;
    
    @OneToOne
    private Electronic electronicItem;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Customer getCustomerWhoOrderedItem() {
        return customerWhoOrderedItem;
    }

    public void setCustomerWhoOrderedItem(Customer customerWhoOrderedItem) {
        this.customerWhoOrderedItem = customerWhoOrderedItem;
    }

    public Electronic getElectronicItem() {
        return electronicItem;
    }

    public void setElectronicItem(Electronic electronicItem) {
        this.electronicItem = electronicItem;
    }
}
