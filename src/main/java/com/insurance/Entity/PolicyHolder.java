package com.insurance.Entity;

import javax.persistence.*;

@Entity
@Table(name="PolicyHolder")
public class PolicyHolder {
    @Id
    @Column(name="policyNumber")
    private int policyNum;
    @Column 
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private String email;
    @Column
    private String address;

    public PolicyHolder() {
    }

    public PolicyHolder(int policyNum, String name, String phoneNumber, String email, String address) {
        this.policyNum = policyNum;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(int policyNum) {
        this.policyNum = policyNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
