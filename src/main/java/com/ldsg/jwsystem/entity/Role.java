package com.ldsg.jwsystem.entity;

public class Role {

	private int id;
	private String name;
	private String key;
	private int sort;
	private String status;
	private boolean admin;
	private String remark;
	private String create_time;
	
	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Role(String name) {
		this.name = name;
	}

	public Role(int id, String name, String key, int sort, String status, boolean admin, String remark, String create_time) {
		this.id = id;
		this.name = name;
		this.key = key;
		this.sort = sort;
		this.status = status;
		this.admin = admin;
		this.remark = remark;
		this.create_time = create_time;
	}
	
	public Role(String name, String key, int sort, String status, boolean admin, String remark, String create_time) {
		this.name = name;
		this.key = key;
		this.sort = sort;
		this.status = status;
		this.admin = admin;
		this.remark = remark;
		this.create_time = create_time;
	}
	
	public Role(String name, String key, int sort, String status, boolean admin, String remark) {
		this.name = name;
		this.key = key;
		this.sort = sort;
		this.status = status;
		this.admin = admin;
		this.remark = remark;
	}
	
	public Role(int id, String name, String key, int sort, String status, String remark) {
		this.id = id;
		this.name = name;
		this.key = key;
		this.sort = sort;
		this.status = status;
		this.remark = remark;
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

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
