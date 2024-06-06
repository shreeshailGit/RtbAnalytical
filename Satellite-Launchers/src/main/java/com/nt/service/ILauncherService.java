package com.nt.service;

import java.util.List;

import com.nt.model.Launcher;

public interface ILauncherService {
	public Launcher registerLauncher(Launcher  launcher);
	public List<Launcher> getAlllaunchers();
	public Launcher updateLauncherById(Launcher  launcher);
	public Launcher fetchLauncherById(Integer lid);
	//public Launcher getLauncherById(String launcherId);
	
	
	public void deleteLauncherById(Integer lid);
}
