package com.hcl.telstraDemo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chatdetails")
public class ChatDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chatid")
	private int chatId;

	@Column(name = "senderid", nullable = false)
	private int senderId;

	@Column(name = "receiveruid", nullable = false)
	private int receiverId;

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "createdon", nullable = false)
	private Date createdOn;

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
