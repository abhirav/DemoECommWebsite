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
@ManagedBean(name = "computerController", eager = true)
@SessionScoped
public class ComputerController {
    @EJB
    private ComputerEJB cejb;
    private String param_title;
    private Computer computer = new Computer();
    private List<Computer> computerlist = new ArrayList<Computer>();
    private String itemName;

    // create COMPUTER 
    public String doCreateComputer(){
        computer = cejb.createComputer(computer);
        computerlist = cejb.findComputers();
        itemName = computer.getTitle();
        computer = new Computer();
        return "getComputerStock";
    }
    
    // find all computers from database
    public String findAllComputer(){
        computerlist = cejb.findComputers();
        return "getComputerStock";
    }
    
    // find specific computer from database
    public String findComputer(){
        computerlist = cejb.findComputer(param_title);
        return "foundComputer";
    }
    
    // find specific computer from database(method is called from CommandLink)
    public String findComputerLink(String title){
        computerlist = cejb.findComputer(title);
        return "foundComputer";
    }
    
    // generate getter-setter methods
    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public List<Computer> getComputerlist() {
        return computerlist;
    }

    public void setComputerlist(List<Computer> computerlist) {
        this.computerlist = computerlist;
    }

    public String getParam_title() {
        return param_title;
    }

    public void setParam_title(String param_title) {
        this.param_title = param_title;
    }  
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}