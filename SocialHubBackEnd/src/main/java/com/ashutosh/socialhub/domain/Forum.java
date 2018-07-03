package com.ashutosh.socialhub.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity

public class Forum {

	

	@Id
	@GeneratedValue(generator="forumid_seq")
	@SequenceGenerator(name="forumid_seq",sequenceName="FORUMID_SEQ", allocationSize=1)
	private int forumId	;

	private String forumName;	

	private String forumContent	;

	private Date createDate;	

	private String loginname	;

	private String status;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}

	public Date getCreatedDate() {
		return createDate;
	}

	public void setCreatedDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	
	
}
