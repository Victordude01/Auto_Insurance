package com.insurance.Service;

import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Entity.PolicyHolder;
import com.insurance.Config.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
