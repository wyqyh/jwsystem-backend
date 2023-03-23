package com.ldsg.jwsystem.response;

import java.util.List;

public class PermissionResponse {

	private List<PermissionTreeResponse> menus;
	
	private List<String> perms;

	public PermissionResponse(List<PermissionTreeResponse> menus, List<String> perms) {
		this.menus = menus;
		this.perms = perms;
	}

	public List<PermissionTreeResponse> getMenus() {
		return menus;
	}

	public void setMenus(List<PermissionTreeResponse> menus) {
		this.menus = menus;
	}

	public List<String> getPerms() {
		return perms;
	}

	public void setPerms(List<String> perms) {
		this.perms = perms;
	}
}
