package com.hcl.telstraDemo.service;

import org.springframework.stereotype.Service;

import com.hcl.telstraDemo.dto.GroupDTO;
import com.hcl.telstraDemo.dto.RegistryDTO;
import com.hcl.telstraDemo.entity.GroupEntity;

@Service
public interface GroupService {

	public GroupEntity createGroup(GroupDTO groupDTO);
	
	public GroupEntity addCreatingUserToTheGroup(GroupDTO groupDTO, RegistryDTO registryDTO);
}
