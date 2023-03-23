package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.Course;
import com.ldsg.jwsystem.request.PageCourseRequest;
import com.ldsg.jwsystem.response.CourseResponse;
import com.ldsg.jwsystem.vo.CourseVo;

public interface CourseDao {

	public List<CourseVo> pageGetCourses(PageCourseRequest pageCourseRequest);

	public List<CourseResponse> getCoursename();

	public void addCourse(Course course);
	
	public List<Course> getCourseByClassid(@Param("classid") int classid);

}
