package com.ldsg.jwsystem.entity;

public class Course {

	private int id;
	private int classid;
	private String coursename;
	private int practicetype;
	private int theroyhour;
	private int practicehour;
	private int prime;
	private String batchcoeff;
	private String teacherid;
	private String createTime;
	
	public Course(int id, int classid, String coursename, int practicetype, int theroyhour, int practicehour, int prime,
			String batchcoeff, String teacherid, String createTime) {
		this.id = id;
		this.classid = classid;
		this.coursename = coursename;
		this.practicetype = practicetype;
		this.theroyhour = theroyhour;
		this.practicehour = practicehour;
		this.prime = prime;
		this.batchcoeff = batchcoeff;
		this.teacherid = teacherid;
		this.createTime = createTime;
	}
	
	public Course(int classid, String coursename, int practicetype, int theroyhour, int practicehour, int prime,
			String batchcoeff, String teacherid, String createTime) {
		this.classid = classid;
		this.coursename = coursename;
		this.practicetype = practicetype;
		this.theroyhour = theroyhour;
		this.practicehour = practicehour;
		this.prime = prime;
		this.batchcoeff = batchcoeff;
		this.teacherid = teacherid;
		this.createTime = createTime;
	}
	
	public Course(int classid, String coursename, int practicetype, int theroyhour, int practicehour, int prime,
			String batchcoeff, String teacherid) {
		this.classid = classid;
		this.coursename = coursename;
		this.practicetype = practicetype;
		this.theroyhour = theroyhour;
		this.practicehour = practicehour;
		this.prime = prime;
		this.batchcoeff = batchcoeff;
		this.teacherid = teacherid;
	}
	
	public Course(int id, int classid, String coursename) {
		this.id = id;
		this.classid = classid;
		this.coursename = coursename;
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
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getPracticetype() {
		return practicetype;
	}
	public void setPracticetype(int practicetype) {
		this.practicetype = practicetype;
	}
	public int getTheroyhour() {
		return theroyhour;
	}
	public void setTheroyhour(int theroyhour) {
		this.theroyhour = theroyhour;
	}
	public int getPracticehour() {
		return practicehour;
	}
	public void setPracticehour(int practicehour) {
		this.practicehour = practicehour;
	}
	public int getPrime() {
		return prime;
	}
	public void setPrime(int prime) {
		this.prime = prime;
	}
	public String getBatchcoeff() {
		return batchcoeff;
	}
	public void setBatchcoeff(String batchcoeff) {
		this.batchcoeff = batchcoeff;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
