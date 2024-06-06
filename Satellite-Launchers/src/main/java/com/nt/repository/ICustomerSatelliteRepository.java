package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.CustomerSatellite;

public interface ICustomerSatelliteRepository extends JpaRepository<CustomerSatellite, Integer> {

}
