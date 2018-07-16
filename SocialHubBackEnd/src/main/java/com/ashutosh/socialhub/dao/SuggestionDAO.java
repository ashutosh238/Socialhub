package com.ashutosh.socialhub.dao;

import java.util.List;

import com.ashutosh.socialhub.domain.Suggestion;

public interface SuggestionDAO {
	
	public boolean addSuggestion(Suggestion suggestion);
	public List<Suggestion> list();

}
