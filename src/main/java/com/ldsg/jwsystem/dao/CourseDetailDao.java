package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.CourseDetail;
import com.ldsg.jwsystem.request.PageCourseDetailReq;
import com.ldsg.jwsystem.vo.CourseDetailVo;

public interface CourseDetailDao {

	public List<CourseDetailVo> findAllDetailBySksj(@Param("teachdate") String teachdate, @Param("teachsessid") int teachsessid);

	public void addCourseDetail(CourseDetail courseDetail);

	public List<CourseDetailVo> listCourseDetail(PageCourseDetailReq pageCourseDetailReq);

}
