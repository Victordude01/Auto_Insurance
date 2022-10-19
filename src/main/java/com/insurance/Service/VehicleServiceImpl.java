package com.insurance.Service;

import com.insurance.Config.ExpectionNF;
import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Dao.VehicleDoa;
import com.insurance.Entity.PolicyHolder;
import com.insurance.Entity.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Vehicle> getAllVehiclesByPolicyNum(int policyNum) {
        if(!vehicleDoa.existsById(policyNum)){
            throw new ExpectionNF("Vehicle", "PolicyNumber", policyNum);
        }
        return vehicleDoa.findByPolicy(policyNum);
        // Optional<Vehicle> v = this.vehicleDoa.findById(policyNum);
        // Vehicle vehicle = null;
        // if(v.isPresent()){
        //     vehicle = v.get();
        // }else{
        //     throw new RuntimeException("Vehicle not found for policy number: "+policyNum);
        // }
        // return vehicle;
    }

    @Override
    public Vehicle getVehicleByPolicyNum(int policyNum){
        return vehicleDoa.findById(policyNum).orElseThrow(()->new ExpectionNF("Vehicle", "PolicyNumber", policyNum));
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle,int policyNum) {
        PolicyHolder policyHolder = policyHolderDoa.findById(policyNum).orElseThrow(()->new ExpectionNF("PolicyHolder", "PolicyNumber", policyNum));
        vehicle.setPolicyHolder(policyHolder);
        return vehicleDoa.save(vehicle);
        // int policy = vehicle.getPolicyHolder().getPolicyNum();
        // Optional<PolicyHolder> i = this.policyHolderDoa.findById(policy);
        // if(i.isPresent()) {
        //     return this.vehicleDoa.save(vehicle);
        // }else{
        //     throw new RuntimeException("Policy Number not found: "+policy);
        // }
    }


    @Override
    public Vehicle updateVehicle(Vehicle vehicle, int policyNum) {
        Vehicle v = getVehicleByPolicyNum(policyNum);
        v.setMake(vehicle.getMake());
        v.setModel(vehicle.getModel());
        v.setYear(vehicle.getYear());
        return vehicleDoa.save(v);
        // int policy = vehicle.getPolicyHolder().getPolicyNum();
        // Optional<PolicyHolder> i = this.policyHolderDoa.findById(policy);
        // if(i.isPresent()) {
        //     return this.vehicleDoa.save(vehicle);
        // }else{
        //     throw new RuntimeException("Policy Number not found: "+policy);
        // }
    }

    @Override
    public void deleteVehicleByPolicyNum(int id) {
        vehicleDoa.findById(id).orElseThrow(()->new ExpectionNF("Class","Id",id));
        vehicleDoa.deleteById(id);
    }

    @Override
    public void deleteAllVehiclesOfPolicyHolder(int id)
    {
        if (!vehicleDoa.existsById(id)) {
            throw new ExpectionNF("Teacher","Id",id);
        }
        vehicleDoa.deleteById(id);
    }
}
