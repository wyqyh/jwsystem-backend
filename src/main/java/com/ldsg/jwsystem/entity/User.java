package com.ldsg.jwsystem.entity;

public class User {

	private int id;
	private String name;
	private String account;
	private String password;
	private int deptid;
	private String contact;
	private String avatar;
	private int usertype;
	private String sex;
	private String phone;
	private String createTime;
	
	public User(int id, String name, String account, String password, int deptid, String contact, String avatar, 
			int usertype, String sex, String phone, String createTime) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.deptid = deptid;
		this.contact = contact;
		this.avatar = avatar;
		this.usertype = usertype;
		this.sex = sex;
		this.phone = phone;
		this.createTime = createTime;
	}

	public User(String name, String account, String password, int deptid, String contact, String avatar, 
			int usertype, String sex, String phone) {
		this.name = name;
		this.account = account;
		this.password = password;
		this.deptid = deptid;
		this.contact = contact;
		this.avatar = avatar;
		this.usertype = usertype;
		this.sex = sex;
		this.phone = phone;
	}

	/**
	 * id, name, account, deptid, contact, avatar, usertype, sex, phone
	 * @param id
	 * @param name
	 * @param account
	 * @param deptid
	 * @param contact
	 * @param avatar
	 * @param usertype
	 * @param sex
	 * @param phone
	 */
	public User(int id, String name, String account, int deptid, String contact, String avatar, int usertype,
			String sex, String phone, String createTime) {
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
	
	public User(int id, String name) {
		this.id = id;
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
