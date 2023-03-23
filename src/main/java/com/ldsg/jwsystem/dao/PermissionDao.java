package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.Permission;
import com.ldsg.jwsystem.vo.PermissionVo;

public interface PermissionDao {
	
	public List<PermissionVo> getPermissionsByRid(@Param("rid") int rid);
	
	public List<Permission> getPermissionsByUid(@Param("uid") int uid);
	
	public List<Permission> getPermissions(@Param("permName") String permName);
	
	public Permission getPermissionById(@Param("permId") int permId);

	public void insertPermission(Permission permission);
	
	public void deleteByIds(List<Integer> permIds);

	public void updatePermission(Permission permission);
}
