package com.ldsg.jwsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.CourseDetailRequest;
import com.ldsg.jwsystem.request.PageCourseDetailReq;
import com.ldsg.jwsystem.response.CourseDetailResponse;
import com.ldsg.jwsystem.service.CourseDetailService;
import com.ldsg.jwsystem.vo.CourseDetailVo;

@RestController
@RequestMapping("/coursedetail")
public class CourseDetailController {

	@Autowired
	private CourseDetailService courseDetailService;
	
	@PostMapping("/add")
	public CourseDetailResponse addCourseDetail(@RequestBody CourseDetailRequest courseDetailRequest) {
		return this.courseDetailService.addCourseDetail(courseDetailRequest);
	}
	
	@PostMapping("/list")
	public PageInfo<CourseDetailVo> pageCourseDetail(@RequestBody PageCourseDetailReq pageCourseDetailReq) {
		return this.courseDetailService.pageCourseDetail(pageCourseDetailReq);
	}
}
