package com.ldsg.jwsystem.request;

public class ClassRequest {

	private int id;
	private String classno;
	private int stunum;
	private int termid;
	private int deptid;
	private int majorid;
	private int trainlevelid;
	private int tasktypeid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public int getStunum() {
		return stunum;
	}
	public int getTermid() {
		return termid;
	}
	public void setTermid(int termid) {
		this.termid = termid;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public int getTrainlevelid() {
		return trainlevelid;
	}
	public void setTrainlevelid(int trainlevelid) {
		this.trainlevelid = trainlevelid;
	}
	public int getTasktypeid() {
		return tasktypeid;
	}
	public void setTasktypeid(int tasktypeid) {
		this.tasktypeid = tasktypeid;
	}
	public void setStunum(int stunum) {
		this.stunum = stunum;
	}
}
