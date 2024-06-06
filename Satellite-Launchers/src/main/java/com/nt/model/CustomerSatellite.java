package com.nt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class CustomerSatellite {

	@Id
	@SequenceGenerator(name = "cid_seq",sequenceName = "CID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "cid_seq",strategy = GenerationType.SEQUENCE)
	@Column(name="CID")
	private Integer cid;
	
	@Column(name="CUSTOMER_ID")
	private String customerId;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="LAUNCHER_DATE")
	private Date launcherDate;
	@Column(name="MASS")
	private String mass;
	@Column(name="LAUNCHER")
	private String launcher;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getLauncherDate() {
		return launcherDate;
	}
	public void setLauncherDate(Date launcherDate) {
		this.launcherDate = launcherDate;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}
	public String getLauncher() {
		return launcher;
	}
	public void setLauncher(String launcher) {
		this.launcher = launcher;
	}
	
	
	@Override
	public String toString() {
		return "CustomerSatellite [cid=" + cid + ", customerId=" + customerId + ", country=" + country
				+ ", launcherDate=" + launcherDate + ", mass=" + mass + ", launcher=" + launcher + "]";
	}
	
}
