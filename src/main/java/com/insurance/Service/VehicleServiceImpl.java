package com.insurance.Service;

import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Dao.VehicleDoa;
import com.insurance.Entity.PolicyHolder;
import com.insurance.Entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleDoa vehicleDoa;
    @Autowired
    private PolicyHolderDoa policyHolderDoa;

    @Override
    public List<Vehicle> getAllVehicles() {
        return this.vehicleDoa.findAll();
    }

    @Override
    public Vehicle getVehicleByPolicyNum(int policyNum) {
        Optional<Vehicle> v = this.vehicleDoa.findById(policyNum);
        Vehicle vehicle = null;
        if(v.isPresent()){
            vehicle = v.get();
        }else{
            throw new RuntimeException("Vehicle not found for policy number: "+policyNum);
        }
        return vehicle;
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        int policy = vehicle.getPolicyNum();
        Optional<PolicyHolder> i = this.policyHolderDoa.findById(policy);
        if(i.isPresent()) {
            return this.vehicleDoa.save(vehicle);
        }else{
            throw new RuntimeException("Policy Number not found: "+policy);
        }
    }


    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        int policy = vehicle.getPolicyNum();
        Optional<PolicyHolder> i = this.policyHolderDoa.findById(policy);
        if(i.isPresent()) {
            return this.vehicleDoa.save(vehicle);
        }else{
            throw new RuntimeException("Policy Number not found: "+policy);
        }
    }

    @Override
    public String deleteVehicleByPolicyNum(int id) {
        this.vehicleDoa.deleteById(id);
        return "Vehicle Deleted Successfully";
    }
}
