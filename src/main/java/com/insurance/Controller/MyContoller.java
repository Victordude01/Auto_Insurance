package com.insurance.Controller;

import com.insurance.Entity.PolicyHolder;
import com.insurance.Entity.Vehicle;
import com.insurance.Service.PolicyHolderService;
import com.insurance.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyContoller {
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private PolicyHolderService policyHolderService;


    @GetMapping("/")
    public String home(){
        return "<HTML><H1>Policy Holder Database</H1></HTML>";
    }

    @GetMapping("/policyholders")
    public List<PolicyHolder> getAllPolicyHolders(){
        return this.policyHolderService.getAllPolicyHolders();
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){return this.vehicleService.getAllVehicles();}

    @GetMapping("/policyholders/{policyNum}")
    public PolicyHolder getPolicyHolder(@PathVariable String policyNum){
        return this.policyHolderService.getPolicyHolderByPolicyNum(Integer.parseInt(policyNum));
    }

    @PostMapping("/policyholders")
    public PolicyHolder addPolicyHolder(@RequestBody PolicyHolder insurer){
        return this.policyHolderService.addPolicyHolder(insurer);
    }

    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return this.vehicleService.addVehicle(vehicle);
    }

    @PutMapping("/policyholders")
    public PolicyHolder updatePolicyHolder(@RequestBody PolicyHolder insurer){
        return this.policyHolderService.updatePolicyHolder(insurer);
    }

    @DeleteMapping("policyholders/{policyNum}")
    public String deletePolicyHolder(@PathVariable String policyNum){
        return this.policyHolderService.deletePolicyHolderByPolicyNum(Integer.parseInt(policyNum));
    }

    @DeleteMapping("/vehicles/{id}")
    public String deleteVehicle(@PathVariable String id){
        return this.vehicleService.deleteVehicleByPolicyNum(Integer.parseInt(id));
    }
}
