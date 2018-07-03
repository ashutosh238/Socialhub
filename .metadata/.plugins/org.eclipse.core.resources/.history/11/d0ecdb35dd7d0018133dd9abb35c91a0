package com.ashutosh.socialhub.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class JobDetail {
	
	@Id
	@GeneratedValue(generator="jobid_seq")
	@SequenceGenerator(name="jobid_seq",sequenceName="JOBID_SEQ", allocationSize=1)
	private int jobId;
	private String Designation;
	private String roles ;
	private String company;
	private Date LastDate;
	private String location;
	private int ctc;
	private String skills;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getRoleandResp() {
		return roles;
	}
	public void setRoleandResp(String roleandResp) {
		roles = roleandResp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getLastDate() {
		return LastDate;
	}
	public void setLastDate(Date lastDate) {
		LastDate = lastDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	
	
}
