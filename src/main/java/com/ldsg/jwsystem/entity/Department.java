package com.ldsg.jwsystem.entity;

public class Department {
	
	private int id;
	private int pid;
	private String name;
	private String charger;
	private String tel;
	
	public Department(int pid, String name, String charger, String tel) {
		this.pid = pid;
		this.name = name;
		this.charger = charger;
		this.tel = tel;
	}

	public Department(int id, int pid, String name, String charger, String tel) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.charger = charger;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharger() {
		return charger;
	}

	public void setCharger(String charger) {
		this.charger = charger;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
