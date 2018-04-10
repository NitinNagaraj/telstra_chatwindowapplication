package com.hcl.telstraDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.telstraDemo.entity.ChatDetails;

@Repository
public interface MessageRepository extends JpaRepository<ChatDetails,Integer> {
	@Query(value = "select * from chatdetails c where c.senderid = ?1 and c.receiveruid = ?2 ", nativeQuery = true)
		List<ChatDetails> findChatMessageById(int senderId, int receiverId);
}
