package com.hcl.telstraDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.telstraDemo.dto.ContactsDTO;
import com.hcl.telstraDemo.entity.Contacts;

@Service
public interface ContactsService {

	public String saveAddContactsUsers(ContactsDTO dto);

	/*
	 * public Contacts loginRegistredUser(ContactsDTO dto);
	 * 
	 * public Registry getUserDetailsFromUserName(RegistryDTO registry);
	 */
	
	
	public String addLoggedInUserToGroup(int loggedInUserId, int groupId);
	
	public List<Integer> getAllGroupsForLoggedInUserId(int loggedInUserId);
}
