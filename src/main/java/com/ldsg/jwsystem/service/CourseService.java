package com.ldsg.jwsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.CourseRequest;
import com.ldsg.jwsystem.request.PageCourseRequest;
import com.ldsg.jwsystem.response.CourseResponse;
import com.ldsg.jwsystem.response.MessageCode;

public interface CourseService {

	public PageInfo<CourseResponse> listCourse(PageCourseRequest pageCourseRequest);

	public List<CourseResponse> getCoursename();

	public MessageCode addCourse(CourseRequest courseRequest);

}
