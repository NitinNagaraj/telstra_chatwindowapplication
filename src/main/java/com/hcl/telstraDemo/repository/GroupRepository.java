package com.hcl.telstraDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.telstraDemo.dto.GroupDTO;
import com.hcl.telstraDemo.entity.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer>{
	
	/*@Query("INSERT INTO group VALUES (?,?,?,?)")
	public Group saveGroup(int id, String name, boolean isActive, int createdById);*/
	
	public GroupEntity save(GroupEntity groupEntity);
	
}
