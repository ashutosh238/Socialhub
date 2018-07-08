package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.Forum;

public interface ForumDAO {

	public boolean saveForum(Forum forum);
	public boolean deleteforum(int forumid);
	public Forum getForum(int forumid);
	public boolean approveForum(int forumid);
	public boolean rejectForum(int forumid);
	public List<Forum> approvedForumsList();
	public List<Forum> forumList();
	
}
