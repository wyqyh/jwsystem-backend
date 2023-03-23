package com.ldsg.jwsystem.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.UserPwdUpdateReq;
import com.ldsg.jwsystem.request.UserRequest;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.response.UserResponse;
import com.ldsg.jwsystem.vo.UserRolesPermissionsVo;

public interface UserService {

	public void addUser(UserRequest userRequest);

	public UserResponse login(UserRequest userRequest);
	
	public UserRolesPermissionsVo getUserRolesPermissions(int id);

	public PageInfo<UserResponse> getUsers(UserRequest userRequest);

	public void updateUser(UserRequest userRequest);

	public void delUsers(int[] userIds);

	public UserResponse getUserByUid(int uid);

	public String uploadAvatar(int uid, MultipartFile avatarFile);

	public MessageCode updatePwd(UserPwdUpdateReq userPwdUpdateReq);
	
	public List<UserResponse> getUsers();
}
