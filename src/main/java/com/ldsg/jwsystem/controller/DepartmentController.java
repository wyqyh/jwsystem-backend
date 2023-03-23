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

import com.ldsg.jwsystem.request.DeptRequest;
import com.ldsg.jwsystem.response.DeptResponse;
import com.ldsg.jwsystem.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;

	@PostMapping("/add")
	public void addDept(@RequestBody DeptRequest deptRequest) {
		this.deptService.addDept(deptRequest);
	}
	
	@PostMapping("/update")
	public void updateDept(@RequestBody DeptRequest deptRequest) {
		this.deptService.updateDept(deptRequest);
	}
	
	@GetMapping("/delete/{deptId}")
	public void deleteDept(@PathVariable("deptId") int deptId) {
		this.deptService.deleteDept(deptId);
	}
	
	@PostMapping("/get")
	public List<DeptResponse> getDepartments(@RequestParam(required = false) String deptname) {
		return this.deptService.getDepartments(deptname);
	}
}
