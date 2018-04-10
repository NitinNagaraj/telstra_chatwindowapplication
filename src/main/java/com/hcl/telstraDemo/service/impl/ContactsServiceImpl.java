package com.hcl.telstraDemo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.telstraDemo.dto.ContactsDTO;
import com.hcl.telstraDemo.entity.Contacts;
import com.hcl.telstraDemo.repository.ContactsRepository;
import com.hcl.telstraDemo.service.ContactsService;

@Component
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	public ContactsRepository contactsRepository;
	
	

	@Override
	@Transactional
	public String saveAddContactsUsers(ContactsDTO dto) {

		Contacts contacts = new Contacts();
		contacts.setUid(dto.getUid());
		contacts.setGid(dto.getGid());
		contacts.setAddedby(dto.getAddedby());
		contactsRepository.save(contacts);
		return "SUCCESS";
	}



	@Override
	@Transactional
	public String addLoggedInUserToGroup(int loggedInUserId, int groupId) {
		
		contactsRepository.addLoggedInUserToGroup(loggedInUserId, groupId);
		return "success";
	}



	@Override
	public List<Integer> getAllGroupsForLoggedInUserId(int loggedInUserId) {
		
		List<Integer> groupIds = contactsRepository.getAllGroupsForLoggedInUserId(loggedInUserId);
		return groupIds;
	}

}
