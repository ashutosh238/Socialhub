package com.ashutosh.socialhub.restrcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.socialhub.dao.FriendDAO;
import com.ashutosh.socialhub.dao.UserDAO;
import com.ashutosh.socialhub.domain.Blog;
import com.ashutosh.socialhub.domain.Friend;
import com.ashutosh.socialhub.domain.UserDetail;



@RestController
public class FriendRestController 
{
	@Autowired
	HttpSession session;
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private Friend friend;
	
	@Autowired
	private UserDAO userDAO;
	
	
	@RequestMapping("friend/list")
	public ResponseEntity<List<Friend>> showFriendList()
	{
		String loginname = (String) session.getAttribute("loginname");
		List<Friend> friends = friendDAO.showFriendList(loginname);
		
		if(friends.isEmpty())
		{
			Friend friend = new Friend();
			friend.setStatus("No Friends Yet !!!");
			friends.add(friend);
			return new ResponseEntity<List<Friend>>(friends, HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
		}
	}
	
}