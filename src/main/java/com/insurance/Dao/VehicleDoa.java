package com.insurance.Dao;

import com.insurance.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDoa extends JpaRepository<Vehicle,Integer> {
}
