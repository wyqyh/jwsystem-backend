package com.ldsg.jwsystem.service;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.entity.Role;
import com.ldsg.jwsystem.request.RoleRequest;
import com.ldsg.jwsystem.response.RoleResponse;

public interface RoleService {

	public PageInfo<Role> getRolesList(RoleRequest roleRequest);

	public void addRole(RoleRequest roleRequest);
	
	public RoleResponse getRoleById(int roleId);

	public void updateRole(RoleRequest roleRequest);

	public void deleteRoleByIds(int[] roleIds);

	public void updateRoleStatus(RoleRequest roleRequest);
}
