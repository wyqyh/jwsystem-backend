package com.ldsg.jwsystem.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.UserRoleDao;
import com.ldsg.jwsystem.entity.UserRole;
import com.ldsg.jwsystem.request.UserRolesRequest;
import com.ldsg.jwsystem.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public List<Integer> getRidsByUid(int uid) {
		return this.userRoleDao.getRoleIdsByUid(uid);
	}

	@Override
	@Transactional
	public void addUserRoles(UserRolesRequest userRolesRequest) {
		int uid = userRolesRequest.getUid();
		this.userRoleDao.delByUid(uid);
		
		List<Integer> rids = userRolesRequest.getRids();
		if(CollectionUtils.isNotEmpty(rids)) {
			List<UserRole> userRoles = Lists.newArrayList();
			rids.stream().forEach(rid -> {
				UserRole userRole = new UserRole(uid, rid);
				userRoles.add(userRole);
			});
			
			this.userRoleDao.batchInsert(userRoles);
		}
	}

}
