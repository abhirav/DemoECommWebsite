/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Abhi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getListOfCustomer", query = "select c from Customer c"),
    @NamedQuery(name = "searchCustomer", query = "select c from Customer c where c.firstName = :param_fname"),
    @NamedQuery(name = "getCustomers", query = "select c from Customer c"),
    @NamedQuery(name = "getCustomersById", query = "select c from Customer c where c.customerId = :param_id")
})
public class Customer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "First_Name", length = 50)
    private String firstName;
    @Column(name = "Last_Name", length = 50)
    private String lastName;
    @Column(name = "Email", length = 50)
    private String email;
    @Column(name = "Phone_Number", length = 50)
    private String phoneNumber;
    @Column(name = "Address", length = 255)
    private String address;
    
    @OneToMany(mappedBy = "customerWhoOrderedItem", fetch = FetchType.LAZY)
    private List<OrderItem> itemOrder;

    // default constructor
    public Customer() {
    }
    
    // generate getter-setter methods
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public List<OrderItem> getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(List<OrderItem> itemOrder) {
        this.itemOrder = itemOrder;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        Customer cus = (Customer)obj;
        if(customerId == 0?cus.customerId != 0 : customerId != cus.customerId) return false;
        
        return true;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        return hash;
    }
}