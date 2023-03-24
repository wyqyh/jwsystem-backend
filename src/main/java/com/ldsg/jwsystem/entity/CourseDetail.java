package com.ldsg.jwsystem.entity;

public class CourseDetail {

	private int id;
	private int courseid;
	private int teacherid;
	private int prime;
	private int teachtypeid;
	private String teachdate;
	private int teachlocid;
	private int teachsessid;
	private String teachcontent;
	private int createrid;
	private String createTime;
	
	public CourseDetail(int id, int courseid, int teacherid, int prime, int teachtypeid, String teachdate,
			int teachlocid, int teachsessid, String teachcontent, String createTime) {
		this.id = id;
		this.courseid = courseid;
		this.teacherid = teacherid;
		this.prime = prime;
		this.teachtypeid = teachtypeid;
		this.teachdate = teachdate;
		this.teachlocid = teachlocid;
		this.teachsessid = teachsessid;
		this.teachcontent = teachcontent;
		this.createTime = createTime;
	}
	
	public CourseDetail(int courseid, int teacherid, int prime, int teachtypeid, String teachdate,
			int teachlocid, int teachsessid, String teachcontent, int createrid) {
		this.courseid = courseid;
		this.teacherid = teacherid;
		this.prime = prime;
		this.teachtypeid = teachtypeid;
		this.teachdate = teachdate;
		this.teachlocid = teachlocid;
		this.teachsessid = teachsessid;
		this.teachcontent = teachcontent;
		this.createrid = createrid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCreaterid() {
		return createrid;
	}
	public void setCreaterid(int createrid) {
		this.createrid = createrid;
	}

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
