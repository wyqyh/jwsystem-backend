package com.ldsg.jwsystem.vo;

import java.util.List;

import com.ldsg.jwsystem.entity.User;

public class CourseVo {

	private int id;
	private int classid;
	private int classno;
	private int termid;
	private int trainlevelid;
	private String coursename;
	private int majorid;
	private int stunum;
	private int deptid;
	private int tasktypeid;
	private int practicetype;
	private int theroyhour;
	private int practicehour;
	private int prime;
	private String batchcoeff;
	private String teacherid;
	private List<User> teacIdNames;
	private String createTime;
	
	public CourseVo(int id, int classid, int classno, int termid, int trainlevelid, String coursename, int majorid, int stunum,
			int deptid, int tasktypeid, int practicetype, int theroyhour, int practicehour, int prime, String batchcoeff,
			String teacherid, String createTime) {
		this.id = id;
		this.classid = classid;
		this.classno = classno;
		this.termid = termid;
		this.trainlevelid = trainlevelid;
		this.coursename = coursename;
		this.majorid = majorid;
		this.stunum = stunum;
		this.deptid = deptid;
		this.tasktypeid = tasktypeid;
		this.practicetype = practicetype;
		this.theroyhour = theroyhour;
		this.practicehour = practicehour;
		this.prime = prime;
		this.batchcoeff = batchcoeff;
		this.teacherid = teacherid;
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
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	public int getTermid() {
		return termid;
	}
	public void setTermid(int termid) {
		this.termid = termid;
	}
	public int getTrainlevelid() {
		return trainlevelid;
	}
	public void setTrainlevelid(int trainlevelid) {
		this.trainlevelid = trainlevelid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public int getStunum() {
		return stunum;
	}
	public void setStunum(int stunum) {
		this.stunum = stunum;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public int getTasktypeid() {
		return tasktypeid;
	}
	public void setTasktypeid(int tasktypeid) {
		this.tasktypeid = tasktypeid;
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
	public List<User> getTeacIdNames() {
		return teacIdNames;
	}

	public void setTeacIdNames(List<User> teacIdNames) {
		this.teacIdNames = teacIdNames;
	}

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
