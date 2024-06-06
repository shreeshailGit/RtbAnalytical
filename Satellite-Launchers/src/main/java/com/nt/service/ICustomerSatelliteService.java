package com.nt.service;

import java.util.List;

import com.nt.model.CustomerSatellite;

public interface ICustomerSatelliteService {
	public CustomerSatellite registerCustomerSatellite(CustomerSatellite  customerSatellite);
	public List<CustomerSatellite> getAllCustomerSatellites();
	public CustomerSatellite updateCustomerSatelliteById(CustomerSatellite  customerSatellite);
	public CustomerSatellite fetchCustomerSatelliteById(Integer cid);	
	
	public void deleteCustomerSatelliteById(Integer cid);
}
