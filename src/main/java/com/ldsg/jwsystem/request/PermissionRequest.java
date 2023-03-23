package com.ldsg.jwsystem.request;

public class PermissionRequest {

	private int permId;
	private String permName;
    private int fatherId;
    private String iconName;
    private String path;
    private String component;
    private String key;
    private String permType;
    private boolean hidden;
    
	public int getPermId() {
		return permId;
	}
	public void setPermId(int permId) {
		this.permId = permId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public int getFatherId() {
		return fatherId;
	}
	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPermType() {
		return permType;
	}
	public void setPermType(String permType) {
		this.permType = permType;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
