package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.ForumDAO;
import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.Forum;



public class ForumDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ForumDAO forumDAO;
	
	@Autowired
private static Forum forum;
	
	
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		forumDAO = (ForumDAO) context.getBean("forumDAO");
		
		
}
	
	@Test
	public void addJob()
	
	{
		Forum forum=new Forum();
		forum.setForumContent("string");
		forum.setForumName("hcl");
		forum.setLoginname("Ashutosh");
		forum.setStatus("NA");
		assertTrue("problem",forumDAO.save(forum));
		
	}
	
}
