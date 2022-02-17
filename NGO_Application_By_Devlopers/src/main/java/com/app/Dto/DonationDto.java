package com.app.Dto;

import java.time.LocalDate;

public class DonationDto {
	private int pay_ID;
	private String doner;
	private String project;
	private String activity;
	private double amount;
	private LocalDate date;
	public int getPay_ID(int pay_ID) {
		return pay_ID;
	}
	public void setPay_ID(int pay_ID) {
		this.pay_ID = pay_ID;
	}
	public String getDoner() {
		return doner;
	}
	public void setDoner(String doner) {
		this.doner = doner;
	}
	public String getProject_Name() {
		return project;
	}
	public void setProject_Name(String project_Name) {
		this.project = project_Name;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public DonationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonationDto(int pay_ID, String doner, String project, String activity, double amount, LocalDate date) {
		super();
		this.pay_ID = pay_ID;
		this.doner = doner;
		this.project = project;
		this.activity = activity;
		this.amount = amount;
		this.date = date;
	}
	@Override
	public String toString() {
		return "DonationDto [pay_ID=" + pay_ID + ", doner=" + doner + ", project_Name=" + project + ", activity="
				+ activity + ", amount=" + amount + ", date=" + date + "]";
	}
}
