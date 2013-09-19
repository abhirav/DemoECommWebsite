/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EC.ass2;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Abhi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getStockSmartphone", query = "SELECT s FROM Smartphone s"),
    @NamedQuery(name = "searchSmartphone", query = "SELECT s FROM Smartphone s where s.title = :param_title"),
    @NamedQuery(name = "getSmartphones", query = "SELECT s.title FROM Smartphone s")
})
public class Smartphone extends Electronic implements Serializable{
    @Column(name = "Carrier", length = 50)
    protected String carrier;
    @Column(name = "Operating_System", length = 50)
    protected String operatingSystem;
    @Column(name = "Color", length = 50)
    protected String color;
    
    // default constructor
    public Smartphone(){
    }
    
    // constructor with arguments
    public Smartphone(String carrier, String operatingSystem, String color){
        this.carrier = carrier;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // generate getter-setter methods
    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }    
}