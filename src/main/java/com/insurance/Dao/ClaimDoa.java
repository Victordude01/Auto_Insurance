package com.insurance.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.insurance.Entity.Claim;

public interface ClaimDoa extends JpaRepository<Claim,Integer>{
    @Query("FROM Claim WHERE policyNumber = :id")
    List<Claim> findByPolicy(@Param("id")Integer id);
}