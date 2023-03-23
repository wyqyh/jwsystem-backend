package com.ldsg.jwsystem.request;

import java.util.List;

public class PageCourseRequest {

	private List<String> classnos;
	private List<Integer> termids;
	private List<Integer> majorids;
	private List<Integer> trainlevelids;
	private List<Integer> tasktypeids;
	private List<Integer> practicetypes;
	private List<String> coursenames;
	
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
	public List<Integer> getPracticetypes() {
		return practicetypes;
	}
	public void setPracticetypes(List<Integer> practicetypes) {
		this.practicetypes = practicetypes;
	}
	public List<String> getCoursenames() {
		return coursenames;
	}
	public void setCoursenames(List<String> coursenames) {
		this.coursenames = coursenames;
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
