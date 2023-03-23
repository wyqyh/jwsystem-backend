package com.ldsg.jwsystem.request;

import java.util.List;

public class UserRolesRequest {

	private int uid;
	private List<Integer> rids;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public List<Integer> getRids() {
		return rids;
	}
	public void setRids(List<Integer> rids) {
		this.rids = rids;
	}
}
