package com.ashutosh.socialhub.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.JobDetail;


@Repository("jobdetailDAO")
@Transactional
public class JobDetailDAOImpl implements JobDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public boolean save(JobDetail jobdetail) {
		try {
			 
			jobdetail.setLastDate(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().saveOrUpdate(jobdetail);
		} catch (Exception e) {
			// print the complete exception stack trace
			e.printStackTrace();
			return false;
		}
		
		return true;
	
}
	

	
	public boolean update(JobDetail jobdetail) {
		try {
			 
			sessionFactory.getCurrentSession().update(jobdetail);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean delete(JobDetail jobdetail) {
		try
		{
			sessionFactory.getCurrentSession().delete(jobdetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	
	public JobDetail get(int id) {
		Session session=sessionFactory.openSession();
		JobDetail jobdetail=(JobDetail)session.get(JobDetail.class,id);
		session.close();
		return jobdetail;
		
	}

	
	public List<JobDetail> list() {
		return sessionFactory.getCurrentSession().createQuery("from JobDetail").list();
	}

}
