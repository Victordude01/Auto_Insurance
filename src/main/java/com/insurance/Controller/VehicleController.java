package com.insurance.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.insurance.Entity.Vehicle;
import com.insurance.Service.VehicleService;

@CrossOrigin("*")
@RestController
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        super();
        this.vehicleService = vehicleService;
    }

    @PostMapping("/policyholders/{id}/vehicles")
    public ResponseEntity<Vehicle> addVehicle(@PathVariable(value = "id") Integer id, @RequestBody Vehicle classRequest){
        return new ResponseEntity<>(vehicleService.addVehicle(classRequest,id), HttpStatus.CREATED);
    }
    
    @GetMapping("/policyholders/{id}/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehiclesByPolicyNum(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByPolicyNum(id), HttpStatus.OK);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicleRequest){
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleRequest,id), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<HttpStatus> deleteVehicleByPolicyNum(@PathVariable("id") int id) {
        vehicleService.deleteVehicleByPolicyNum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/policyholders/{id}/vehicles")
    public ResponseEntity<HttpStatus> deleteAllVehiclesOfPolicyHolder(@PathVariable(value = "id") Integer id) {
        vehicleService.deleteAllVehiclesOfPolicyHolder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
