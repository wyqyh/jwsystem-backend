package com.ldsg.jwsystem.response;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.vo.CourseDetailVo;

public class CourseDetailResponse extends MessageCode {

	private List<CourseDetailVo> courseDetailVos;
	private PageInfo<CourseDetailVo> pageCourseDetailVos;

	public List<CourseDetailVo> getCourseDetailVos() {
		return courseDetailVos;
	}

	public void setCourseDetailVos(List<CourseDetailVo> courseDetailVos) {
		this.courseDetailVos = courseDetailVos;
	}

	public PageInfo<CourseDetailVo> getPageCourseDetailVos() {
		return pageCourseDetailVos;
	}

	public void setPageCourseDetailVos(PageInfo<CourseDetailVo> pageCourseDetailVos) {
		this.pageCourseDetailVos = pageCourseDetailVos;
	}
}
