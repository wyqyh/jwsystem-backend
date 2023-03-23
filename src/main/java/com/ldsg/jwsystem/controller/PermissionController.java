package com.ldsg.jwsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ldsg.jwsystem.request.PermissionRequest;
import com.ldsg.jwsystem.response.PermissionResponse;
import com.ldsg.jwsystem.response.PermissionTreeResponse;
import com.ldsg.jwsystem.service.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@PostMapping("/by/uid")
	public PermissionResponse getPermissionsByUid(int uid) {
		return this.permissionService.getPermissionsByUid(uid);
	}
	
	@PostMapping("/all")
	public List<PermissionTreeResponse> getPermissions(@RequestParam(required = false) String permName) {
		return this.permissionService.getPermissions(permName);
	}
	
	@PostMapping("/add")
	public void addPermission(@RequestBody PermissionRequest permissionRequest) {
		this.permissionService.addPermission(permissionRequest);
	}
	
	@PostMapping("/update")
	public void updatePermission(@RequestBody PermissionRequest permissionRequest) {
		this.permissionService.updatePermission(permissionRequest);
	}
	
	@GetMapping("/delete/{permId}")
	public void deletePermission(@PathVariable("permId") int permId) {
		this.permissionService.deletePermission(permId);
	}
}
