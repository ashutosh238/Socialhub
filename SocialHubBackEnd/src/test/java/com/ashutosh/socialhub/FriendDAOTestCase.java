package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Incubating;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.FriendDAO;
import com.ashutosh.socialhub.domain.Friend;

public class FriendDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static FriendDAO friendDAO;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		friendDAO = (FriendDAO) context.getBean("friendDAO");
		
	}
	
	@Ignore
	@Test
	public void sendFriendRequestTestCase()
	{
		Friend friend=new Friend();
		friend.setLoginname("R V");
		friend.setFriendname("Ashutosh");
		assertTrue("problem in sending a friend request",friendDAO.sendFriendRequest(friend));
	}
	
	@Ignore
	@Test
	public void acceptFriendRequest()
	{
		assertTrue("problem in accepting a friend request",friendDAO.accepctFriendrequest(21));
		
	}
	@Ignore
	@Test
	public void showPendingFriendRequest()
	{
		List<Friend> friends = friendDAO.showPendingFriendRequest("Khushbu");
		boolean flag = friends.isEmpty();
		assertEquals("friend list test case", false, flag);
		for(Friend f:friends)
		{
			System.out.println("Friend Loginname: "+f.getFriendname());
		}
	}
	
	@Ignore
	@Test
	public void deleteFriendRequest()
	{
		assertTrue("problem in deleting a friend request",friendDAO.deleteFriendRequest(22));
		
	}
	
	@Test
	public void showFriendListtestCase()
	{
		List<Friend> friends = friendDAO.showFriendList("Ashutosh");
		boolean flag = friends.isEmpty();
		assertEquals("friend list test case", false, flag);
		for(Friend f:friends)
		{
			System.out.println("Friend Loginname: "+f.getFriendname()+" :FRIENDS: "+f.getLoginname());
		}
	}
	
}