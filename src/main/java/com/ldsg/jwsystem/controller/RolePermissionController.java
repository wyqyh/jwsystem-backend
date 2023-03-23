package com.ldsg.jwsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldsg.jwsystem.service.RolePermissionService;

@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {

	@Autowired
	private RolePermissionService rolePermissionService;
	
	@GetMapping("/byRoleId/{roleId}")
	public List<Integer> getPermissionIdsByRoleId(@PathVariable("roleId") int roleId) {
		return this.rolePermissionService.getPermissionIdsByRoleId(roleId);
	}
}
