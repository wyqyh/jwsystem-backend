package com.ldsg.jwsystem.response;

import java.util.List;

import com.ldsg.jwsystem.entity.Department;

public class DeptResponse extends Department{

	private List<DeptResponse> children;
	
	public DeptResponse(int id, int pid, String name, String charger, String tel) {
		super(id, pid, name, charger, tel);
	}

	public List<DeptResponse> getChildren() {
		return children;
	}

	public void setChildren(List<DeptResponse> children) {
		this.children = children;
	}
}
