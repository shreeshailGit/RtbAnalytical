package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Launcher;
import com.nt.repository.ILauncherRepository;
@Service
public class LauncherServiceMgmtImpl implements ILauncherService {

private static Logger LOGGER = LoggerFactory.getLogger(LauncherServiceMgmtImpl.class);
	
	@Autowired
	private ILauncherRepository repository;
	
	@Override
	public Launcher registerLauncher(Launcher launcher) {
		LOGGER.info("Calling registerLauncher method ");
		Launcher res = repository.save(launcher);
		LOGGER.info("registerLauncher method executed successfully ");
		return res;
	}

	@Override
	public List<Launcher> getAlllaunchers() {
		LOGGER.info("Calling getAlllaunchers method ");
		List<Launcher> list = repository.findAll();
		LOGGER.info(" getAlllaunchers method executed successfully ");
		return list;
	}

	@Override
	public Launcher updateLauncherById(Launcher launcher) {
		LOGGER.info("Calling updateLauncherById method :{}",launcher );
		Optional<Launcher> opt = repository.findById(launcher.getLid());
		LOGGER.info("fetching details updateLauncherById method :{}",opt.get() );
		if(opt.isPresent()) {
			Launcher ipl = opt.get();
			Launcher i = repository.save(launcher);
			 return i;   
		}else {
         return	repository.save(launcher);
		}
	}

	@Override
	public Launcher fetchLauncherById(Integer lid) {
		LOGGER.info("Calling fetchLauncherById method ");
		Optional<Launcher> opt = repository.findById(lid);
		if(opt.isPresent()) {
			LOGGER.info(" fetchLauncherById method executed successfully ");
		   return	opt.get();
		}
		throw new IllegalArgumentException( lid + " Launcher is not Found");
	}

	/*@Override
	public Launcher getLauncherById(String launcherId) {
		return repository.getReferenceById(Integer.parseInt(launcherId));
	}*/

	@Override
	public void deleteLauncherById(Integer lid) {
		LOGGER.info("Calling deleteLauncherById method ");
		repository.deleteById(lid);
	}

}
