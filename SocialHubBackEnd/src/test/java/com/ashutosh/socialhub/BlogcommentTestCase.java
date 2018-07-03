package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ashutosh.socialhub.dao.BlogcommentDAO;
import com.ashutosh.socialhub.domain.Blogcomment;

import junit.framework.Assert;

public class BlogcommentTestCase {
	

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static BlogcommentDAO blogcommentDAO;
	
	@Autowired
private static Blogcomment blogcomment;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		blogcommentDAO = (BlogcommentDAO) context.getBean("blogcommentDAO");
		
		blogcomment = (Blogcomment) context.getBean("blogcomment");
		
}
	
	
	 
	@Test
	public void addBlogCommentTestCase()
	{	 
		//blogcomment.setBlogid(9);
		blogcomment.setCommenttext("Its a ver nice blog for information");
		blogcomment.setLoginname("George");
		
		
		Assert.assertEquals("Add Blogcomment Test Case" , true  , blogcommentDAO.save(blogcomment));
		
	}

	@Ignore
@Test
public void deleteBlogTest()
{
	Blogcomment blogcomment=blogcommentDAO.get(5);
	assertTrue("Problem in Deleting:",blogcommentDAO.delete(blogcomment));
}
	@Ignore
	@Test
	public void UpdateBlogTest()
	{
		/*Blogcomment blogcomment=blogcommentDAO.get(4);
		blogcomment.setStatus("A");
		blogcomment.setBolgContent("Spring handels the infrastructure due to which develoger imphesises on buiseness logic");
		assertTrue("Problem in Updateing:",blogcommentDAO.update(blogcomment));
	*/}
	@Ignore
	@Test
	public void getAllBlogs()
	{
		int size = blogcommentDAO.list().size();
		
		Assert.assertEquals(5, size);
	}

}
