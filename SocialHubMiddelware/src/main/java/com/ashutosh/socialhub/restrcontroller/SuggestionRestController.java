package com.ashutosh.socialhub.restrcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.socialhub.dao.SuggestionDAO;
import com.ashutosh.socialhub.domain.Suggestion;

@RestController
public class SuggestionRestController {
	@Autowired
	private static SuggestionDAO suggestionDAO;
	
	@PostMapping("/addSuggestion")
	public ResponseEntity<String> AddSuggestion(@RequestBody Suggestion suggestion)
	{
		Suggestion s=new Suggestion();
		s.setEmailid(suggestion.getEmailid());
		s.setMessage(suggestion.getMessage());
		s.setName(suggestion.getName());
		if(suggestionDAO.addSuggestion(s))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Faliure",HttpStatus.NOT_FOUND);
		}
	}


}
