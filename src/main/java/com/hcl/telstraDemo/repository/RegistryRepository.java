package com.hcl.telstraDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.telstraDemo.dto.RegistryDTO;
import com.hcl.telstraDemo.entity.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry,Integer>{
	
	@Query(value="select * from registry r where r.loginname = ?1 and r.password = ?2 and r.activestatus = 1", nativeQuery= true)
	public Registry findByName(String loginName, String password);
	
	
	@Query(value="select uid from registry r where r.loginname = ?1 and r.password = ?2 and r.activestatus = 1", nativeQuery= true)
	public Registry getUserIdFromUserName(String loginName, String password);
	
	@Query(value = "select * from registry r where r.loginname like %?1% ", nativeQuery = true)
	List<Registry> findByRegisteredUserName(String userName);

	@Query(value = "select * from registry r ", nativeQuery = true)
	List<Registry> findAll();

}
