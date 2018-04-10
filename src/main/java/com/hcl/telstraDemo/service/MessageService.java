package com.hcl.telstraDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.telstraDemo.entity.ChatDetails;

@Service
public interface MessageService {
	
	public String sendIndividualChat(ChatDetails chatDetails);
	
	public List<ChatDetails> receiveIndividualChat(int senderId, int receiverId);
	

}
