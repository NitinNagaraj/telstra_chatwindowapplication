package com.hcl.telstraDemo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.telstraDemo.dto.GroupDTO;
import com.hcl.telstraDemo.dto.RegistryDTO;
import com.hcl.telstraDemo.entity.GroupEntity;
import com.hcl.telstraDemo.repository.GroupRepository;
import com.hcl.telstraDemo.service.GroupService;

@Component
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	public GroupRepository groupRepository;
	
	@Override
	@Transactional
	public GroupEntity createGroup(GroupDTO groupDTO) {
		GroupEntity groupEntity = new GroupEntity();
		groupEntity.setGroupName(groupDTO.getGroupName());
		groupEntity.setActiveStatus(true);
		groupEntity.setCreatedById(groupDTO.getCreatedById());
		return groupRepository.save(groupEntity);
		
		 
	}

	@Override
	@Transactional
	public GroupEntity addCreatingUserToTheGroup(GroupDTO groupDTO, RegistryDTO registryDTO) {
		
		
		return null;
	}
	
	
}
