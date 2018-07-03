package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.Forum;

public interface ForumDAO {

	public boolean save(Forum forum);
	public boolean update(Forum forum);
	public boolean delete(Forum forum);
	public Forum get(int id);
	public List<Forum> list();

}
