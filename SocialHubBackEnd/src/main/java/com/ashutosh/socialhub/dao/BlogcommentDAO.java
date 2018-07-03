package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.Blogcomment;



public interface BlogcommentDAO {
	
	public boolean save(Blogcomment blogcomment);
	public boolean update(Blogcomment blogcomment);
	public boolean delete(Blogcomment blogcomment);
	public Blogcomment get(int id);
	public List<Blogcomment> list();
	
}
