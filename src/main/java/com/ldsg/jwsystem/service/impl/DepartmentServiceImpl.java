package com.ldsg.jwsystem.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.DepartmentDao;
import com.ldsg.jwsystem.dao.UserDao;
import com.ldsg.jwsystem.entity.Department;
import com.ldsg.jwsystem.request.DeptRequest;
import com.ldsg.jwsystem.response.DeptResponse;
import com.ldsg.jwsystem.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DepartmentDao deptDao;
	

	@Override
	public void addDept(DeptRequest deptRequest) {
		Department dept = new Department(deptRequest.getFatherId(), deptRequest.getDeptName(), deptRequest.getCharger(), deptRequest.getTel());
		this.deptDao.insertDept(dept);
	}

	@Override
	public void updateDept(DeptRequest deptRequest) {
		Department dept = new Department(deptRequest.getDeptId(), deptRequest.getFatherId(), deptRequest.getDeptName(), deptRequest.getCharger(), deptRequest.getTel());
		this.deptDao.updateDept(dept);
	}

	@Override
	@Transactional
	public void deleteDept(int deptId) {
		//查询所有
		List<Department> departments = this.deptDao.getDepartment(null);
		Department department = this.deptDao.getDeptById(deptId);
		
		if(department != null && CollectionUtils.isNotEmpty(departments)) {
			List<Integer> delDeptIds = Lists.newArrayList();
			// <fid, children>
			Map<Integer, List<Department>> deptMaps = departments.stream().collect(Collectors.groupingBy(Department::getPid));
			Stack<Department> stack = new Stack<Department>();
			stack.push(department);
			
			while(!stack.isEmpty()) {
				Department dept = stack.pop();
				int id = dept.getId();
				delDeptIds.add(id);
				
				List<Department> children = deptMaps.get(id);
				if(CollectionUtils.isNotEmpty(children)) {
					children.stream().forEach(e -> stack.push(e));
				}
			}
			
			if(CollectionUtils.isNotEmpty(delDeptIds)) {
				this.deptDao.delDepts(delDeptIds);
				this.userDao.setDeptNull(deptId);
			}
		}
	}

	@Override
	public List<DeptResponse> getDepartments(String deptName) {
		
		List<Department> deptAll = this.deptDao.getDepartment(deptName);
		if(CollectionUtils.isNotEmpty(deptAll)) {
			return this.trans2tree(deptAll);
		}
		return null;
	}

	private List<DeptResponse> trans2tree(List<Department> deptAll) {
		List<DeptResponse> deptRes = deptAll.stream().map(dept -> new DeptResponse(dept.getId(), dept.getPid(), 
				dept.getName(), dept.getCharger(), dept.getTel())).collect(Collectors.toList());
		
		Map<Integer, List<DeptResponse>> deptResponseMap = deptRes.stream().collect(Collectors.groupingBy(DeptResponse::getPid));
		
		int minPid = deptRes.stream().min(Comparator.comparing(DeptResponse::getPid)).get().getPid();
		
		List<DeptResponse> rootDept = deptRes.stream().filter(dept -> dept.getPid() == minPid).collect(Collectors.toList());
		Stack<DeptResponse> stack = new Stack<DeptResponse>();
		rootDept.stream().forEach(e -> stack.push(e));
		
		while(!stack.isEmpty()) {
			DeptResponse dept = stack.pop();
			List<DeptResponse> children = deptResponseMap.get(dept.getId());
			if(CollectionUtils.isNotEmpty(children)) {
				dept.setChildren(children);
				children.stream().forEach(e -> stack.push(e));
			}
			
		}
		
		return rootDept;
	}

}
