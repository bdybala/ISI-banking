package isi.project.banking.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import isi.project.banking.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {

	
	@RequestMapping(value = "/contact")
	public String openChat(Locale locale, Model model, HttpSession session) {
		
		return "/chat/chat";
	}
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public MessageDto send(MessageDto messageDto) {
		log.info("Something!: " + messageDto);
		return messageDto;
	}
}
