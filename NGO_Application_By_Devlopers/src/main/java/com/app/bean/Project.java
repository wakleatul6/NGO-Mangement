package com.app.bean;

import javax.persistence.CascadeType; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="project")
public class Project {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="project_Id")
		private int proId;
		private String projectName;
		@OneToMany(targetEntity = Activity.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
		@JoinColumn(name="projectId",referencedColumnName = "proId")
		
		public int getProId() {
			return proId;
		}
		public void setProId(int proId) {
			this.proId = proId;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		@Override
		public String toString() {
			return "ProjectList [proId=" + proId + ", projectName=" + projectName + "]";
		}
		public Project(String name1, int id2) {
			super();
			// TODO Auto-generated constructor stub
			this.proId = id2;
			this.projectName = name1;
		}
		public Project( String projectName) {
			
			this.projectName = projectName;
		}
		public Project() {
			super();
			// TODO Auto-generated constructor stub
		}
	
}
