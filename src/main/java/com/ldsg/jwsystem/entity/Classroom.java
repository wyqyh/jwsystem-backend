package com.ldsg.jwsystem.entity;

public class Classroom {

	private int id;
	private String roomno;
	private int locationid;
	
	public Classroom(int id, String roomno, int locationid) {
		this.id = id;
		this.roomno = roomno;
		this.locationid = locationid;
	}
	
	public Classroom(String roomno, int locationid) {
		this.roomno = roomno;
		this.locationid = locationid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
}
