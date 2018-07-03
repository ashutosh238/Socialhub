package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.Friend;
import com.ashutosh.socialhub.domain.UserDetail;

public interface FriendDAO {
	
	
	public List<Friend> showFriendList(String loginname);
	public List<Friend> showPendingFriendRequest(String loginname);
	public List<UserDetail> showSuggestedFriend(String loginname);
	public boolean sendFriendRequest(Friend friend);
	public boolean accepctFriendrequest(int friendId);
	public boolean deleteFriendRequest(int friendId);

}
