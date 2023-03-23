package com.ldsg.jwsystem.entity;

public class Student {

	private int id;
	private int classid;
	private String stuno;
	private String stuname;
	private String sex;
	private String origin;
	private String tel;
	private String idcard;
	private String address;
	private String political;
	private String createTime;
	
	public Student() {
		
	}

	public Student(int id, int classid, String stuno, String stuname, String sex, String origin, String tel, String idcard,
			String address, String political, String createTime) {
		this.id = id;
		this.classid = classid;
		this.stuno = stuno;
		this.stuname = stuname;
		this.sex = sex;
		this.origin = origin;
		this.tel = tel;
		this.idcard = idcard;
		this.address = address;
		this.political = political;
		this.createTime = createTime;
	}
	
	public Student(int id, int classid, String stuno, String stuname, String sex, String origin, String tel, String idcard,
			String address, String political) {
		this.id = id;
		this.classid = classid;
		this.stuno = stuno;
		this.stuname = stuname;
		this.sex = sex;
		this.origin = origin;
		this.tel = tel;
		this.idcard = idcard;
		this.address = address;
		this.political = political;
	}
	
	
	public Student(int classid, String stuno, String stuname, String sex, String origin, String tel, String idcard, String address,
			String political, String createTime) {
		this.classid = classid;
		this.stuno = stuno;
		this.stuname = stuname;
		this.sex = sex;
		this.origin = origin;
		this.tel = tel;
		this.idcard = idcard;
		this.address = address;
		this.political = political;
		this.createTime = createTime;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
