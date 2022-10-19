package com.insurance.Dao;

import com.insurance.Entity.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface PolicyHolderDoa extends JpaRepository<PolicyHolder,Integer> {
}
