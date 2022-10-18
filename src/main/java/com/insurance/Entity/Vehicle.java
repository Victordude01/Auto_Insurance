package com.insurance.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="policyNumber")
    private int policyNum;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private int year;

    @ManyToOne(cascade = CascadeType.ALL)
    private PolicyHolder policyHolder;
    

    public Vehicle() {
    }

    public Vehicle( String make, String model, int year,int policyNum,PolicyHolder policyHolder) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.policyNum = policyNum;
        this.policyHolder = policyHolder;
    }

    public PolicyHolder getPolicyHolder(){
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder){
        this.policyHolder = policyHolder;
    }

    public int getPolicyNum(){
        return policyNum;
    }

    public void setPolicyNum(int policyNum){        
        this.policyNum = policyNum;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
