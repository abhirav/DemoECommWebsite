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
    @NamedQuery(name = "getStockComputer", query = "SELECT c FROM Computer c"),
    @NamedQuery(name = "searchComputer", query = "SELECT c FROM Computer c where c.title = :param_title"),
    @NamedQuery(name = "getComputers", query = "SELECT c.title FROM Computer c")
})
public class Computer extends Electronic implements Serializable{
    @Column(name = "Screen_Size", length = 50)
    protected String screenSize;
    @Column(name = "Memory", length = 50)
    protected String memory;
    @Column(name = "Hard_Drive_Capacity", length = 50)
    protected String hardDriveCapacity;
    @Column(name = "Processor_Type", length = 50)
    protected String processorType;
    @Column(name = "Processor_Speed", length = 50)
    protected String processorSpeed;
    
    // default Constructor
    public Computer(){}
    
    // Constructor with arguments
    public Computer(String screenSize, String memory, String hardDriveCapacity, String processorType, String processorSpeed){
        this.screenSize = screenSize;
        this.memory = memory;
        this.hardDriveCapacity = hardDriveCapacity;
        this.processorType = processorType;
        this.processorSpeed = processorSpeed;
    }

    // generating getter-setter methods
    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(String hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(String processorSpeed) {
        this.processorSpeed = processorSpeed;
    }
}
