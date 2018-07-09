package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.JobApplication;
import com.ashutosh.socialhub.domain.JobDetail;



public class JobDetailDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static JobDetailDAO jobdetailDAO;
	
	@Autowired
private static JobDetail jobdetail;
	
	
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		jobdetailDAO = (JobDetailDAO) context.getBean("jobdetailDAO");
		
		
}
	@Ignore
	@Test
	public void addJob()
	
	{	JobDetail jobdetail=new JobDetail();
		jobdetail.setCompany("Accenture");
		jobdetail.setDesignation("Developer");
		jobdetail.setLocation("Hyderabad");
		jobdetail.setRoleandResp("Team Leader");
		jobdetail.setSkills("Spring Framework");
		jobdetail.setCtc(1500000);
		assertTrue("problem",jobdetailDAO.saveJob(jobdetail));
		
	}
@Ignore
	@Test
	public void UpdateJobDetail()
	
	{	JobDetail jobdetail=jobdetailDAO.get(42);
	    jobdetail.setCompany("Google");	
	assertTrue("problem",jobdetailDAO.updateJob(jobdetail));
		
	}
	
@Ignore
	@Test
	public void getJobSuccessTestCase()
	{
		JobDetail job = jobdetailDAO.get(21);
		assertNotNull(job);
		System.out.println(job.getJobId()+" "+job.getDesignation()+" "+job.getRoleandResp());	
		
	}

@Ignore
@Test
public void jobListTestCase()
{
	assertEquals(6, jobdetailDAO.jobList().size());
}
	

}
