package com.ashutosh.socialhub.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.JobApplicationDAO;
import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.JobApplication;

@Transactional
@Repository("jobappDAO")
public class JobApplicationDAOImpl implements JobApplicationDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private JobDetailDAO jobdetailDAO;
	
	@Autowired
	private JobApplicationDAO jobappDAO;
	
	public boolean saveJobApplication(JobApplication jobApplication) {
		try {
				
				jobApplication.setJobappstatus('N');
				jobApplication.setApplied_date(new Date());
				if(jobApplication.getReason() == null || jobApplication.getReason() == " ")
				{
					jobApplication.setReason("Interested");
				}
				
				sessionFactory.getCurrentSession().save(jobApplication);
				return true;
				
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}
	
	public List<JobApplication> jobApplications()
	{
		return sessionFactory.getCurrentSession().createQuery("from JobApplication").list();
	}

	public List<JobApplication> jobApplicationlist(int jobid) {
		return sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("jobid", jobid)).list();
	}

	public boolean isJobAlreadyApplied(String loginname, int jobid) {

		//select * from JobApplication where emailID = ? and jobID = ?
		JobApplication jobApplication = (JobApplication) sessionFactory.getCurrentSession()
				.createCriteria(JobApplication.class)
				.add(Restrictions.eq("loginname", loginname))
				.add(Restrictions.eq("jobappid", jobid)).uniqueResult();

		if (jobApplication == null) {
			return false;
		}
		return true;
	}

	public List<JobApplication> jobApplicationList(String loginname) {
		return sessionFactory.getCurrentSession().createCriteria(JobApplication.class).add(Restrictions.eq("loginname", loginname)).list();
	}

	

	public boolean approveApplication(int jobappid) {
		JobApplication jobApplication = jobappDAO.getApplication(jobappid);
		try {
			jobApplication.setJobappstatus('A');
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean rejectApplication(int jobappid) {
		JobApplication jobApplication = jobappDAO.getApplication(jobappid);
		try {
			jobApplication.setJobappstatus('R');
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public JobApplication getApplication(int jobappid) {
		return sessionFactory.getCurrentSession().get(JobApplication.class, jobappid);
	}

	public boolean deletejobapp(int jobappid) {
		try {
			sessionFactory.getCurrentSession().delete(getApplication(jobappid));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

}
