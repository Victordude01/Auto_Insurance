package com.insurance.Service;

import java.util.List;

import com.insurance.Entity.Claim;

public interface ClaimService {
    List<Claim> getAllClaims();
    List<Claim> getAllClaimsByPolicyNum(int policyNum);
    Claim getClaimByPolicyNum(int policyNum);
    Claim addClaim(Claim claim,int policyNum);
    Claim updateClaim(Claim claim,int policyNum);
    void deleteClaim(int policyNum);
    
}
