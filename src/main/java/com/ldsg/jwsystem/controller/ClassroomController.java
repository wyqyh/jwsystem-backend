package com.ldsg.jwsystem.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.request.ClassroomRequest;
import com.ldsg.jwsystem.response.ClassroomResponse;
import com.ldsg.jwsystem.service.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;
	
	@PostMapping("/add")
	public void addClassromm(@RequestBody ClassroomRequest classroom) {
		this.classroomService.addClassroom(classroom);
	}
	
	@PostMapping("/update")
	public void updateClassroom(@RequestBody ClassroomRequest classroom) {
		this.classroomService.updateClassroom(classroom);
	}
	
	@PostMapping("/delete")
	public void deleteClassroom(@RequestBody int[] ids) {
		List<Integer> roomIds = Lists.newArrayList();
		if(ArrayUtils.isNotEmpty(ids)) {
			roomIds = Arrays.stream(ids).boxed().collect(Collectors.toList());
			this.classroomService.deleteClassroom(roomIds);
		}
	}
	
	@PostMapping("/get")
	public PageInfo<ClassroomResponse> pageGet(@RequestBody ClassroomRequest classroomRequest) {
		return this.classroomService.pageGet(classroomRequest);
	}
}
