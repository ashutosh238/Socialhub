package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.ForumCommentDAO;
import com.ashutosh.socialhub.domain.ForumComment;

public class ForumCommentTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ForumCommentDAO forumcommentDAO;
	
	
	
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		forumcommentDAO = (ForumCommentDAO) context.getBean("forumcommentDAO");
		
		
}
	
	@Test
	public void addForumComment()
	
	{
		ForumComment forumcomment=new ForumComment();
		
		forumcomment.setDiscussiontxt("discussiontxt");
		forumcomment.setForumid(2);
		forumcomment.setLoginname("Ashutosh");
		assertTrue("problem",forumcommentDAO.save(forumcomment));


		
	}
	
}

