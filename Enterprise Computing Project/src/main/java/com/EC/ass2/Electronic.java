/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import javax.persistence.*;

/**
 *
 * @author Abhi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getElectronics", query = "select e from Electronic e"),
    @NamedQuery(name = "getElectronicById", query = "select e from Electronic e where e.id = :param_id")
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Electronic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(name="Title", nullable = false, length = 50)
    protected String title;
    @Column(name="Price", nullable = false)
    protected int price;
    @Column(name="Brand", nullable = false)
    protected String brand;
    @Column(name="Description", length = 2000)
    protected String description;
    @Column(name = "Quantity", length = 50)
    protected int quantity;

    // default constructor
    public Electronic(){}
    
    // constructor with arguments
    public Electronic(String title, int price, String brand, String description){
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.description = description;
    }
    
    //generate getter-setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        
        Electronic ele = (Electronic)obj;
        if(id == 0?ele.id != 0 : id != ele.id) return false;
        
        return true;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        return hash;
    }
}
