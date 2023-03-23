package com.ldsg.jwsystem.response;

import java.util.List;

public class UserResponse {

	private int id;
	private String name;
	private String account;
	private int deptid;
	private String contact;
	private List<Integer> roleIds;
	private String level2dept;
	private String avatar;
	private int usertype;
	private String sex;
	private String phone;
	private String createTime;
	
	public UserResponse(int id, String name, String account, int deptid, String contact, 
			String avatar, int usertype, String sex, String phone, String createTime) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.deptid = deptid;
		this.contact = contact;
		this.avatar = avatar;
		this.usertype = usertype;
		this.sex = sex;
		this.phone = phone;
		this.createTime = createTime;
	}

	public UserResponse(int id, String name, String account, int deptid, String contact, String level2dept, 
			String avatar, int usertype, String sex, String phone, String createTime) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.deptid = deptid;
		this.contact = contact;
		this.level2dept = level2dept;
		this.avatar = avatar;
		this.usertype = usertype;
		this.sex = sex;
		this.phone = phone;
		this.createTime = createTime;
	}
	
	public UserResponse(int id, String name, String level2dept) {
		this.id = id;
		this.name = name;
		this.level2dept = level2dept;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public String getLevel2dept() {
		return level2dept;
	}

	public void setLevel2dept(String level2dept) {
		this.level2dept = level2dept;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
