package com.ldsg.jwsystem.entity;

public class UserRole {

	private int id;
	private int uid;
	private int rid;
	
	
	public UserRole(int id, int uid, int rid) {
		this.id = id;
		this.uid = uid;
		this.rid = rid;
	}
	
	public UserRole(int uid, int rid) {
		this.uid = uid;
		this.rid = rid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
}
