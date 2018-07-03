package com.ashutosh.socialhub.dao.impl;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.ProfilePictureDAO;
import com.ashutosh.socialhub.domain.ProfileImage;


@Repository("profilepictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean uploadProfile(ProfileImage Profile) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(Profile);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ProfileImage getProfile(String loginname) {
		return (ProfileImage) sessionFactory.getCurrentSession().get(ProfileImage.class, loginname);
	}
	
	
}