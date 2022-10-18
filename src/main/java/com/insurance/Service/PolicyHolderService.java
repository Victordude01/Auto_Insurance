package com.insurance.Service;

import com.insurance.Entity.PolicyHolder;

import java.util.List;


public interface PolicyHolderService {
    List<PolicyHolder> getAllPolicyHolders();
    PolicyHolder getPolicyHolderByPolicyNum(int policyNum);
    PolicyHolder addPolicyHolder(PolicyHolder insurer);
    PolicyHolder updatePolicyHolder(PolicyHolder insurer);
    String deletePolicyHolderByPolicyNum(int policyNum);

}
