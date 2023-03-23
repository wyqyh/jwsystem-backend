package com.ldsg.jwsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.DepartmentDao;
import com.ldsg.jwsystem.dao.UserDao;
import com.ldsg.jwsystem.dao.UserRoleDao;
import com.ldsg.jwsystem.entity.Department;
import com.ldsg.jwsystem.entity.User;
import com.ldsg.jwsystem.entity.UserRole;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.UserPwdUpdateReq;
import com.ldsg.jwsystem.request.UserRequest;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.response.UserResponse;
import com.ldsg.jwsystem.service.UserService;
import com.ldsg.jwsystem.utils.FileUtils;
import com.ldsg.jwsystem.vo.UserRolesPermissionsVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Value("${file.display.prefix.path}")
	private String fileDisplayPrefix;

	@Override
	@Transactional
	public void addUser(UserRequest userRequest) {
		User user = new User(userRequest.getName(), userRequest.getAccount(), userRequest.getPassword(), userRequest.getDeptid(),
				userRequest.getContact(), userRequest.getAvatar(), userRequest.getUsertype(), userRequest.getSex(), userRequest.getPhone());
		int uid = this.userDao.addUser(user);
		int[] roleIds = userRequest.getRoleIds();
		this.updateUserRoleList(uid, roleIds);
	}
	
	private void updateUserRoleList(int uid, int[] roleIds) {
		if(roleIds != null && roleIds.length > 0) {
			List<UserRole> userRoles = Lists.newArrayList();
			for(int rid : roleIds) {
				UserRole userRole = new UserRole(uid, rid);
				userRoles.add(userRole);
			}
			this.userRoleDao.delByUid(uid);
			this.userRoleDao.batchInsert(userRoles);
		}
	}

	@Override
	public UserResponse login(UserRequest userRequest) {
		String account = userRequest.getAccount();
		String password = userRequest.getPassword();
		
		User user = this.userDao.getUserByAccountPassword(account, password);
		if(user == null) {
			return null;
		}
		
		UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getAccount(), user.getDeptid(), user.getContact(), 
				user.getAvatar(), user.getUsertype(), user.getSex(), user.getPhone(), user.getCreateTime());
		
		List<Integer> roleIds = this.userRoleDao.getRoleIdsByUid(user.getId());
		if(CollectionUtils.isNotEmpty(roleIds)) {
			userResponse.setRoleIds(roleIds);
		}
		return userResponse;
	}

	@Override
	public UserRolesPermissionsVo getUserRolesPermissions(int id) {
		return this.userDao.getUserRolesPermissions(id);
	}

	@Override
	public PageInfo<UserResponse> getUsers(UserRequest userRequest) {
		
		String uname = userRequest.getName();
		//如果是部门id查询，需要找到所有子部门的id
		int deptid = userRequest.getDeptid();
		List<Department> allDepts = this.deptDao.getDepartment(null);
		List<Integer> deptIds = Lists.newArrayList();
		if(deptid > 0 && CollectionUtils.isNotEmpty(allDepts)) {
			Map<Integer, List<Department>> deptsMap = allDepts.stream().collect(Collectors.groupingBy(Department::getPid));
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(deptid);
			while(!stack.isEmpty()) {
				int deptId = stack.pop();
				deptIds.add(deptId);
				List<Department> children = deptsMap.get(deptId);
				if(CollectionUtils.isNotEmpty(children)) {
					children.stream().forEach(e -> stack.push(e.getId()));
				}
			}
		}
		
		
		int pageSize = userRequest.getPageSize();
		int pageNum = userRequest.getPageNum();
		
		PageHelper.startPage(pageNum, pageSize, true);
		List<User> userList = this.userDao.getUsers(uname, deptIds);
		
		if(CollectionUtils.isNotEmpty(userList)) {
			List<Integer> userIds = userList.stream().map(user -> user.getId()).collect(Collectors.toList());
			List<UserRole> userRoles = this.userRoleDao.getRoleIdsByUids(userIds);
			Map<Integer, List<UserRole>> userRoleMap = userRoles.stream().collect(Collectors.groupingBy(UserRole::getUid));
			Map<Integer, Department> idNameDepts = allDepts.stream().collect(Collectors.toMap(Department::getId, dept -> dept));
			List<UserResponse> userResponses = userList.stream()
					.map(user -> {
						int deptId = user.getDeptid();
						String level2dept = this.level2dept(deptId, idNameDepts);
						UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getAccount(), user.getDeptid(), user.getContact(), level2dept,
								user.getAvatar(), user.getUsertype(), user.getSex(), user.getPhone(), user.getCreateTime());
						List<UserRole> userRoleList = userRoleMap.get(user.getId());
						if(CollectionUtils.isNotEmpty(userRoleList)) {
							List<Integer> roleIds = userRoleList.stream().map(item -> item.getRid()).collect(Collectors.toList());
							userResponse.setRoleIds(roleIds);
						}
						return userResponse;
					}).collect(Collectors.toList());
			PageInfo<UserResponse> userPageInfo = new PageInfo<UserResponse>(userResponses);
			return userPageInfo;
		}
		return null;
	}

	@Override
	@Transactional
	public void updateUser(UserRequest userRequest) {
		int uid = userRequest.getId();
		this.userDao.updateUser(userRequest);
		int[] roleIds = userRequest.getRoleIds();
		if(ArrayUtils.isNotEmpty(roleIds)) {
			this.updateUserRoleList(uid, roleIds);
		}
	}

	@Override
	public void delUsers(int[] userIds) {
		if(userIds != null && userIds.length > 0) {
			List<Integer> uids = Lists.newArrayList();
			for(int userId : userIds) {
				uids.add(userId);
			}
			this.userDao.delUsers(uids);
		}
	}

	@Override
	public UserResponse getUserByUid(int uid) {
		User user = this.userDao.getUserByUid(uid);
		int deptId = user.getDeptid();
		String level2dept = "";
		//获取部门信息
		List<Department> allDepts = this.deptDao.getDepartment(null);
		if(CollectionUtils.isNotEmpty(allDepts)) {
			Map<Integer, Department> idNameDepts = allDepts.stream().collect(Collectors.toMap(Department::getId, dept -> dept));
			level2dept = this.level2dept(deptId, idNameDepts);
		}
		UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getAccount(), user.getDeptid(), 
				user.getContact(), level2dept, user.getAvatar(), user.getUsertype(), user.getSex(), user.getPhone(), user.getCreateTime());
		return userResponse;
	}

	@Override
	public String uploadAvatar(int uid, MultipartFile avatarFile) {
		try {
			String fileName = avatarFile.getOriginalFilename();
			String basePath = System.getProperty("user.dir") + "/static/avatar";
			FileUtils.uploadFile(avatarFile, basePath);
			String savePath = this.fileDisplayPrefix + "/avatar/" + fileName;
			this.userDao.updateAvatar(savePath, uid);
			return savePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MessageCode updatePwd(UserPwdUpdateReq userPwdUpdateReq) {
		int uid = userPwdUpdateReq.getUid();
		User user = this.userDao.getUserByUid(uid);
		String oldPwd = userPwdUpdateReq.getOldPassword();
		if(!user.getPassword().equals(oldPwd)) {
			return new MessageCode(Message.OLDPWDERROR.getCode(), Message.OLDPWDERROR.getMsg());
		}
		this.userDao.updatePwd(uid, userPwdUpdateReq.getNewPassword());
		return new MessageCode(Message.UPDATEPWDSUCCESS.getCode(), Message.UPDATEPWDSUCCESS.getMsg());
	}
	
	@Override
	public List<UserResponse> getUsers() {
		List<User> users = this.userDao.getUsers(null, null);
		//获取部门信息
		List<Department> depts = this.deptDao.getDepartment(null);
		
		if(CollectionUtils.isNotEmpty(users) && CollectionUtils.isNotEmpty(depts)) {
			Map<Integer, Department> idNameDepts = depts.stream().collect(Collectors.toMap(Department::getId, dept -> dept));
			return users.stream().map(user -> {
				int deptid = user.getDeptid();
				String level2dept = this.level2dept(deptid, idNameDepts);
				return new UserResponse(user.getId(), user.getName(), level2dept);
			}).collect(Collectors.toList());
		}
		return null;
	}
	
	public String level2dept(int deptid, Map<Integer, Department> idNameDepts) {
		Department childDept = idNameDepts.get(deptid);
		String level2dept = childDept.getName();
		int fid = childDept.getPid();
		if(fid > 0) {
			Department fatherDept = idNameDepts.get(fid);
			level2dept = fatherDept.getName() + " / " + level2dept;
		}
		return level2dept;
	}

}
