package com.ldsg.jwsystem.request;

import java.util.List;

public class PageClassRequest {

	private List<String> classnos;
	private List<Integer> termids;
	private List<Integer> deptids;
	private List<Integer> majorids;
	private List<Integer> trainlevelids;
	private List<Integer> tasktypeids;
	
	private int pagenum;
	private int pagesize;


	public List<String> getClassnos() {
		return classnos;
	}
	public void setClassnos(List<String> classnos) {
		this.classnos = classnos;
	}
	public List<Integer> getTermids() {
		return termids;
	}
	public void setTermids(List<Integer> termids) {
		this.termids = termids;
	}
	public List<Integer> getDeptids() {
		return deptids;
	}
	public void setDeptids(List<Integer> deptids) {
		this.deptids = deptids;
	}
	public List<Integer> getMajorids() {
		return majorids;
	}
	public void setMajorids(List<Integer> majorids) {
		this.majorids = majorids;
	}
	public List<Integer> getTrainlevelids() {
		return trainlevelids;
	}
	public void setTrainlevelids(List<Integer> trainlevelids) {
		this.trainlevelids = trainlevelids;
	}
	public List<Integer> getTasktypeids() {
		return tasktypeids;
	}
	public void setTasktypeids(List<Integer> tasktypeids) {
		this.tasktypeids = tasktypeids;
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
