package com.ashutosh.socialhub.restrcontroller;

import java.util.Date;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.socialhub.domain.Message;
import com.ashutosh.socialhub.domain.OutputMessage;

@RestController
public class ChatRestController 
{
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message)
	{
		return new OutputMessage(message,new Date());
	}
}