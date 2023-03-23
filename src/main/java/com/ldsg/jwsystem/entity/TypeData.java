package com.ldsg.jwsystem.entity;

public class TypeData {

	private int id;
	private int typeid;
	private String typeno;
	private String name;
	
	public TypeData(int id, int typeid, String typeno, String name) {
		this.id = id;
		this.typeid = typeid;
		this.typeno = typeno;
		this.name = name;
	}

	public TypeData(int typeid, String typeno, String name) {
		this.typeid = typeid;
		this.typeno = typeno;
		this.name = name;
	}
	
	public TypeData(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeid() {
		return typeid;
	}

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
