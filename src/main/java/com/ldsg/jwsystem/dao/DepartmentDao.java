package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.Department;

public interface DepartmentDao {
	
	public String getDeptnameById(@Param("id") int id);
	
	public Department getDeptById(@Param("id") int id);

	public void insertDept(Department dept);

	public void updateDept(Department dept);
	
	public void deleteDept(@Param("deptId") int deptId);
	
	public void delDepts(List<Integer> deptIds);
	
	public List<Department> getDepartment(@Param("deptName") String deptName);
}
