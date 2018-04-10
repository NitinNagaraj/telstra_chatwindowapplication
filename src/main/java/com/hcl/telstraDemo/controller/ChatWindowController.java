package com.hcl.telstraDemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.telstraDemo.dto.ChatDetailsDTO;
import com.hcl.telstraDemo.dto.ContactsDTO;
import com.hcl.telstraDemo.dto.GroupDTO;
import com.hcl.telstraDemo.dto.RegistryDTO;
import com.hcl.telstraDemo.entity.ChatDetails;
import com.hcl.telstraDemo.entity.Contacts;
import com.hcl.telstraDemo.entity.GroupEntity;
import com.hcl.telstraDemo.entity.Registry;
import com.hcl.telstraDemo.repository.ContactsRepository;
import com.hcl.telstraDemo.service.ContactsService;
import com.hcl.telstraDemo.service.GroupService;
import com.hcl.telstraDemo.service.MessageService;
import com.hcl.telstraDemo.service.RegistryService;

@RestController
@RequestMapping("/api")
public class ChatWindowController {

	@Autowired
	public RegistryService registryService;

	@Autowired
	public GroupService groupService;

	@Autowired
	public ContactsService contactsService;
	
	@Autowired
	public ContactsRepository contactsRepository;
	
	@Autowired
	public MessageService messageService;

	// Save Users to registry table
	@CrossOrigin
	@ResponseStatus(value = HttpStatus.OK, reason = "success")
	@RequestMapping(value = "/saveRegisteredUser", method = RequestMethod.POST)
	public String saveRegisteredUser(@RequestBody RegistryDTO registrationData) {

		registrationData.setActive(true);
		registryService.saveRegisteredUsers(registrationData);
		return "success";
	}

	// Login with the registered user
	@CrossOrigin
	// @ResponseStatus(value=HttpStatus.OK,reason="success")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginWithRegisteredUser(@RequestBody RegistryDTO registryDTO) {
		Registry registry = registryService.loginRegistredUser(registryDTO);

		RegistryDTO dto = new RegistryDTO();
		dto.setDisplayName(registry.getDisplayName());
		dto.setEmail(registry.getEmail());
		dto.setLoginName(registry.getLoginName());
		dto.setPhoneNumber(registry.getPhoneNumber());
		dto.setActive(registry.isActive());
		dto.setHttpStatus(HttpStatus.OK.value());
		dto.setMessage("success");
		dto.setUid(registry.getUid());
		return new ResponseEntity<RegistryDTO>(dto, HttpStatus.OK);
	}

	// Create a group
	@CrossOrigin
	@RequestMapping(value = "/createGroup", method = RequestMethod.POST)
	public ResponseEntity<?> createGroup(@RequestBody GroupDTO groupDTO, @RequestBody RegistryDTO registryDTO) {
		int groupId;
		int loggedInUserId;
		GroupEntity groupEntity = groupService.createGroup(groupDTO);
		if (groupEntity != null) {
			groupId = groupEntity.getGroupid();
			loggedInUserId = registryDTO.getUid();
			contactsService.addLoggedInUserToGroup(loggedInUserId, groupId);
		}
		GroupDTO dto = new GroupDTO();
		dto.setGroupName(groupEntity.getGroupName());
		dto.setActiveStatus(groupEntity.isActiveStatus());
		dto.setGid(groupEntity.getGroupid());
		dto.setCreatedById(groupEntity.getCreatedById());
		dto.setMessage("success");
		dto.setHttpStatus(HttpStatus.OK.value());
		return new ResponseEntity<GroupDTO>(dto, HttpStatus.OK);

	}

	@CrossOrigin
	@RequestMapping(value = "/addUsersToGroup", method = RequestMethod.POST)
	public ResponseEntity<?> addUsersToGroup() {

		return new ResponseEntity<GroupEntity>(HttpStatus.OK);
	}

	// get groups for the logged in user
	@CrossOrigin
	@RequestMapping(value = "/getGroupsList/{id}", method = RequestMethod.GET)
	public List<Integer> getGroupsList(@PathVariable(value = "id") int id) {

		List<Integer> groupIds = contactsService.getAllGroupsForLoggedInUserId(id);
		GroupDTO dto = new GroupDTO();

		return groupIds;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/getRegisteredUser", method = RequestMethod.GET)
	public List<Registry> getRegisteredUserByName(@RequestParam("searchUser")  String loginName) {
		
		return registryService.getRegisteredUserByName(loginName);
	}

	@CrossOrigin
	@RequestMapping(value = "/getRegisteredUsers", method = RequestMethod.GET)
	public List<Registry> getRegisteredUsers() {
		
		return registryService.getAllRegisteredUsers();

	}

	@CrossOrigin
	@RequestMapping(value = "/saveChat", method = RequestMethod.POST)
	public String sendChat(@RequestBody ChatDetailsDTO chatDetailsDTO) {
		
		ChatDetails chatDetail = new ChatDetails();
		
		chatDetail.setCreatedOn(chatDetailsDTO.getCreatedOn());
		chatDetail.setMessage(chatDetailsDTO.getMessage());
		chatDetail.setReceiverId(chatDetailsDTO.getReceiverId());
		chatDetail.setSenderId(chatDetailsDTO.getSenderId());
		return messageService.sendIndividualChat(chatDetail);

	}
	
	@CrossOrigin
	@RequestMapping(value = "/receiveChat", method = RequestMethod.GET)
	public List<ChatDetails> recieveChat(@RequestParam("senderId")  int senderId, @RequestParam("receiverId") int receiverId) {
		
		return messageService.receiveIndividualChat(senderId,receiverId);

	}
	
	/*@CrossOrigin
	@RequestMapping(value = "/createGroup", method = RequestMethod.POST)
	public ResponseEntity<?> createGroup(@RequestBody GroupDTO groupDTO, @RequestBody RegistryDTO registryDTO) {
		int groupId;
		int loggedInUserId;
		GroupEntity groupEntity = groupService.createGroup(groupDTO);
		if (groupEntity != null) {
			groupId = groupEntity.getGroupid();
			loggedInUserId = registryDTO.getUid();
			contactsService.addLoggedInUserToGroup(loggedInUserId, groupId);
		}
		GroupDTO dto = new GroupDTO();
		dto.setGroupName(groupEntity.getGroupName());
		dto.setActiveStatus(groupEntity.isActiveStatus());
		dto.setGid(groupEntity.getGroupid());
		dto.setCreatedById(groupEntity.getCreatedById());
		dto.setMessage("success");
		dto.setHttpStatus(HttpStatus.OK.value());
		return new ResponseEntity<GroupDTO>(dto, HttpStatus.OK);

	}*/
	
	@CrossOrigin
	@RequestMapping(value = "/addContacts")
	public ResponseEntity<?> addContacts(@RequestBody ContactsDTO contactDTO, @RequestBody RegistryDTO registryDTO){
		
		int contactId;
		int registrationId;
		
				return null;
		
	}
	}
