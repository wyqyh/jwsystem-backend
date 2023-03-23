package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.Role;
import com.ldsg.jwsystem.vo.RolePermissionsVo;

public interface RoleDao {
	
	public List<RolePermissionsVo> getRolesPermissionsByUid(@Param("uid") int uid);
	
	public List<Role> getRolesList(@Param("roleName") String roleName, @Param("roleKey") String roleKey, @Param("status") String status,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime);
	
	public void addRole(Role role);
	
	public Role getRoleById(@Param("roleId") int roleId);
	
	public void updateRole(Role role);
	
	public void deleteByRoleId(@Param("roleId") int roleId);
	
	public void deleteByRoleIds(List<Integer> roleIds);

	public void updateRoleStatus(@Param("roleId") int roleId, @Param("status") String status);
}
