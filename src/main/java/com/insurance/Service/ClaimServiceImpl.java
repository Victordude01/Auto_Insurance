package com.insurance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.Config.ExpectionNF;
import com.insurance.Dao.ClaimDoa;
import com.insurance.Dao.PolicyHolderDoa;
import com.insurance.Entity.Claim;
import com.insurance.Entity.PolicyHolder;

@Service
public class ClaimServiceImpl implements ClaimService{
    @Autowired
    private ClaimDoa claimDoa;
    @Autowired
    private PolicyHolderDoa policyHolderDoa;

    @Override
    public List<Claim> getAllClaims() {
        return this.claimDoa.findAll();
    }

    @Override
    public Claim getClaimByPolicyNum(int policyNum){
        return claimDoa.findById(policyNum).orElseThrow(()->new ExpectionNF("PolicyHolder", "PolicyNumber", policyNum));
    }

    @Override
    public List<Claim> getAllClaimsByPolicyNum(int policyNum) {
        if(!claimDoa.existsById(policyNum)){
            throw new ExpectionNF("Vehicle", "PolicyNumber", policyNum);
        }
        return claimDoa.findByPolicy(policyNum);
    }

    @Override
    public Claim addClaim(Claim claim, int policyNum) {
        PolicyHolder policyHolder = policyHolderDoa.findById(policyNum).orElseThrow(()->new ExpectionNF("PolicyHolder", "PolicyNumber", policyNum));
        claim.setPolicyHolder(policyHolder);
        return claimDoa.save(claim);
    }

    @Override
    public Claim updateClaim(Claim claim, int policyNum) {
        Claim c = getClaimByPolicyNum(policyNum);
        c.setStatus(claim.getStatus());
        c.setDate(claim.getDate());
        c.setCar_id(claim.getCar_id());
        return claimDoa.save(c);
    }

    @Override
    public void deleteClaim(int policyNum) {
        claimDoa.findById(policyNum).orElseThrow(()->new ExpectionNF("Class","Id",policyNum));
        claimDoa.deleteById(policyNum);
        
    }
    
}