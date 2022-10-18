package com.insurance.Service;

import com.insurance.Entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleByPolicyNum(int policyNum);
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    String deleteVehicleByPolicyNum(int id);
}
