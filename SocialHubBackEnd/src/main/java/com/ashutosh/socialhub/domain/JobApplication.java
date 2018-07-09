package com.ashutosh.socialhub.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table

public class JobApplication {
	
	@Id
	@GeneratedValue(generator="jobappid_seq")
	@SequenceGenerator(name="jobappid_seq",sequenceName="JOBAPPID_SEQ", allocationSize=1)
	private int jobappid;
	private String email;
	private String loginname;
	private int jobid;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date applied_date;
	private String jobtitle;
	private String jobdescription;
	private char jobappstatus;
	private String reason;
	
	
	public int getJobappid() {
		return jobappid;
	}
	public void setJobappid(int jobappid) {
		this.jobappid = jobappid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public Date getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Date applied_date) {
		this.applied_date = applied_date;
	}
	public char getJobappstatus() {
		return jobappstatus;
	}
	public void setJobappstatus(char jobappstatus) {
		this.jobappstatus = jobappstatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


}
