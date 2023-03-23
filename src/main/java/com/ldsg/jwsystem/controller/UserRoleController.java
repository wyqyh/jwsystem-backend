package com.ldsg.jwsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldsg.jwsystem.request.UserRolesRequest;
import com.ldsg.jwsystem.service.UserRoleService;

@RestController
@RequestMapping("/user/role")
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;

	@GetMapping("/{uid}")
	public List<Integer> getRidsByUid(@PathVariable("uid") int uid) {
		return this.userRoleService.getRidsByUid(uid);
	}
	
	
	@PostMapping("/add")
	public void addUserRoles(@RequestBody UserRolesRequest userRolesRequest) {
		this.userRoleService.addUserRoles(userRolesRequest);
	}
}
