package com.ldsg.jwsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.entity.Role;
import com.ldsg.jwsystem.request.RoleRequest;
import com.ldsg.jwsystem.response.RoleResponse;
import com.ldsg.jwsystem.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public PageInfo<Role> getRolesList(RoleRequest roleRequest) {
		return this.roleService.getRolesList(roleRequest);
	}
	
	@PostMapping("/add")
	public void addRole(@RequestBody RoleRequest roleRequest) {
		this.roleService.addRole(roleRequest);
	}
	
	@PostMapping("/update")
	public void updateRole(@RequestBody RoleRequest roleRequest) {
		this.roleService.updateRole(roleRequest);
	}
	
	@GetMapping("/{roleId}")
	public RoleResponse getRoleById(@PathVariable("roleId") int roleId) {
		return this.roleService.getRoleById(roleId);
	}
	
	@PostMapping("/delete")
	public void deleteRoleByIds(@RequestBody int[] roleIds) {
		this.roleService.deleteRoleByIds(roleIds);
	}
	
	@PostMapping("/status/update")
	public void updateRoleStatus(@RequestBody RoleRequest roleRequest) {
		this.roleService.updateRoleStatus(roleRequest);
	}
}
