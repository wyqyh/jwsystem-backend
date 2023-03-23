package com.ldsg.jwsystem.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.PermissionDao;
import com.ldsg.jwsystem.dao.RolePermissionDao;
import com.ldsg.jwsystem.entity.Permission;
import com.ldsg.jwsystem.request.PermissionRequest;
import com.ldsg.jwsystem.response.PermissionResponse;
import com.ldsg.jwsystem.response.PermissionTreeResponse;
import com.ldsg.jwsystem.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	private RolePermissionDao rolePermissionDao;

	@Override
	public PermissionResponse getPermissionsByUid(int uid) {
		
		List<Permission> permissions = this.permissionDao.getPermissionsByUid(uid);
		
		if(CollectionUtils.isNotEmpty(permissions)) {
			
			List<String> perms = Lists.newArrayList();
			List<Permission> permissionMenus = permissions.stream().filter(permission -> {
				int type = permission.getType();
				if(type == 2) {
					String key = permission.getKey();
					if(StringUtils.isNoneEmpty(key)) {
						perms.add(key);
					}
				}
				if(StringUtils.isEmpty(permission.getPath())) {
					return false;
				}
				return true;
			}).collect(Collectors.toList());
			
			List<PermissionTreeResponse> menus = this.trans2Tree(permissionMenus);
			
			PermissionResponse permissionResponse = new PermissionResponse(menus, perms);
			return permissionResponse;
		}
		return null;
	}
	
	@Override
	public List<PermissionTreeResponse> getPermissions(String permName) {
		List<Permission> permissions = this.permissionDao.getPermissions(permName);
		if(CollectionUtils.isNotEmpty(permissions)) {
			return this.trans2Tree(permissions);
		}
		return null;
	}

	private List<PermissionTreeResponse> trans2Tree(List<Permission> permissions) {
		
		List<PermissionTreeResponse> permissionsTree = permissions.stream().map(perm -> new PermissionTreeResponse(perm.getId(), perm.getPid(), perm.getName(), perm.getIcon(), perm.getPath(),  
									perm.getKey(), perm.getComponent(), perm.isHidden(), perm.getType())).collect(Collectors.toList());
		// <pid, permission>
		Map<Integer, List<PermissionTreeResponse>> permissionIdMap = permissionsTree.stream()
				.collect(Collectors.groupingBy(PermissionTreeResponse::getPid));
				
		Stack<PermissionTreeResponse> permissionStack = new Stack<PermissionTreeResponse>();
		
		//找到pid最小值，可能是子树集，最小pid不一定是0
		int minPid = permissions.stream().min(Comparator.comparing(Permission::getPid)).get().getPid();
		
		List<PermissionTreeResponse> rootPermission = permissionsTree.stream().filter(item -> item.getPid() == minPid).collect(Collectors.toList());
		rootPermission.forEach(e -> permissionStack.push(e));
		
		while(!permissionStack.isEmpty()) {
			PermissionTreeResponse currentPermission = permissionStack.pop();
			int id = currentPermission.getId();
			List<PermissionTreeResponse> children = permissionIdMap.get(id);
			if(CollectionUtils.isNotEmpty(children)) {
				currentPermission.setChildren(children);
				children.stream().forEach(e -> permissionStack.push(e));
			}
		}
		return rootPermission;
	}

	@Override
	public void addPermission(PermissionRequest permissionRequest) {
		String permName = permissionRequest.getPermName();
	    int fatherId = permissionRequest.getFatherId();
	    String iconName = permissionRequest.getIconName();
	    String path = permissionRequest.getPath();
	    String component = permissionRequest.getComponent();
	    String key = permissionRequest.getKey();
	    int type = Integer.parseInt(permissionRequest.getPermType());
	    boolean hidden = permissionRequest.isHidden();
	    
	    Permission permission = new Permission(fatherId, permName, iconName, path, key, component, hidden, type);
	    this.permissionDao.insertPermission(permission);
	}

	@Override
	public void deletePermission(int permId) {
		List<Permission> permissions = this.permissionDao.getPermissions(null);
		Permission permission = this.permissionDao.getPermissionById(permId);
		
		Stack<Permission> stack = new Stack<Permission>();
		
		List<Integer> deleteIds = Lists.newArrayList();
		
		if(permission != null && CollectionUtils.isNotEmpty(permissions)) {
			stack.push(permission);
			// <pid, permission>
			Map<Integer, List<Permission>> permissionIdMap = permissions.stream().collect(Collectors.groupingBy(Permission::getPid));
			while(!stack.isEmpty()) {
				Permission perm = stack.pop();
				int perId = perm.getId();
				deleteIds.add(perId);
				List<Permission> children = permissionIdMap.get(perId);
				if(CollectionUtils.isNotEmpty(children)) {
					children.stream().forEach(e -> stack.push(e));
				}
			}
			this.permissionDao.deleteByIds(deleteIds);
			this.rolePermissionDao.deleteByPermIds(deleteIds);
		}
	}

	@Override
	public void updatePermission(PermissionRequest permissionRequest) {
		int permId = permissionRequest.getPermId();
		String permName = permissionRequest.getPermName();
	    int fatherId = permissionRequest.getFatherId();
	    String iconName = permissionRequest.getIconName();
	    String path = permissionRequest.getPath();
	    String component = permissionRequest.getComponent();
	    String key = permissionRequest.getKey();
	    int type = Integer.parseInt(permissionRequest.getPermType());
	    boolean hidden = permissionRequest.isHidden();
	    
	    Permission permission = new Permission(permId, fatherId, permName, iconName, path, key, component, hidden, type);
	    this.permissionDao.updatePermission(permission);
	}

}
