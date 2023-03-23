package com.ldsg.jwsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldsg.jwsystem.dao.RolePermissionDao;
import com.ldsg.jwsystem.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionDao rolePermissionDao;
	
	@Override
	public List<Integer> getPermissionIdsByRoleId(int roleId) {
		return rolePermissionDao.getPermissionIdsByRoleId(roleId);
	}
}
