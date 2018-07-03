package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.JobDetail;

public interface JobDetailDAO {
	
	
	
	public boolean save(JobDetail jobdetail);
	public boolean update(JobDetail jobdetail);
	public boolean delete(JobDetail jobdetail);
	public JobDetail get(int id);
	public List<JobDetail> list();

}
