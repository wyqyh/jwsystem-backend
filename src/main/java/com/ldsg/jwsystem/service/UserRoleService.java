package com.ldsg.jwsystem.service;

import java.util.List;

import com.ldsg.jwsystem.request.UserRolesRequest;

public interface UserRoleService {

	public List<Integer> getRidsByUid(int uid);

	public void addUserRoles(UserRolesRequest userRolesRequest);
}
