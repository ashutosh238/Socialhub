package com.ashutosh.socialhub.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class ForumComment {
	@Id
	@GeneratedValue(generator="comment_seq")
	@SequenceGenerator(name="comment_seq",sequenceName="COMMENT_SEQ", allocationSize=1)
	private int commentid;
	private int forumid;
	private String discussiontext;
	private String loginname;
	private Date discussionDate;
	public int getCommemtid() {
		return commentid;
	}
	public void setCommemtid(int commentid) {
		this.commentid = commentid;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getDiscussiontxt() {
		return discussiontext;
	}
	public void setDiscussiontxt(String discussiontext) {
		this.discussiontext = discussiontext;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Date getDiscussionDate() {
		return discussionDate;
	}
	public void setDiscussionDate(Date discussionDate) {
		this.discussionDate = discussionDate;
	}
	

}
