package com.nt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Launcher {

	@Id
	@SequenceGenerator(name = "lid_seq",sequenceName = "LID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "lid_seq",strategy = GenerationType.SEQUENCE)
	@Column(name="LID")
	private Integer lid;
	
	@Column(name="LAUNCHER_ID")
	private String launcherId;
	@Column(name="LAUNCHER_TYPE")
	private String launcherType;
	@Column(name="REG_DATE")
	private Date regDate;

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLauncherId() {
		return launcherId;
	}

	public void setLauncherId(String launcherId) {
		this.launcherId = launcherId;
	}

	public String getLauncherType() {
		return launcherType;
	}

	public void setLauncherType(String launcherType) {
		this.launcherType = launcherType;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Launcher [lid=" + lid + ", launcherId=" + launcherId + ", launcherType=" + launcherType + ", regDate="
				+ regDate + "]";
	}
	
	
	
	
}
