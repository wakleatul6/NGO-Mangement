package com.app.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Donation_Details")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_Id")
	private int pay_ID;
	private String doner;
	private String project_Name;
	private String activity;
	private double amount;
	private LocalDate date;
	public int getPay_ID() {
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
		return project_Name;
	}
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public  double getAmount() {
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
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment( String doner, String project_Name, String activity, double amount, LocalDate date) {
		super();
		
		this.doner = doner;
		this.project_Name = project_Name;
		this.activity = activity;
		this.amount = amount;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Payment [pay_ID=" + pay_ID + ", doner=" + doner + ", project_Name=" + project_Name + ", activity="
				+ activity + ", amount=" + amount + ", date=" + date + "]";
	}
}	