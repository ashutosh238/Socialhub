package com.ashutosh.socialhub.dao.impl;

import java.sql.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashutosh.socialhub.dao.SuggestionDAO;
import com.ashutosh.socialhub.domain.Suggestion;

@Repository("suggestionDAO")
@Transactional
public class SuggestionDAOImpl implements SuggestionDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public boolean addSuggestion(Suggestion suggestion) {
		try {
			 
			suggestion.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(suggestion);
		}
		catch (Exception e) {
			// print the complete exception stack trace
			e.printStackTrace();
			return false;
		}
		return true;
}

}
