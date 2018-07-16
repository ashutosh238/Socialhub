package com.ashutosh.socialhub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashutosh.socialhub.dao.SuggestionDAO;
import com.ashutosh.socialhub.domain.Suggestion;

import junit.framework.Assert;

public class MessageTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static SuggestionDAO suggestionDAO;
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.ashutosh");
		context.refresh();
		
		suggestionDAO = (SuggestionDAO) context.getBean("suggestionDAO");
		
	}

	@Ignore
	@Test
	public void addMessage()
	{
		Suggestion suggestion=new Suggestion();
		
		suggestion.setEmailid("x@gmail.com");
		suggestion.setMessage("asadsad");
		suggestion.setName("Ashutosh");
		assertTrue("problem",suggestionDAO.addSuggestion(suggestion));
		
	}
	
	@Test
	public void listSuggestion()
	{
int size = suggestionDAO.list().size();
		
		Assert.assertEquals(5, size);
		
	}
}
