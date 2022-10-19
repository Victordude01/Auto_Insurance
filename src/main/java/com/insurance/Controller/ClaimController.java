package com.insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Dao.ClaimDoa;
import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Entity.Claim;
import com.insurance.Service.ClaimService;

@RestController
@RequestMapping("/api")
public class ClaimController {
    @Autowired
    private PolicyHolderDoa policyHolderDoa;
    @Autowired
    private ClaimDoa claimDoa;
    private ClaimService claimService;

    public ClaimController(ClaimService claimService){
        super();
        this.claimService = claimService;
    }

    @PostMapping("/policyholders/{id}/claims")
    public ResponseEntity<Claim> addVehicle(@PathVariable(value = "id") Integer id, @RequestBody Claim classRequest){
        return new ResponseEntity<>(claimService.addClaim(classRequest,id), HttpStatus.CREATED);
    }
    
    @GetMapping("/policyholders/{id}/claims")
    public ResponseEntity<List<Claim>> getAllVehiclesByPolicyNum(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(claimService.getAllClaimsByPolicyNum(id), HttpStatus.OK);
    }

    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getAllClaims(){
        return new ResponseEntity<>(claimService.getAllClaims(), HttpStatus.OK);
    }

    @PutMapping("/claims/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable("id") int id, @RequestBody Claim ClaimRequest){
        return new ResponseEntity<>(claimService.updateClaim(ClaimRequest,id), HttpStatus.OK);
    }

    @DeleteMapping("/policyholders/{id}/claims")
    public ResponseEntity<HttpStatus> deleteClaim(@PathVariable(value = "id") Integer id) {
        claimService.deleteClaim(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
