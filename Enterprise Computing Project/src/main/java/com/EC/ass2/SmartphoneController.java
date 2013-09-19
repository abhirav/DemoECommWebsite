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
import javax.faces.context.FacesContext;

/**
 *
 * @author Abhi
 */
@ManagedBean(name = "smartphoneController")
@SessionScoped
public class SmartphoneController {
    @EJB
    private SmartphoneEJB sejb;
    private String param_title;
    private Smartphone smartphone = new Smartphone();
    private List<Smartphone> smartphonelist = new ArrayList<Smartphone>();
    private String itemName;
    
//    public void removeBean(){
//        FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove("smartphoneController");
//    }
    
    // create SMARTPHONE
    public String doCreateSmartphone(){
        smartphone = sejb.createSmartphone(smartphone);
        smartphonelist = sejb.findAllSmartphones();
        itemName = smartphone.getTitle();
        smartphone = new Smartphone();
        return "getSmartphoneStock";
    }
    
    // get all smartphones from database
    public String findAllSmartphones(){
        smartphonelist = sejb.findAllSmartphones();
        return "getSmartphoneStock";
    }
    
    // get Smartphone based on title provided
    public String findSmartphone(){
        smartphonelist = sejb.findSmartphone(param_title);
        return "foundSmartphone";
    }
 
    // get specific smartphone based on title(This method is called from CommandLink in datatable)
    public String findSmartphoneLink(String title){
        smartphonelist = sejb.findSmartphone(title);
        return "foundSmartphone";
    }
    
    // generate getter-setter methods
    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public List<Smartphone> getSmartphonelist() {
        return smartphonelist;
    }

    public void setSmartphonelist(List<Smartphone> smartphonelist) {
        this.smartphonelist = smartphonelist;
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