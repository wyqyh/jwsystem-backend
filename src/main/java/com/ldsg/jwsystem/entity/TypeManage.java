package com.ldsg.jwsystem.entity;

public class TypeManage {

	private int id;
	private String no;
	private String name;
	
	public TypeManage(int id, String no, String name) {
		this.id = id;
		this.no = no;
		this.name = name;
	}

	public TypeManage(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
