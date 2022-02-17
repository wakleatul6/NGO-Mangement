 package com.app.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Donor")
public class Donor {
	@Id
	private int volId;
	private String volUserId;
	private String volName;
	private String volEmail;
	private long volMob;
	private String volPass;
	public int getVolId() {
		return volId;
	}
	public void setVolId(int volId) {
		this.volId = volId;
	}
	public String getVolUserId() {
		return volUserId;
	}
	public void setVolUserId(String volUserId) {
		this.volUserId = volUserId;
	}
	public String getVolName() {
		return volName;
	}
	public void setVolName(String volName) {
		this.volName = volName;
	}
	public String getVolEmail() {
		return volEmail;
	}
	public void setVolEmail(String volEmail) {
		this.volEmail = volEmail;
	}
	public long getVolMob() {
		return volMob;
	}
	public void setVolMob(long volMob) {
		this.volMob = volMob;
	}
	public String getVolPass() {
		return volPass;
	}
	public void setVolPass(String volPass) {
		this.volPass = volPass;
	}
	public Donor(int volId, String volName, String volUserId,  String volEmail, long volMob, String volPass) {
		super();
		this.volId = volId;
		this.volUserId = volUserId;
		this.volName = volName;
		this.volEmail = volEmail;
		this.volMob = volMob;
		this.volPass = volPass;
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
		this.volId = volId;
		this.volUserId = volUserId;
		this.volName = volName;
		this.volEmail = volEmail;
		this.volMob = volMob;
		this.volPass = volPass;
	}
	
	@Override
	public String toString() {
		return "Donor [volId=" + volId + ", volUserId=" + volUserId + ", volName=" + volName + ", volEmail=" + volEmail
				+ ", volMob=" + volMob + ", volPass=" + volPass + "]";
	}
	
	
	
	
	
}
