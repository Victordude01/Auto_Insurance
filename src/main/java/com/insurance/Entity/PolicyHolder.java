package com.insurance.Entity;

import javax.persistence.*;

import lombok.Data;

@Data
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
}
