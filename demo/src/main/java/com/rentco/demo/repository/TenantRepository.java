package com.rentco.demo.repository;

import com.rentco.demo.model.TenantModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<TenantModel, Integer> {

}
