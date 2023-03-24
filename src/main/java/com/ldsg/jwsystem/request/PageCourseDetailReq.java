package com.ldsg.jwsystem.request;

public class PageCourseDetailReq {
	
	private int uid;
	private int classid;
	
	private int pagenum;
	private int pagesize;
	
	public PageCourseDetailReq(int uid, int classid, int pagenum, int pagesize) {
		this.uid = uid;
		this.classid = classid;
		this.pagenum = pagenum;
		this.pagesize = pagesize;
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
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}
