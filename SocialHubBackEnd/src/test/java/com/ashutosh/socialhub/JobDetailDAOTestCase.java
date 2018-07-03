package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.JobDetailDAO;
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
	
	@Test
	public void addJob()
	
	{
		JobDetail jobdetail=new JobDetail();
		jobdetail.setCompany("HCL");
		jobdetail.setCtc(150000);
		jobdetail.setDesignation("Lead");
		//jobdetail.setJobId();
		//jobdetail.setLastDate(lastDate);
		jobdetail.setLocation("Hyderabad");
		jobdetail.setRoleandResp("Emp");
		jobdetail.setSkills("Algorithms");
		assertTrue("problem",jobdetailDAO.save(jobdetail));
		
	}
	
}
