package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.nt.model.Launcher;
import com.nt.service.ILauncherService;


@RequestMapping("/launcher-api")
@RestController
@CrossOrigin("http://localhost:3000")
public class LauncherOperationController {

	@Autowired
	private ILauncherService launcherService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(LauncherOperationController.class);

	@InitBinder
	public void initBinderForAlldates(WebDataBinder binder) {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		  dateFormat.setLenient(false);
		  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	//dummy
	@GetMapping("/launcher/list")
	public ResponseEntity<List<Launcher>> getAllLauncherList(){
		List<Launcher> list= new ArrayList<>();
		Launcher l1 = new Launcher();
		l1.setLauncherId("LSV-BW1");l1.setLauncherType("PSLV");l1.setRegDate(new Date(01-06-2024));
		Launcher l2 = new Launcher();
		l2.setLauncherId("LSV-BW2");l2.setLauncherType("GSLV");l2.setRegDate(new Date(05-06-2024));
		list.add(l1);list.add(l2);
		System.err.println("List of Lauchner : "+list );
		List<Launcher> listt = launcherService.getAlllaunchers();
		list.addAll(listt);
		return new ResponseEntity<List<Launcher>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerLauncher(@RequestBody Launcher launcher){
		
		Launcher result = launcherService.registerLauncher(launcher);
		LOGGER.info("registerLauncher method --controller");
		if(result != null) {
			return new ResponseEntity<String>(result.getLid()+" "+ result.getLauncherId() +" Launcher is registered successfully ",HttpStatus.OK);
		}
		LOGGER.info("Problem in registerLauncher method --controller");
		throw new IllegalArgumentException("Launcher is Failed to register ");
		
	}
	
	@GetMapping("/fetch-all")
	public ResponseEntity<?> fetchAllLauncher(){
		try {
			//use service		
			List<Launcher> list = launcherService.getAlllaunchers();
			LOGGER.info("fetchAllLauncher method --controller");
			return new ResponseEntity<List<Launcher>>(list, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.info("Problem in fetchAllLauncher method --controller");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@PutMapping("/update/{lid}")
	public ResponseEntity<String> updateLauncherById(@RequestBody Launcher launcher,@PathVariable String lid){ //2nd param need to update
		LOGGER.info("Calling updateLauncherById method :{} {}",launcher, lid );
		Launcher result = launcherService.updateLauncherById(launcher);	
	    if(result != null) {
	    	return new ResponseEntity<String>(result.getLid()+" Launcher ID "+result.getLauncherId()+ " is updated successfully ", HttpStatus.OK);
	    }
	    throw new IllegalArgumentException("Launcher is Failed To updated ");
	}
	
	@GetMapping("/fetch-by-id/{lid}")
	public ResponseEntity<Launcher> fetchLauncherById(@PathVariable Integer lid){
		Launcher result = launcherService.fetchLauncherById(lid);
		LOGGER.info("fetchLauncherById method --controller :{}",result);
		return new ResponseEntity<Launcher>(result, HttpStatus.OK);
	}
	
	/*@GetMapping("/find/{id}")
	public ResponseEntity<?> getLauncherById(@PathVariable String launcherId){
		try {
			Launcher result = launcherService.getLauncherById(launcherId);
		    LOGGER.info("showLauncherById method --controller");
		    return new ResponseEntity<Launcher>(result, HttpStatus.OK);
		}catch(Exception e) {
			 LOGGER.info("Problem in showLauncherById method --controller");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}*/
	
	@DeleteMapping("/delete-by-id/{lid}")
	public  ResponseEntity<String>  deleteLauncherById(@PathVariable Integer lid){
		LOGGER.info("Calling deleteLauncherById method :{}",lid);
		if(lid != null) {
			LOGGER.info("--if condition deleteLauncherById method ");
		    launcherService.deleteLauncherById(lid);
		   return new ResponseEntity<String>(lid +" Launcher is deleted successfully..", HttpStatus.OK);
		}else {
			LOGGER.info("--else condition deleteLauncherById method ");
			   return new ResponseEntity<String>(lid +" Launcher is not Found", HttpStatus.OK);
		}
	}
	
}
