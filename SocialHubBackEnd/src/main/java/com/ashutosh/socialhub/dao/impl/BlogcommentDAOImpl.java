package com.ashutosh.socialhub.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.BlogcommentDAO;
import com.ashutosh.socialhub.domain.Blogcomment;


@Repository("blogcommentDAO")
@Transactional
public class BlogcommentDAOImpl implements BlogcommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Blogcomment blogcomment) {
		 
			
			try {
				 
				blogcomment.setCommentdate(new Date(System.currentTimeMillis()));
				sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
			} catch (Exception e) {
				// print the complete exception stack trace
				e.printStackTrace();
				return false;
			}
			
			return true;
		
	}

	public boolean update(Blogcomment blogcomment) {
		try {
			 
			sessionFactory.getCurrentSession().update(blogcomment);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		 
	}

	public Blogcomment get(int id) {
		Session session=sessionFactory.openSession();
		Blogcomment blogcomment=(Blogcomment)session.get(Blogcomment.class,id);
		session.close();
		return blogcomment;
	}

	public List<Blogcomment> list() {
		return sessionFactory.getCurrentSession().createQuery("from Blogcomment").list();
	}

	public boolean delete(Blogcomment blogcomment) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

}
