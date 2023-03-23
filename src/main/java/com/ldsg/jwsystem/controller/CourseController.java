package com.ldsg.jwsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.CourseRequest;
import com.ldsg.jwsystem.request.PageCourseRequest;
import com.ldsg.jwsystem.response.CourseResponse;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/list")
	public PageInfo<CourseResponse> listCourse(@RequestBody PageCourseRequest pageCourseRequest) {
		return this.courseService.listCourse(pageCourseRequest);
	}
	
	@GetMapping("/name")
	public List<CourseResponse> getCoursename() {
		return this.courseService.getCoursename();
	}
	
	@PostMapping("/add")
	public MessageCode addCourse(@RequestBody CourseRequest courseRequest) {
		return this.courseService.addCourse(courseRequest);
	}
}
