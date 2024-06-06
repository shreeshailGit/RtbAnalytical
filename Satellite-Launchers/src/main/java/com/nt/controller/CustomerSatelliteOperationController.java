package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.CustomerSatellite;
import com.nt.service.ICustomerSatelliteService;


@RequestMapping("/customer-satellite-api")
@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerSatelliteOperationController {

	@Autowired
	private ICustomerSatelliteService customerSatelliteService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerSatelliteOperationController.class);

	@InitBinder
	public void initBinderForAlldates(WebDataBinder binder) {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  dateFormat.setLenient(false);
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	

	@PostMapping("/register-customer")
	public ResponseEntity<String> registerCustomerSatellite(@RequestBody CustomerSatellite customerSatellite){
		
		CustomerSatellite result = customerSatelliteService.registerCustomerSatellite(customerSatellite);
		LOGGER.info("registerCustomerSatellite method --controller");
		if(result != null) {
			return new ResponseEntity<String>(result.getCid()+" "+ result.getCustomerId() +" Customer Satellite is registered successfully ",HttpStatus.OK);
		}
		LOGGER.info("Problem in registerCustomerSatellite method --controller");
		throw new IllegalArgumentException("Satellite is Failed to register ");
		
	}
	
	@GetMapping("/fetch-all-customer")
	public ResponseEntity<?> fetchAllCustomerSatellites(){
		try {
			//use service		
			List<CustomerSatellite> list = customerSatelliteService.getAllCustomerSatellites();
			LOGGER.info("fetchAllCustomerSatellites method --controller");
			return new ResponseEntity<List<CustomerSatellite>>(list, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Problem in fetchAllCustomerSatellites method --controller");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@PutMapping("/update-customer/{cid}")
	public ResponseEntity<String> updateCustomerSatelliteById(@RequestBody CustomerSatellite customerSatellite,@PathVariable String cid){ 
		LOGGER.info("Calling updateLauncherById method :{} {}",customerSatellite, cid );
		CustomerSatellite result = customerSatelliteService.updateCustomerSatelliteById(customerSatellite);	
	    if(result != null) {
	    	return new ResponseEntity<String>(result.getCid()+" Launcher ID "+result.getCustomerId()+ " is updated successfully ", HttpStatus.OK);
	    }
	    throw new IllegalArgumentException("Satellite is Failed To updated ");
	}
	
	@GetMapping("/fetch-by-id-customer/{cid}")
	public ResponseEntity<CustomerSatellite> fetchcustomerSatelliteById(@PathVariable Integer cid){
		CustomerSatellite result = customerSatelliteService.fetchCustomerSatelliteById(cid);
		LOGGER.info("fetchcustomerSatelliteById method --controller :{}",result);
		return new ResponseEntity<CustomerSatellite>(result, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete-by-id-customer/{cid}")
	public  ResponseEntity<String>  deleteCustomerSatelliteById(@PathVariable Integer cid){
		LOGGER.info("Calling deleteCustomerSatelliteById method :{}",cid);
		if(cid != null) {
			LOGGER.info("--if condition deleteCustomerSatelliteById method ");
			customerSatelliteService.deleteCustomerSatelliteById(cid);
		   return new ResponseEntity<String>(cid +" Satellite is deleted successfully..", HttpStatus.OK);
		}else {
			LOGGER.info("--else condition deleteCustomerSatelliteById method ");
			   return new ResponseEntity<String>(cid +" Satellite is not Found", HttpStatus.OK);
		}
	}
	
}
