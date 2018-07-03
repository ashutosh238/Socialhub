package com.ashutosh.socialhub.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.ForumDAO;
import com.ashutosh.socialhub.domain.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public boolean save(Forum forum) {
		try {
			 
			forum.setCreatedDate(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
		} catch (Exception e) {
			// print the complete exception stack trace
			e.printStackTrace();
			return false;
		}
		
		return true;
	
}
	public boolean update(Forum forum) {
		try {
			 
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean delete(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	
	public Forum get(int id) {
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,id);
		session.close();
		return forum;
		
	}

	
	public List<Forum> list() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}


}
