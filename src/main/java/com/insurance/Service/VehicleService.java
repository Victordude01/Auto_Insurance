package com.insurance.Service;

import com.insurance.Entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getAllVehiclesByPolicyNum(int policyNum);
    Vehicle getVehicleByPolicyNum(int policyNum);
    Vehicle addVehicle(Vehicle vehicle,int policyNum);
    Vehicle updateVehicle(Vehicle vehicle,int policyNum);
    void deleteVehicleByPolicyNum(int id);
    void deleteAllVehiclesOfPolicyHolder(int id);
}
