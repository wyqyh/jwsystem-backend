package com.ldsg.jwsystem.request;

public class RoleRequest {

	private int roleId;
	private String roleName;
	private String roleKey;
	private String status;
	//角色包含的权限Id
	private int[] permIds;
	private int roleSort;
	private String remark;
	private String beginTime;
	private String endTime;
	
	private int pageNum = 1;
	private int pageSize = 10;
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	public String getStatus() {
		return status;
	}
	public int[] getPermIds() {
		return permIds;
	}
	public void setPermIds(int[] permIds) {
		this.permIds = permIds;
	}
	public int getRoleSort() {
		return roleSort;
	}
	public void setRoleSort(int roleSort) {
		this.roleSort = roleSort;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
