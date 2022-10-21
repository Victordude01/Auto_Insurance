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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Entity.PolicyHolder;
import com.insurance.Service.PolicyHolderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/policyholders")
public class PolicyHolderController {
    private PolicyHolderService policyHolderService;

    public PolicyHolderController(PolicyHolderService policyHolderService){
        super();
        this.policyHolderService = policyHolderService;
    }

    @PostMapping()
    public ResponseEntity<PolicyHolder> addPolicyHolder(@RequestBody PolicyHolder policyHolder){
        return new ResponseEntity<>(policyHolderService.addPolicyHolder(policyHolder), HttpStatus.CREATED);
    }


    @GetMapping
    public List<PolicyHolder> getAllPolicyHolders(){
        return policyHolderService.getAllPolicyHolders();
    }

    @GetMapping("{id}")
    public ResponseEntity<PolicyHolder> getPolicyHolderByPolicyNum(@PathVariable("id") int id){
        return new ResponseEntity<>(policyHolderService.getPolicyHolderByPolicyNum(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<PolicyHolder> updatePolicyHolder(@RequestBody PolicyHolder policyHolder, @PathVariable("id") int id){
        return new ResponseEntity<>(policyHolderService.updatePolicyHolder(policyHolder,id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePolicyHolderByPolicyNum(@PathVariable("id") int id){
        policyHolderService.deletePolicyHolderByPolicyNum(id);
        return new ResponseEntity<>("Policy Holder deleted", HttpStatus.OK);
    }
    
}
