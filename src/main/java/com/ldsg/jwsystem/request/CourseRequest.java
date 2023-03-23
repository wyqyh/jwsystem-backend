package com.ldsg.jwsystem.request;

import java.util.List;

public class CourseRequest {
	
	private int id;
	private int uid;
	private int classid;
	private String coursename;
	private List<String> teacherids;
	private int practicetype;
	private int prime;
	private int theroyhour;
	private int practicehour;
	private String batchcoeff;
	
	public CourseRequest(int uid, int classid, String coursename, List<String> teacherids, int practicetype, int prime,
			int theroyhour, int practicehour, String batchcoeff) {
		super();
		this.uid = uid;
		this.classid = classid;
		this.coursename = coursename;
		this.teacherids = teacherids;
		this.practicetype = practicetype;
		this.prime = prime;
		this.theroyhour = theroyhour;
		this.practicehour = practicehour;
		this.batchcoeff = batchcoeff;
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
	public List<String> getTeacherids() {
		return teacherids;
	}
	public void setTeacherids(List<String> teacherids) {
		this.teacherids = teacherids;
	}
	public int getPracticetype() {
		return practicetype;
	}
	public void setPracticetype(int practicetype) {
		this.practicetype = practicetype;
	}
	public int getPrime() {
		return prime;
	}
	public void setPrime(int prime) {
		this.prime = prime;
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
	public String getBatchcoeff() {
		return batchcoeff;
	}
	public void setBatchcoeff(String batchcoeff) {
		this.batchcoeff = batchcoeff;
	}
}
