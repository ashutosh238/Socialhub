package com.ashutosh.socialhub.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table

public class Friend {
	@Id
	@GeneratedValue(generator="friendid_seq")
	@SequenceGenerator(name="friendid_seq",sequenceName="FRIENDID_SEQ", allocationSize=1)
	private int friendid;
	private String loginname;
	private String friendloginname;
	private String status;
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFriendlogonname() {
		return friendloginname;
	}
	public void setFriendlogonname(String friendloginname) {
		this.friendloginname = friendloginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
