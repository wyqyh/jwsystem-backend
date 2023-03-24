package com.ldsg.jwsystem.service;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.CourseDetailRequest;
import com.ldsg.jwsystem.request.PageCourseDetailReq;
import com.ldsg.jwsystem.response.CourseDetailResponse;
import com.ldsg.jwsystem.vo.CourseDetailVo;

public interface CourseDetailService {

	public CourseDetailResponse addCourseDetail(CourseDetailRequest courseDetailRequest);

	public PageInfo<CourseDetailVo> pageCourseDetail(PageCourseDetailReq pageCourseDetailReq);

}
