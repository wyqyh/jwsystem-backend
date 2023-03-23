package com.ldsg.jwsystem.entity;

public class RolePermission {

	private int id;
	private int rid;
	private int perid;
	
	
	public RolePermission(int rid, int perid) {
		this.rid = rid;
		this.perid = perid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
}
