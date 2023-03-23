package com.ldsg.jwsystem.vo;

import com.ldsg.jwsystem.response.MessageCode;

public class CourseDetailVo extends MessageCode {

	private int id;
	private String classno;
	private int termid;
	private String term;
	private int trainlevelid;
	private String trainlevel;
	private int majorid;
	private String majorname;
	private String coursename;
	private int teacherid;
	private String teachername;
	// 上课教室
	private int teachlocid;
	private String teachlocat;
	// 授课日期
	private String teachdate;
	// 授课节次
	private int teachsessid;
	private String teachsess;

	

	public CourseDetailVo(int id, String classno, int termid, int trainlevelid, int majorid, String coursename,
			int teacherid, String teachername, int teachlocid, String teachdate, int teachsessid) {
		super();
		this.id = id;
		this.classno = classno;
		this.termid = termid;
		this.trainlevelid = trainlevelid;
		this.majorid = majorid;
		this.coursename = coursename;
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.teachlocid = teachlocid;
		this.teachdate = teachdate;
		this.teachsessid = teachsessid;
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

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeachlocat() {
		return teachlocat;
	}

	public void setTeachlocat(String teachlocat) {
		this.teachlocat = teachlocat;
	}

	public String getTeachdate() {
		return teachdate;
	}

	public void setTeachdate(String teachdate) {
		this.teachdate = teachdate;
	}

	public String getTeachsess() {
		return teachsess;
	}

	public void setTeachsess(String teachsess) {
		this.teachsess = teachsess;
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

	public int getMajorid() {
		return majorid;
	}

	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public int getTeachlocid() {
		return teachlocid;
	}

	public void setTeachlocid(int teachlocid) {
		this.teachlocid = teachlocid;
	}

	public int getTeachsessid() {
		return teachsessid;
	}

	public void setTeachsessid(int teachsessid) {
		this.teachsessid = teachsessid;
	}
}
