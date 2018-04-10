package com.hcl.telstraDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.telstraDemo.entity.ChatDetails;
import com.hcl.telstraDemo.repository.MessageRepository;
import com.hcl.telstraDemo.service.MessageService;

@Component
public class MessageServiceImpl implements MessageService{
	@Autowired
	public MessageRepository messageRepo;
	
//	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	@Transactional
	@Override
	public String sendIndividualChat(ChatDetails chatDetails) {
		messageRepo.save(chatDetails);
		return "Success";
	}

	@Transactional
	@Override
	public List<ChatDetails> receiveIndividualChat(int senderId, int receiverId) {
		
		
		return messageRepo.findChatMessageById(senderId,receiverId);
	}

}
