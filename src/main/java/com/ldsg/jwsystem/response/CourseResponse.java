package com.ldsg.jwsystem.response;

import java.util.List;

public class CourseResponse {

	private int id;
	private int classid;
	private int classno;
	private String term;
	private String trainlevel;
	private String coursename;
	private String majorname;
	private int stunum;
	private String deptname;
	private String tasktype;
	private String practicetype;
	private int theroyhour;
	private int practicehour;
	private String prime;
	private String batchcoeff;
	private String teachername;
	private List<UserResponse> teacIdNames;
	private String createTime;
	
	public CourseResponse(int id, int classid, int classno, String term, String trainlevel, String coursename, String majorname,
			int stunum, String deptname, String tasktype, String practicetype, int theroyhour, int practicehour, String prime,
			String batchcoeff, String teachername, List<UserResponse> teacIdNames, String createTime) {
		this.id = id;
		this.classid = classid;
		this.classno = classno;
		this.term = term;
		this.trainlevel = trainlevel;
		this.coursename = coursename;
		this.majorname = majorname;
		this.stunum = stunum;
		this.deptname = deptname;
		this.tasktype = tasktype;
		this.practicetype = practicetype;
		this.theroyhour = theroyhour;
		this.practicehour = practicehour;
		this.prime = prime;
		this.batchcoeff = batchcoeff;
		this.teachername = teachername;
		this.teacIdNames = teacIdNames;
		this.createTime = createTime;
	}
	
	public CourseResponse(int id, String coursename) {
		this.id = id;
		this.coursename = coursename;
	}


	public int getId() {
		return id;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassno() {
		return classno;
	}

	public void setClassno(int classno) {
		this.classno = classno;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTrainlevel() {
		return trainlevel;
	}

	public void setTrainlevel(String trainlevel) {
		this.trainlevel = trainlevel;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public int getStunum() {
		return stunum;
	}

	public void setStunum(int stunum) {
		this.stunum = stunum;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public String getPracticetype() {
		return practicetype;
	}

	public void setPracticetype(String practicetype) {
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

	public String getPrime() {
		return prime;
	}

	public void setPrime(String prime) {
		this.prime = prime;
	}

	public String getBatchcoeff() {
		return batchcoeff;
	}

	public void setBatchcoeff(String batchcoeff) {
		this.batchcoeff = batchcoeff;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public List<UserResponse> getTeacIdNames() {
		return teacIdNames;
	}

	public void setTeacIdNames(List<UserResponse> teacIdNames) {
		this.teacIdNames = teacIdNames;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
