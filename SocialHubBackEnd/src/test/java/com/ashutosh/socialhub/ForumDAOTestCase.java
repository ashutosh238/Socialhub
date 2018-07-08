package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.ForumDAO;
import com.ashutosh.socialhub.dao.JobDetailDAO;
import com.ashutosh.socialhub.domain.Blog;
import com.ashutosh.socialhub.domain.Forum;

import junit.framework.Assert;



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
	
	@Ignore
	@Test
	public void addForumTopicTestCase()
	
	{
		Forum forum=new Forum();
		forum.setForumContent("issues are harmful effects of human activity");
		forum.setForumName("Environmental");
		forum.setLoginname("Sunita");
		forum.setStatus("NA");
		assertTrue("problem",forumDAO.saveForum(forum));
		
	}
	@Ignore
	@Test
	public void forumDeleteTestCase()
	{
		
		assertTrue("Problem in Deleting:",forumDAO.deleteforum(24));
		
	}
	 
	@Test
	public void approveForumTopicTestCase()
	
	{	
		assertTrue("Problem in Approving:",forumDAO.approveForum(25));
		
	}
	
	@Ignore
	@Test
	public void rejectForumTopicTestCase()
	
	{	
		assertTrue("Problem in Approving:",forumDAO.rejectForum(25));
		
	}
	
	@Ignore
	@Test
	public void getAllForum()
	{
		int size = forumDAO.forumList().size();
		
		Assert.assertEquals(2, size);
	}
	
	@Test
	public void getAllAprovedForum()
	{
		int size = forumDAO.approvedForumsList().size();
		
		Assert.assertEquals(2, size);
	}
}
