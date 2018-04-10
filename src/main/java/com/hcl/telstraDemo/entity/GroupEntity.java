package com.hcl.telstraDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groupentity")
public class GroupEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupid;
	
	@Column(name="groupname", nullable=false)
	private String groupName;
	
	@Column(name="createdbyid", nullable=false)
	private int createdById;
	
	@Column(name="activestatus", nullable=false)
	private boolean activeStatus;

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getCreatedById() {
		return createdById;
	}

	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	

}
