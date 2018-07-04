package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.Blogcomment;



public interface BlogcommentDAO {
	
	public boolean addComment(Blogcomment blogcomment);
	public boolean deleteComment(Blogcomment blogcomment);
	public List<Blogcomment> getAllComments(int blogId);
	
}
