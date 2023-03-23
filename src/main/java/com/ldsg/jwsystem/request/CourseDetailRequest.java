package com.ldsg.jwsystem.request;

public class CourseDetailRequest {

	private int id;
	private int classid;
	private String classno;
	private int courseid;
	private int teacherid;
	private int prime;
	private int teachtypeid;
	private String teachdate;
	private int teachlocid;
	private int teachsessid;
	private String teachcontent;
	
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
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getPrime() {
		return prime;
	}
	public void setPrime(int prime) {
		this.prime = prime;
	}
	public int getTeachtypeid() {
		return teachtypeid;
	}
	public void setTeachtypeid(int teachtypeid) {
		this.teachtypeid = teachtypeid;
	}
	public String getTeachdate() {
		return teachdate;
	}
	public void setTeachdate(String teachdate) {
		this.teachdate = teachdate;
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
	public String getTeachcontent() {
		return teachcontent;
	}
	public void setTeachcontent(String teachcontent) {
		this.teachcontent = teachcontent;
	}
}
