package com.hcl.telstraDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.telstraDemo.dto.RegistryDTO;
import com.hcl.telstraDemo.entity.Registry;
import com.hcl.telstraDemo.repository.RegistryRepository;

@Service
public interface RegistryService {

	public String saveRegisteredUsers(RegistryDTO dto);
	
	public Registry loginRegistredUser(RegistryDTO dto);
	
	public Registry getUserDetailsFromUserName(RegistryDTO registry);

	public List<Registry> getRegisteredUserByName(String loginName);

	public List<Registry> getAllRegisteredUsers();
	
	
}
