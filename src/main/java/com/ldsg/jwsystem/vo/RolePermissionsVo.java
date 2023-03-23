package com.ldsg.jwsystem.vo;

import java.util.List;

public class RolePermissionsVo {
	
	private int rid;
	private String rname;
	private List<PermissionVo> permissions;
	
	public RolePermissionsVo(int rid, String rname) {
		this.rid = rid;
		this.rname = rname;
	}
	
	public RolePermissionsVo(int rid, String rname, List<PermissionVo> permissions) {
		this.rid = rid;
		this.rname = rname;
		this.permissions = permissions;
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public List<PermissionVo> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionVo> permissions) {
		this.permissions = permissions;
	}
}
