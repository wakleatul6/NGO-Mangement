package com.app.Dto;

public class DonerProfile {
	private int volId;
	private String volUserId;
	private String volName;
	private String volEmail;
	private long volMob;
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
	@Override
	public String toString() {
		return "Donor Details:- [Id=" + volId + ", User_Name=" + volUserId + ", Name=" + volName + ", Email="
				+ volEmail + ", Mobile=" + volMob + "]";
	}
	public DonerProfile(int volId, String volUserId, String volName, String volEmail, long volMob) {
		super();
		this.volId = volId;
		this.volUserId = volUserId;
		this.volName = volName;
		this.volEmail = volEmail;
		this.volMob = volMob;
	}
	public DonerProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
