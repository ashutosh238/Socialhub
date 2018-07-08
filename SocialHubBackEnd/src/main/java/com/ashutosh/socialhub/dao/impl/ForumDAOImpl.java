package com.ashutosh.socialhub.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.ForumDAO;
import com.ashutosh.socialhub.domain.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public boolean saveForum(Forum forum) {
		try {
			
			forum.setStatus("NA");
			forum.setCreatedDate(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteforum(int forumid) {
		try {
			sessionFactory.getCurrentSession().delete(getForum(forumid));
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public Forum getForum(int forumid) {
		return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumid);
	}

	public boolean approveForum(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean rejectForum(int forumid) {
		try {
			Forum forum = getForum(forumid);
			forum.setStatus("R");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public List<Forum> approvedForumsList() {
		return sessionFactory.getCurrentSession().createQuery("from Forum where status = 'A'").list();
		
	}

	public List<Forum> forumList() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	
	
}
