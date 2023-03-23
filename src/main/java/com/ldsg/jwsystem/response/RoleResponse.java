package com.ldsg.jwsystem.response;

public class RoleResponse {

	private int id;
	private String name;
	private String key;
	private int sort;
	private String status;
	private String remark;
	
	
	public RoleResponse(int id, String name, String key, int sort, String status, String remark) {
		this.id = id;
		this.name = name;
		this.key = key;
		this.sort = sort;
		this.status = status;
		this.remark = remark;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}


	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
