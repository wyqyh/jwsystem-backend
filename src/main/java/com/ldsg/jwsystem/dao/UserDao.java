package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.User;
import com.ldsg.jwsystem.request.UserRequest;
import com.ldsg.jwsystem.vo.UserRolesPermissionsVo;

public interface UserDao {

	public int addUser(User user);

	public User getUserByAccountPassword(@Param("account") String account, @Param("password") String password);
	
	public UserRolesPermissionsVo getUserRolesPermissions(@Param("id") int id);
	
	public List<User> getUsers(@Param("uname") String uname, @Param("deptIds") List<Integer> deptIds);
	
	public void setDeptNull(@Param("deptid") int deptid);

	public void updateUser(UserRequest userRequest);

	public void delUsers(List<Integer> userIds);

	public User getUserByUid(@Param("uid") int uid);

	public void updateAvatar(@Param("avatarPath") String avatarPath, @Param("uid") int uid);

	public void updatePwd(@Param("uid") int uid, @Param("newPwd") String newPwd);
}
