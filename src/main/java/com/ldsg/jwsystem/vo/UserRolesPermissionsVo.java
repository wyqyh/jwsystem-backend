package com.ldsg.jwsystem.vo;

import java.util.List;

public class UserRolesPermissionsVo {
	private int uid;
	private String uname;
	private String deptid;
	private String deptname;
	private List<RolePermissionsVo> rolePermissions;
	
	public UserRolesPermissionsVo(int uid, String uname, String deptid) {
		this.uid = uid;
		this.uname = uname;
		this.deptid = deptid;
	}

	public UserRolesPermissionsVo(int uid, String uname, String deptid, String deptname,
			List<RolePermissionsVo> rolePermissions) {
		this.uid = uid;
		this.uname = uname;
		this.deptid = deptid;
		this.deptname = deptname;
		this.rolePermissions = rolePermissions;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<RolePermissionsVo> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermissionsVo> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}
}
