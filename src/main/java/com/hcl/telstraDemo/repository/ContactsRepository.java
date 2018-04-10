package com.hcl.telstraDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.telstraDemo.entity.Contacts;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

	@Query(value = "SELECT uid from Contacts id where id.addedby=?1",nativeQuery= true)
	public List<Integer> findUidByLogginId(int addedby);
	
	@Query(value = "UPDATE contacts c set c.gid=?2 where c.uid=?1",nativeQuery= true)
	public String addLoggedInUserToGroup(int loggedInUserId, int groupId);
	
	@Query(value="select gid from contacts c where c.uid = ?1",nativeQuery = true)
	public List<Integer> getAllGroupsForLoggedInUserId(int loggedInUserId);
}
