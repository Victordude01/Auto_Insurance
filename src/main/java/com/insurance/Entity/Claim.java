package com.insurance.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int claimNum;

    @Column
    private String date;
    @Column
    private int status;
    @Column
    private int car_id;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "policyNumber")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PolicyHolder policyHolder;
}
