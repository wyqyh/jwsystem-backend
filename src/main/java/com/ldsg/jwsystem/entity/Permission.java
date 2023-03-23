package com.ldsg.jwsystem.entity;

public class Permission {
	
	private int id;
	private int pid;
	private String name;
	private String icon;
	private String path;
	private String key;
	private String component;
	private boolean hidden;
	private int type;
	
	public Permission(int id, int pid, String name, String icon, String path, String key,
			String component, boolean hidden, int type) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.icon = icon;
		this.path = path;
		this.key = key;
		this.component = component;
		this.hidden = hidden;
		this.type = type;
	}
	
	public Permission(int pid, String name, String icon, String path, String key,
			String component, boolean hidden, int type) {
		this.pid = pid;
		this.name = name;
		this.icon = icon;
		this.path = path;
		this.key = key;
		this.component = component;
		this.hidden = hidden;
		this.type = type;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
