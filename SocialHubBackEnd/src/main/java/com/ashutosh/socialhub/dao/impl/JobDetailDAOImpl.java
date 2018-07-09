package com.ashutosh.socialhub.dao.impl;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.JobDetail;


@Transactional
@Repository("jobdetailDAO")
public class JobDetailDAOImpl implements JobDetailDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private JobDetailDAO jobdetailDAO;
	
	
	public boolean saveJob(JobDetail job) {
		try {
			
			job.setLastDate(new Date(System.currentTimeMillis()));
			
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateJob(JobDetail job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	public JobDetail get(int id) {
		Session session=sessionFactory.openSession();
		JobDetail job=(JobDetail)session.get(JobDetail.class,id);
		session.close();
		return job;
	}
	
	public JobDetail getJob(int jobid) {
		return (JobDetail) sessionFactory.getCurrentSession().createCriteria(JobDetail.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();
	}

	public List<JobDetail> jobList() {
		return sessionFactory.getCurrentSession().createQuery("from JobDetail").list();
	}

	public List<JobDetail> jobList(char jobstatus) {
		return sessionFactory.getCurrentSession().createCriteria(JobDetail.class).add(Restrictions.eq("jobstatus", jobstatus)).list();
	}
	
	
	public boolean isJobOpened(int jobid) {
		JobDetail job = (JobDetail) sessionFactory.getCurrentSession().createCriteria(JobDetail.class).add(Restrictions.eq("jobid", jobid)).uniqueResult();

		if (job != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteJob(int jobid) {
		try {
			sessionFactory.getCurrentSession().delete(getJob(jobid));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	
}