package com.ldsg.jwsystem.response;

public class TypeDataResponse {

	private int id;
	private int typeid;
	private String typeno;
	private String name;
	private String typename;
	
	public TypeDataResponse(int id, int typeid, String typeno, String name, String typename) {
		this.id = id;
		this.typeid = typeid;
		this.typeno = typeno;
		this.name = name;
		this.typename = typename;
	}

	public TypeDataResponse(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public TypeDataResponse(int id, int typeid, String typeno, String name) {
		this.id = id;
		this.typeid = typeid;
		this.typeno = typeno;
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

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
