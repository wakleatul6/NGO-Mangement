package com.app.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Payment_Release")
public class PaymentRelease {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_Id")
	private int pay_ID;
	private String SchemeName;
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
	public String getSchemeName() {
		return SchemeName;
	}
	public void setSchemeName(String schemeName) {
		SchemeName = schemeName;
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
	@Override
	public String toString() {
		return "PaymentRelease [pay_ID=" + pay_ID + ", SchemeName=" + SchemeName + ", project_Name=" + project_Name
				+ ", activity=" + activity + ", amount=" + amount + ", date=" + date + "]";
	}
	public PaymentRelease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentRelease(int pay_ID, String schemeName, String project_Name, String activity, double amount,
			LocalDate date) {
		super();
		this.pay_ID = pay_ID;
		SchemeName = schemeName;
		this.project_Name = project_Name;
		this.activity = activity;
		this.amount = amount;
		this.date = date;
	}
}