package com.app.Dto;

public class UserProfile {
	private int volId;
	private String volName;
	private long volMob;
	private String volEmail;
	private String volUserId;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getVolId() {
		return volId;
	}

	public void setVolId(int volId) {
		this.volId = volId;
	}

	public String getVolName() {
		return volName;
	}

	public void setVolName(String volName) {
		this.volName = volName;
	}

	public long getVolMob() {
		return volMob;
	}

	public void setVolMob(long volMob) {
		this.volMob = volMob;
	}

	public String getVolEmail() {
		return volEmail;
	}

	public void setVolEmail(String volEmail) {
		this.volEmail = volEmail;
	}

	public String getVolUserId() {
		return volUserId;
	}

	public void setVolUserId(String volUserId) {
		this.volUserId = volUserId;
	}

	public UserProfile(int volId, String volName, long volMob, String volEmail, String volUserId, String msg) {
		super();
		this.volId = volId;
		this.volName = volName;
		this.volMob = volMob;
		this.volEmail = volEmail;
		this.volUserId = volUserId;
		this.msg = msg;
	}

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return (msg + "\n" + "Doner Details:-" + "\n" + "Name=" + volName + "\n" + "Mobile_NO=" + volMob + "\n"
				+ "Email=" + volEmail + "\n" + "User_Id=" + volUserId);
	
	}

}