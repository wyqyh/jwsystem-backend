package com.ldsg.jwsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.RoleDao;
import com.ldsg.jwsystem.dao.RolePermissionDao;
import com.ldsg.jwsystem.entity.Role;
import com.ldsg.jwsystem.entity.RolePermission;
import com.ldsg.jwsystem.request.RoleRequest;
import com.ldsg.jwsystem.response.RoleResponse;
import com.ldsg.jwsystem.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RolePermissionDao rolePermissionDao;
	
	@Override
	public PageInfo<Role> getRolesList(RoleRequest roleRequest) {
		
		String roleName = roleRequest.getRoleName();
		String roleKey = roleRequest.getRoleKey();
		String status = roleRequest.getStatus();
		String beginTime = roleRequest.getBeginTime();
		String endTime = roleRequest.getEndTime();
		
		int pageNum = roleRequest.getPageNum();
		int pageSize = roleRequest.getPageSize();
		
		PageHelper.startPage(pageNum, pageSize, true);
		List<Role> roleList = this.roleDao.getRolesList(roleName, roleKey, status, beginTime, endTime);
		
		PageInfo<Role> roles = new PageInfo<Role>(roleList);
		roles.setPageNum(pageNum);
		roles.setPageSize(pageSize);
		return roles;
	}

	@Override
	@Transactional
	public void addRole(RoleRequest roleRequest) {
		Role role = new Role(roleRequest.getRoleName(), roleRequest.getRoleKey(), roleRequest.getRoleSort(), roleRequest.getStatus(), false, roleRequest.getRemark());
		this.roleDao.addRole(role);
		int roleId = role.getId();
		
		int[] permIdArr = roleRequest.getPermIds();
		if(permIdArr != null && permIdArr.length > 0) {
			List<RolePermission> rolePermissions = Lists.newArrayList();
			
			for(int i = 0; i < permIdArr.length; i++) {
				int permId = permIdArr[i];
				RolePermission rolePermission = new RolePermission(roleId, permId);
				rolePermissions.add(rolePermission);
			}
			
			this.rolePermissionDao.batchAddRolePermission(rolePermissions);
		}
	}

	@Override
	public RoleResponse getRoleById(int roleId) {
		Role role = this.roleDao.getRoleById(roleId);
		RoleResponse roleResponse = new RoleResponse(role.getId(), role.getName(), role.getKey(), role.getSort(), role.getStatus(), role.getRemark());
		return roleResponse;
	}

	@Override
	@Transactional
	public void updateRole(RoleRequest roleRequest) {
		int roleId = roleRequest.getRoleId();
		Role role = new Role(roleId, roleRequest.getRoleName(), roleRequest.getRoleKey(), roleRequest.getRoleSort(), roleRequest.getStatus(), roleRequest.getRemark());
		this.roleDao.updateRole(role);
		
		this.rolePermissionDao.deleteByRoleId(roleId);
		int[] permIdArr = roleRequest.getPermIds();
		if(permIdArr != null && permIdArr.length > 0) {
			List<RolePermission> rolePermissions = Lists.newArrayList();
			
			for(int i = 0; i < permIdArr.length; i++) {
				int permId = permIdArr[i];
				RolePermission rolePermission = new RolePermission(roleId, permId);
				rolePermissions.add(rolePermission);
			}
			
			this.rolePermissionDao.batchAddRolePermission(rolePermissions);
		}
	}

	@Override
	@Transactional
	public void deleteRoleByIds(int[] roleIds) {
		if(roleIds != null && roleIds.length > 0) {
			
			List<Integer> roleIdList = Lists.newArrayList();
			for(int i = 0; i < roleIds.length; i++) {
				int roleId = roleIds[i];
				roleIdList.add(roleId);
			}
			
			this.roleDao.deleteByRoleIds(roleIdList);
			this.rolePermissionDao.deleteByRoleIds(roleIdList);
		}
		
	}

	@Override
	public void updateRoleStatus(RoleRequest roleRequest) {
		int roleId = roleRequest.getRoleId();
		String status = roleRequest.getStatus();
		this.roleDao.updateRoleStatus(roleId, status);
	}

}
