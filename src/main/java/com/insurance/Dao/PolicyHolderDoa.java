package com.insurance.Dao;

import com.insurance.Entity.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyHolderDoa extends JpaRepository<PolicyHolder,Integer> {
}
