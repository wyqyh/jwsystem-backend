package com.ldsg.jwsystem.service;

import java.util.List;

public interface RolePermissionService {

	public List<Integer> getPermissionIdsByRoleId(int roleId);
}
