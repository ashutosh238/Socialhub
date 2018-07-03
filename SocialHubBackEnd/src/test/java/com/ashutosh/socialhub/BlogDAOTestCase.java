package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ashutosh.socialhub.dao.BlogDAO;
import com.ashutosh.socialhub.domain.Blog;

import junit.framework.Assert;

public class BlogDAOTestCase {
	

private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static BlogDAO blogDAO;
	
	@Autowired
private static Blog blog;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		
		blog = (Blog) context.getBean("blog");
		
}
	
	
	
	@Test
	public void addBlogTestCase()
	{	//blog.setBlogId(0);
		blog.setBlogcontent("lslckcnbhryi");
		blog.setBlogname("name");
		blog.setDislikes(98);
		blog.setLikes(9);
		blog.setLoginname("karma");
		blog.setStatus("NA");
		//boolean actual = userDAO.save(user);
		Assert.assertEquals("Add Blog Test Case" , true  , blogDAO.save(blog));
		
	}

	 @Ignore	 
@Test
public void deleteBlogTest()
{
	Blog blog=blogDAO.get(5);
	assertTrue("Problem in Deleting:",blogDAO.delete(blog));
}
	 @Ignore
	@Test
	public void UpdateBlogTest()
	{
		Blog blog=blogDAO.get(4);
		blog.setStatus("A");
		blog.setBlogcontent("Spring handels the infrastructure due to which develoger imphesises on buiseness logic");
		assertTrue("Problem in Updateing:",blogDAO.update(blog));
	}
	 @Ignore
	@Test
	public void getAllBlogs()
	{
		int size = blogDAO.list().size();
		
		Assert.assertEquals(5, size);
	}
	 @Ignore
	@Test
	public void ApproveBlogTest()
	{
		
		assertTrue("Problem in Approving:",blogDAO.approveBlog(6));
	}
	 @Ignore
	 @Test
		public void incLikesTest()
		{
		 assertTrue("Problem in increamentlikes:",blogDAO.incLikes(6));
		}
	 @Ignore
	 @Test
		public void RejectBlogTest()
		{
			
			assertTrue("Problem in Rejrcting:",blogDAO.rejectBlog(6));
		}
	 @Ignore
	 @Test
		public void getAllApprovedBlogs()
		{
			int size = blogDAO.approvedBlogsList().size();
			
			Assert.assertEquals(2, size);
		}
	 
}
