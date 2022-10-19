package com.insurance.Service;

import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Entity.PolicyHolder;
import com.insurance.Config.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PolicyHolderServiceImpl implements PolicyHolderService{
    @Autowired
    private PolicyHolderDoa policyHolderDoa;

    public PolicyHolderServiceImpl(PolicyHolderDoa policyHolderDoa){
        super();
        this.policyHolderDoa = policyHolderDoa;
    }

    @Override
    public List<PolicyHolder> getAllPolicyHolders() {
        return this.policyHolderDoa.findAll();
    }

    @Override
    public PolicyHolder getPolicyHolderByPolicyNum(int policyNum) {
        return policyHolderDoa.findById(policyNum).orElseThrow(()->new ResourceNotFoundException("PolicyHolder", "PolicyNumber", policyNum));

        // Optional<PolicyHolder> i = this.policyHolderDoa.findById(policyNum);
        // PolicyHolder insurer = null;
        // if(i.isPresent()){
        //     insurer = i.get();
        // }else{
        //     throw new RuntimeException("Policy Holder not found for policy number: "+policyNum);
        // }
        // return insurer;
    }



    @Override
    public PolicyHolder addPolicyHolder(PolicyHolder insurer) {
        return this.policyHolderDoa.save(insurer);
    }

    @Override
    public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder,int policyNum) {
        PolicyHolder p = getPolicyHolderByPolicyNum(policyNum);
        p.setAddress(policyHolder.getAddress());
        p.setEmail(policyHolder.getEmail());
        p.setName(policyHolder.getName());
        p.setPhoneNumber(policyHolder.getPhoneNumber());
        policyHolderDoa.save(p);
        return p;
    }

    @Override
    public void deletePolicyHolderByPolicyNum(int policyNum) {
        policyHolderDoa.findById(policyNum).orElseThrow(()->new ResourceNotFoundException("PolicyHolder", "PolicyNumber", policyNum));
        policyHolderDoa.deleteById(policyNum);
    }
}
