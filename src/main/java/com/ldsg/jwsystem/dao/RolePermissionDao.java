package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.RolePermission;

public interface RolePermissionDao {

	public void batchAddRolePermission(List<RolePermission> rolePermissions);

	public List<Integer> getPermissionIdsByRoleId(@Param("roleId") int roleId);
	
	public void deleteByRoleId(@Param("roleId") int roleId);
	
	public void deleteByRoleIds(List<Integer> roleIds);
	
	public void deleteByPermIds(List<Integer> permIds);
}
