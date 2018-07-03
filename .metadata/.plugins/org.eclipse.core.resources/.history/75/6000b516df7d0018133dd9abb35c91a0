package com.ashutosh.socialhub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.UserDAO;
import com.ashutosh.socialhub.domain.Blog;
import com.ashutosh.socialhub.domain.UserDetail;

import junit.framework.Assert;

public class UserDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	static UserDAO userDAO;
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
		
		
	}
	@Ignore
	@Test
	public void registerUserTestCase()
	{
		UserDetail userdetail=new UserDetail();
		userdetail.setLoginname("Sunita");
		userdetail.setAddress("noida sector 48");
		userdetail.setEmailId("sunita@gmail.com");
		userdetail.setPassword("sunita@123");
		userdetail.setUsername("Sunita Sharma");
		userdetail.setMobile(735109876);
		userdetail.setRoles("ROLE_USER");
		assertTrue("problem",userDAO.registerUser(userdetail));
	}
	@Ignore
	@Test
	public void UpdateUserDetailTest()
	{
		UserDetail userdetail=userDAO.getUser("Ashutosh");
		userdetail.setMobile(9012234);
		assertTrue("Problem in Updateing:",userDAO.updatUser(userdetail));
	}
	
	@Test 
	public void checkLoginCase()
	{
		UserDetail userdetail=new UserDetail();
		userdetail.setLoginname("Ashutosh");
		userdetail.setPassword("ashutosh@123");
		UserDetail userDetail1=userDAO.checkUser(userdetail);
		assertNotNull("problem in login",userDetail1);
		System.out.println("UserName :"+userDetail1.getUsername());
		}
	
	
}
