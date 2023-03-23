package com.ldsg.jwsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.UserPwdUpdateReq;
import com.ldsg.jwsystem.request.UserRequest;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.response.UserResponse;
import com.ldsg.jwsystem.service.UserService;
import com.ldsg.jwsystem.vo.UserRolesPermissionsVo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public void register(@RequestBody UserRequest userRequest) {
		this.userService.addUser(userRequest);
	}
	
	@PostMapping("/update")
	public void updateUser(@RequestBody UserRequest userRequest) {
		this.userService.updateUser(userRequest);
	}
	
	@PostMapping("/login")
	public UserResponse login(@RequestBody UserRequest userRequest, HttpServletRequest request) {
		HttpSession session = request.getSession();
        String s = ("code_") + session.getId();
        String code = (String) session.getAttribute(s);
        
        String checkcode = userRequest.getCheckcode();
        if(checkcode.equals(code)) {
        	return this.userService.login(userRequest);
        } else {
        	throw new RuntimeException("验证码错误");
        }
	}
	
	@PostMapping("/getUserRolePermission")
	public UserRolesPermissionsVo getUserRolesPermissions(int id) {
		return this.userService.getUserRolesPermissions(id);
	}
	
	@GetMapping("/getbyid/{uid}")
	public UserResponse getUserByUid(@PathVariable("uid") int uid) {
		return this.userService.getUserByUid(uid);
	}
	
	@PostMapping("/get")
	public PageInfo<UserResponse> getUsers(@RequestBody UserRequest userRequest) {
		return this.userService.getUsers(userRequest);
	}
	
	@PostMapping("/del")
	public void delUsers(@RequestBody int[] userIds) {
		this.userService.delUsers(userIds);
	}
	
	@PostMapping("/upload/avatar")
	public String uploadAvatar(@RequestParam(value = "uid") int uid,
			@RequestParam(value = "avatarfile") MultipartFile avatarFile) {
		return this.userService.uploadAvatar(uid, avatarFile);
	}
	
	@PostMapping("/update/pwd")
	public MessageCode updatePwd(@RequestBody UserPwdUpdateReq userPwdUpdateReq) {
		return this.userService.updatePwd(userPwdUpdateReq);
	}
	
	@GetMapping("/get/select")
	public List<UserResponse> getUsers() {
		return this.userService.getUsers();
	}
}
