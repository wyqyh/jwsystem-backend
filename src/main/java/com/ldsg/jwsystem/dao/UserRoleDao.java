package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.UserRole;

public interface UserRoleDao {

	public void delByUid(@Param("uid") int uid);
	
	public void batchInsert(List<UserRole> userRoles);
	
	public List<Integer> getRoleIdsByUid(@Param("uid") int uid);
	
	public List<UserRole> getRoleIdsByUids(List<Integer> uids);
}
