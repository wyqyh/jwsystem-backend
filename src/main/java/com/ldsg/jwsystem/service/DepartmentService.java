package com.ldsg.jwsystem.service;

import java.util.List;

import com.ldsg.jwsystem.request.DeptRequest;
import com.ldsg.jwsystem.response.DeptResponse;

public interface DepartmentService {

	void addDept(DeptRequest deptRequest);

	void updateDept(DeptRequest deptRequest);

	void deleteDept(int deptId);

	List<DeptResponse> getDepartments(String deptName);

}
