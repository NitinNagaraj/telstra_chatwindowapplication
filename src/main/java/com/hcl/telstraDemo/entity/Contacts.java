package com.hcl.telstraDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="Contacts.findById", query="SELECT c FROM Contacts c where c.pid = ?1 AND c.uid = ?2")
@Table(name = "Contacts")
public class Contacts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(name = "uid", nullable = false)
	private int uid;
	@Column(name = "gid", nullable = false)
	private int gid;
	@Column(name = "addedby", nullable = false)
	private int addedby;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getAddedby() {
		return addedby;
	}

	public void setAddedby(int addedby) {
		this.addedby = addedby;
	}
}

