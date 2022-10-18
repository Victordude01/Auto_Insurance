package com.insurance.Service;

import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Entity.PolicyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class PolicyHolderServiceImpl implements PolicyHolderService{
    @Autowired
    private PolicyHolderDoa policyHolderDoa;

    @Override
    public List<PolicyHolder> getAllPolicyHolders() {
        return this.policyHolderDoa.findAll();
    }

    @Override
    public PolicyHolder getPolicyHolderByPolicyNum(int policyNum) {
        Optional<PolicyHolder> i = this.policyHolderDoa.findById(policyNum);
        PolicyHolder insurer = null;
        if(i.isPresent()){
            insurer = i.get();
        }else{
            throw new RuntimeException("Policy Holder not found for policy number: "+policyNum);
        }
        return insurer;
    }

    @Override
    public PolicyHolder addPolicyHolder(PolicyHolder insurer) {
        return this.policyHolderDoa.save(insurer);
    }

    @Override
    public PolicyHolder updatePolicyHolder(PolicyHolder insurer) {
        return this.policyHolderDoa.save(insurer);
    }

    @Override
    public String deletePolicyHolderByPolicyNum(int policyNum) {
        this.policyHolderDoa.deleteById(policyNum);
        return "Insurer Deleted Successfully";
    }
}
