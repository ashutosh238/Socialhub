package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.ForumComment;

public interface ForumCommentDAO {

	
	public boolean save(ForumComment forumcomment);
	public boolean update(ForumComment forumcomment);
	public boolean delete(ForumComment forumcomment);
	public ForumComment get(int id);
	public List<ForumComment> list();

}
