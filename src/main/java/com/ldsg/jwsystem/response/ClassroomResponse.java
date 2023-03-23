package com.ldsg.jwsystem.response;

public class ClassroomResponse {

	private int id;
	private String roomno;
	private int locationid;
	private String location;
	
	public ClassroomResponse(int id, String roomno, int locationid, String location) {
		this.id = id;
		this.roomno = roomno;
		this.locationid = locationid;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
