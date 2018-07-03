package com.ashutosh.socialhub.dao;

import org.springframework.stereotype.Component;

import com.ashutosh.socialhub.domain.ProfileImage;

@Component
public interface ProfilePictureDAO 
{
	public boolean uploadProfile(ProfileImage Profile);
	public ProfileImage getProfile(String loginname);
	
}