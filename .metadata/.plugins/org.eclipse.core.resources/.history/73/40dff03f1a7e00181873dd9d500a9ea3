package com.ashutosh.socialhub.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "C_PROFILE")
public class ProfileImage 
{
	@Id
	private String loginname;
	private byte[] profilepicture;
	
	
	public byte[] getProfilepicture() {
		return profilepicture;
	}
	public void setProfilepicture(byte[] profilepicture) {
		this.profilepicture = profilepicture;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	
}