package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.JobApplicationDAO;
import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.JobApplication;

public class JobApplicationDAOTestCase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static JobApplicationDAO jobappDAO;
	
	

	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		jobappDAO = (JobApplicationDAO) context.getBean("jobappDAO");
		
	}
	
	@Ignore
	@Test
	public void applyForJobSuccessTestCase()
	{
		JobApplication jobApplication=new JobApplication();
		jobApplication.setEmail("ashutosh@gmail.com");
		jobApplication.setJobid(42);
		
		assertEquals("apply for job success test case", true, jobappDAO.saveJobApplication(jobApplication));
	}
	@Ignore
	@Test
	public void jobListTestCase()
	{
		assertEquals(1, jobappDAO.jobApplications().size());
}
	@Test 
	public void isJobAlreadyAppliedTestCase()
	{
		assertEquals("is job already applied", true, jobappDAO.isJobAlreadyApplied("ashutosh@gmail.com",42));
}
}