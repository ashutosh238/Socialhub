package com.ashutosh.socialhub.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashutosh.socialhub.dao.FriendDAO;
import com.ashutosh.socialhub.domain.Friend;
import com.ashutosh.socialhub.domain.UserDetail;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO{




		@Autowired
		private SessionFactory sessionFactory;

		public List<Friend> showFriendList(String loginname) 
		{
			return sessionFactory.getCurrentSession().createQuery("from Friend where (loginname='"+loginname+"' AND status='Accepted') OR (friendloginname='"+loginname+"' AND status='Accepted')").list();
			 
		}

		public List<Friend> showPendingFriendRequest(String loginname)
		{
			return sessionFactory.getCurrentSession().createQuery("from Friend where (loginname='"+loginname+"' AND status='Pending')") .list();	 
		}

		

		public boolean sendFriendRequest(Friend friend) 
		{
			try {
				friend.setStatus("Pending");
				sessionFactory.getCurrentSession().save(friend);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
	}	 
		}

		public boolean accepctFriendrequest(int friendId)
		{
			try {
				Friend friend = sessionFactory.getCurrentSession().get(Friend.class, friendId);
				friend.setStatus("Accepted");
				sessionFactory.getCurrentSession().update(friend);
				return true;
			} catch (HibernateException e) {
				
				e.printStackTrace();
				return false;
	}	 
		}

		public boolean deleteFriendRequest(int friendId) 
		{
			try {
				Friend friend = sessionFactory.getCurrentSession().get(Friend.class, friendId);
				sessionFactory.getCurrentSession().delete(friend);
				return true;
			} catch (HibernateException e) {
				
				e.printStackTrace();
				return false;
			}	 
		}

		public List<UserDetail> showSuggestedFriend(String loginname) {
			return null;
			

		}

		public Friend getFriend(int friendid) {
			return sessionFactory.getCurrentSession().get(Friend.class, friendid);
		}
		
}	
