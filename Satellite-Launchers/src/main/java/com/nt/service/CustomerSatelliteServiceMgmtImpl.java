package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.CustomerSatellite;
import com.nt.repository.ICustomerSatelliteRepository;
@Service
public class CustomerSatelliteServiceMgmtImpl implements ICustomerSatelliteService {

private static Logger LOGGER = LoggerFactory.getLogger(CustomerSatelliteServiceMgmtImpl.class);
	
	@Autowired
	private ICustomerSatelliteRepository repository;

	@Override
	public CustomerSatellite registerCustomerSatellite(CustomerSatellite customerSatellite) {
		LOGGER.info("Calling registerCustomerSatellite method ");
		CustomerSatellite res = repository.save(customerSatellite);
		LOGGER.info("registerCustomerSatellite method executed successfully ");
		return res;
	}

	@Override
	public List<CustomerSatellite> getAllCustomerSatellites() {
		LOGGER.info("Calling getAllCustomerSatellites method ");
		List<CustomerSatellite> list = repository.findAll();
		LOGGER.info(" getAllCustomerSatellites method executed successfully ");
		return list;
	}

	@Override
	public CustomerSatellite updateCustomerSatelliteById(CustomerSatellite customerSatellite) {
		LOGGER.info("Calling updateCustomerSatelliteById method :{}",customerSatellite );
		Optional<CustomerSatellite> opt = repository.findById(customerSatellite.getCid());
		LOGGER.info("fetching details updateCustomerSatelliteById method :{}",opt.get() );
		if(opt.isPresent()) {
			CustomerSatellite ie = opt.get();
			CustomerSatellite i = repository.save(customerSatellite);
			 return i;   
		}else {
         return	repository.save(customerSatellite);
		}
	}

	@Override
	public CustomerSatellite fetchCustomerSatelliteById(Integer cid) {
		LOGGER.info("Calling fetchCustomerSatelliteById method ");
		Optional<CustomerSatellite> opt = repository.findById(cid);
		if(opt.isPresent()) {
			LOGGER.info(" fetchCustomerSatelliteById method executed successfully ");
		   return	opt.get();
		}
		throw new IllegalArgumentException( cid + " Satellite is not Found");
	}

	@Override
	public void deleteCustomerSatelliteById(Integer cid) {
		LOGGER.info("Calling deleteCustomerSatelliteById method :{}",cid);
		repository.deleteById(cid);
	}
	
	
}
