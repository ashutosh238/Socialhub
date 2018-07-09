package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.JobDetail;

public interface JobDetailDAO {
	
	
	
	public boolean saveJob(JobDetail job);			
	public boolean updateJob(JobDetail job);			
	public boolean deleteJob(int jobid);		
	public JobDetail getJob(int jobid); 				
	public List<JobDetail> jobList(); 	
	public JobDetail get(int id); 
	
	

}
