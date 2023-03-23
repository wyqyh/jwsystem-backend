package com.ldsg.jwsystem.vo;

public class PermissionVo {
	
	private int perid;
	private int parentId;
	private String pername;
	private String icon;
	private String path;
	private String key;
	private String component;
	private boolean hidden;
	
	public PermissionVo(int perid, int parentId, String pername, String icon, String path, String key,
			String component, boolean hidden) {
		this.perid = perid;
		this.parentId = parentId;
		this.pername = pername;
		this.icon = icon;
		this.path = path;
		this.key = key;
		this.component = component;
		this.hidden = hidden;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getPername() {
		return pername;
	}

	public void setPername(String pername) {
		this.pername = pername;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
