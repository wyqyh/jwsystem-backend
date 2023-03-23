package com.ldsg.jwsystem.response;

import java.util.List;

import com.ldsg.jwsystem.vo.CourseDetailVo;

public class CourseDetailResponse extends MessageCode {

	private List<CourseDetailVo> courseDetailVos;

	public List<CourseDetailVo> getCourseDetailVos() {
		return courseDetailVos;
	}

	public void setCourseDetailVos(List<CourseDetailVo> courseDetailVos) {
		this.courseDetailVos = courseDetailVos;
	}
}
