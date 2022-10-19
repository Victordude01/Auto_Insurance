package com.insurance.Dao;

import com.insurance.Entity.Vehicle;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleDoa extends JpaRepository<Vehicle,Integer> {
    @Query("FROM Vehicle WHERE policyNumber = :id")
    List<Vehicle> findByPolicy(@Param("id")Integer id);
}
