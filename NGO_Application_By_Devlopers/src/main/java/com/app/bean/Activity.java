package com.app.bean;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Acti_Id")
	private int actId;
	@Column(name = "Activity_Name")
	private String activity;
	private int proId;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public int getActId() {
		return actId;
	}
	public void setActId(int actId) {
		this.actId = actId;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public Activity(int actId1, String activity2) {
		super();
		this.actId = actId;
		this.activity = activity2;
	}
	public Activity(String activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}
	@Override
	public String toString() {
		return "AddActivity [actId=" + actId + ", activity=" + activity + "]";
	}
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
