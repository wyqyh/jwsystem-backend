package com.ldsg.jwsystem.service;

import java.util.List;

import com.ldsg.jwsystem.request.PermissionRequest;
import com.ldsg.jwsystem.response.PermissionResponse;
import com.ldsg.jwsystem.response.PermissionTreeResponse;

public interface PermissionService {

	public PermissionResponse getPermissionsByUid(int uid);
	
	public List<PermissionTreeResponse> getPermissions(String permName);

	public void addPermission(PermissionRequest permissionRequest);

	public void deletePermission(int permId);

	public void updatePermission(PermissionRequest permissionRequest);
}
