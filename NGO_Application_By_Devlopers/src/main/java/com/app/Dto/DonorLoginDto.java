package com.app.Dto;

public class DonorLoginDto {
private String volUserId;
private String volPass;
public String getVolUserId() {
	return volUserId;
}
public void setVolUserId(String volUserId) {
	this.volUserId = volUserId;
}
public String getVolPass() {
	return volPass;
}
public void setVolPass(String volPass) {
	this.volPass = volPass;
}
public DonorLoginDto() {
	super();
	// TODO Auto-generated constructor stub
}
public DonorLoginDto(String volUserId, String volPass) {
	super();
	this.volUserId = volUserId;
	this.volPass = volPass;
}
@Override
public String toString() {
	return "DonorLoginDto [volUserId=" + volUserId + ", volPass=" + volPass + "]";
}
}
