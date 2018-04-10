package com.hcl.telstraDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.telstraDemo.dto.RegistryDTO;
import com.hcl.telstraDemo.entity.Registry;
import com.hcl.telstraDemo.repository.RegistryRepository;
import com.hcl.telstraDemo.service.RegistryService;

@Component
public class RegistryServiceImpl implements RegistryService {

	@Autowired
	public RegistryRepository repository;

	@Override
	@Transactional
	public String saveRegisteredUsers(RegistryDTO dto) {
		Registry registry = new Registry();
		registry.setActive(dto.isActive());
		registry.setDisplayName(dto.getDisplayName());
		registry.setEmail(dto.getEmail());
		registry.setLoginName(dto.getLoginName());
		registry.setPassword(dto.getPassword());
		registry.setPhoneNumber(dto.getPhoneNumber());

		repository.save(registry);

		return "success";
	}

	@Override
	@Transactional
	public Registry loginRegistredUser(RegistryDTO dto) {

		String userName = dto.getLoginName();
		String password = dto.getPassword();

		repository.findByName(userName, password);

		Registry registry = new Registry();
		// registry = repository.getUserIdFromUserName(userName, password);
		registry = getUserDetailsFromUserName(dto);
		return registry;
	}

	@Override
	public Registry getUserDetailsFromUserName(RegistryDTO registryDTO) {
		String userName = registryDTO.getLoginName();
		String password = registryDTO.getPassword();

		Registry registry = new Registry();
		registry = repository.getUserIdFromUserName(userName, password);

		return registry;
	}

	@Transactional
	@Override
	public List<Registry> getAllRegisteredUsers() {

		return repository.findAll();
	}

	@Transactional
	@Override
	public List<Registry> getRegisteredUserByName(String loginName) {

		return repository.findByRegisteredUserName(loginName);
	}

}
