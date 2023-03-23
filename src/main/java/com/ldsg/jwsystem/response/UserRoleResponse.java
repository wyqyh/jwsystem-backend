package com.ldsg.jwsystem.response;

public class UserRoleResponse {

	private int id;
	private int uid;
	private int rid;
	private String rname;
	private String key;
	private int sort;
	private String create_time;
	
	public UserRoleResponse(int id, int uid, int rid, String rname, String key, int sort, String create_time) {
		this.id = id;
		this.uid = uid;
		this.rid = rid;
		this.rname = rname;
		this.key = key;
		this.sort = sort;
		this.create_time = create_time;
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

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
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

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}
