package com.ldsg.jwsystem.response;

public class ClassResponse {

	private int id;
	private String classno;
	private int stunum;
	private int termid;
	private String term;
	private int deptid;
	private String deptname;
	private int majorid;
	private String majorname;
	private int trainlevelid;
	private String trainlevel;
	private int tasktypeid;
	private String tasktype;
	private String createTime;
	
	public ClassResponse(int id, String classno, int stunum, int termid, String term, int deptid, String deptname,
			int majorid, String majorname, int trainlevelid, String trainlevel, int tasktypeid, String tasktype, String createTime) {
		this.id = id;
		this.classno = classno;
		this.stunum = stunum;
		this.termid = termid;
		this.term = term;
		this.deptid = deptid;
		this.deptname = deptname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.trainlevelid = trainlevelid;
		this.trainlevel = trainlevel;
		this.tasktypeid = tasktypeid;
		this.tasktype = tasktype;
		this.createTime = createTime;
	}

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

	public void setStunum(int stunum) {
		this.stunum = stunum;
	}

	public int getTermid() {
		return termid;
	}

	public void setTermid(int termid) {
		this.termid = termid;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getMajorid() {
		return majorid;
	}

	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public int getTrainlevelid() {
		return trainlevelid;
	}

	public void setTrainlevelid(int trainlevelid) {
		this.trainlevelid = trainlevelid;
	}

	public String getTrainlevel() {
		return trainlevel;
	}

	public void setTrainlevel(String trainlevel) {
		this.trainlevel = trainlevel;
	}

	public int getTasktypeid() {
		return tasktypeid;
	}

	public void setTasktypeid(int tasktypeid) {
		this.tasktypeid = tasktypeid;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
