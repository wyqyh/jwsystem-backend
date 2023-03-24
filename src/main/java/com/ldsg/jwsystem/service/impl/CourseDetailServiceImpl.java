package com.ldsg.jwsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.CourseDetailDao;
import com.ldsg.jwsystem.dao.TypeDataDao;
import com.ldsg.jwsystem.entity.CourseDetail;
import com.ldsg.jwsystem.entity.TypeData;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.CourseDetailRequest;
import com.ldsg.jwsystem.request.PageCourseDetailReq;
import com.ldsg.jwsystem.response.CourseDetailResponse;
import com.ldsg.jwsystem.service.CourseDetailService;
import com.ldsg.jwsystem.vo.CourseDetailVo;

@Service
@SuppressWarnings("unchecked")
public class CourseDetailServiceImpl implements CourseDetailService {
	
	@Autowired
	private CourseDetailDao courseDetailDao;
	
	@Autowired
	private TypeDataDao typeDataDao;

	@Override
	public CourseDetailResponse addCourseDetail(CourseDetailRequest courseDetailRequest) {
		CourseDetailResponse response = new CourseDetailResponse();
		List<TypeData> typeDatas = this.typeDataDao.listTypeData();
		//冲突检测
		List<CourseDetailVo> conflictDetail = this.checkConflict(courseDetailRequest);
		// 存在冲突
		if(CollectionUtils.isNotEmpty(conflictDetail) && CollectionUtils.isNotEmpty(typeDatas)) {
			fillNameInfo(conflictDetail, typeDatas);
			response.setCode(Message.DETAILCOURSECONFLICT.getCode());
			response.setMessage(Message.DETAILCOURSECONFLICT.getMsg());
			response.setCourseDetailVos(conflictDetail);
			return response;
		}
		//添加细化课表
		CourseDetail courseDetail = new CourseDetail(courseDetailRequest.getCourseid(),
				courseDetailRequest.getTeacherid(), courseDetailRequest.getPrime(),
				courseDetailRequest.getTeachtypeid(), courseDetailRequest.getTeachdate(),
				courseDetailRequest.getTeachlocid(), courseDetailRequest.getTeachsessid(),
				courseDetailRequest.getTeachcontent(), courseDetailRequest.getCreaterid());
		this.courseDetailDao.addCourseDetail(courseDetail);
		//细化课表添加成功则获取当前用户在当前期班的细化课表
		PageCourseDetailReq pageCourseDetailReq = new PageCourseDetailReq(courseDetailRequest.getTeacherid(), 
				courseDetailRequest.getClassid(), 1, 10);
		PageInfo<CourseDetailVo> pageCourseDetailVos = this.pageCourseDetail(pageCourseDetailReq);
		response.setPageCourseDetailVos(pageCourseDetailVos);
		response.setCode(Message.DETAILCOURSEADDSUCCESS.getCode());
		response.setMessage(Message.DETAILCOURSEADDSUCCESS.getMsg());
		return response;
	}
	
	@Override
	public PageInfo<CourseDetailVo> pageCourseDetail(PageCourseDetailReq pageCourseDetailReq) {
		
		int pagenum = pageCourseDetailReq.getPagenum();
		int pagesize = pageCourseDetailReq.getPagesize();
		
		PageHelper.startPage(pagenum, pagesize, true);
		List<CourseDetailVo> courseDetailVos = this.courseDetailDao.listCourseDetail(pageCourseDetailReq);
		
		List<TypeData> typeDatas = this.typeDataDao.listTypeData();
		if(CollectionUtils.isNotEmpty(courseDetailVos) && CollectionUtils.isNotEmpty(typeDatas)) {
			fillNameInfo(courseDetailVos, typeDatas);
		}
		
		PageInfo<CourseDetailVo> pageCourseDetail = new PageInfo<CourseDetailVo>(courseDetailVos);
		return pageCourseDetail;
	}

	private List<CourseDetailVo> checkConflict(CourseDetailRequest courseDetailRequest) {
		String teachdate = courseDetailRequest.getTeachdate();
		int teachsessid = courseDetailRequest.getTeachsessid();
		//1.根据授课日期和授课节次查询细化课表
		List<CourseDetailVo> courseDetailBySksj = this.courseDetailDao.findAllDetailBySksj(teachdate, teachsessid);
		if(CollectionUtils.isEmpty(courseDetailBySksj)) {
			return null;
		}
		//2.检查教室是否冲突，授课日期+授课节次+授课教室
		int teachlocid = courseDetailRequest.getTeachlocid();
		List<CourseDetailVo> locatConflicts = Lists.newArrayList();
		//3.检查上课时间是否冲突，授课日期+授课节次+期班号
		String classno = courseDetailRequest.getClassno();
		List<CourseDetailVo> classnoConflicts = Lists.newArrayList();
		//4.检查教员是否冲突，授课日期+授课节次+教员id
		int teacherid = courseDetailRequest.getTeacherid();
		List<CourseDetailVo> teacherConflicts = Lists.newArrayList();
		courseDetailBySksj.stream().forEach(courseDetail -> {
			int locateid = courseDetail.getTeachlocid();
			String clsno = courseDetail.getClassno();
			int teachid = courseDetail.getTeacherid();
			if(teachlocid == locateid) {
				locatConflicts.add(courseDetail);
			} else if(clsno.equals(classno)) {
				classnoConflicts.add(courseDetail);
			} else if(teachid == teacherid) {
				teacherConflicts.add(courseDetail);
			}
		});
		List<CourseDetailVo> conflictDetail = (List<CourseDetailVo>) CollectionUtils.union(teacherConflicts,
				CollectionUtils.union(locatConflicts, classnoConflicts));
		return conflictDetail;
	}

	private void fillNameInfo(List<CourseDetailVo> courseDetailByClassid, List<TypeData> typeDatas) {
		Map<Integer, String> idNameTypeMap = typeDatas.stream().collect(Collectors.toMap(TypeData::getId, TypeData::getName));
		courseDetailByClassid.stream().forEach(courseDetail -> {
			int termid = courseDetail.getTermid();
			String term = idNameTypeMap.get(termid);
			courseDetail.setTerm(term);
			
			int trainlevelid = courseDetail.getTrainlevelid();
			String trainlevel = idNameTypeMap.get(trainlevelid);
			courseDetail.setTrainlevel(trainlevel);
			
			int majorid = courseDetail.getMajorid();
			String majorname = idNameTypeMap.get(majorid);
			courseDetail.setMajorname(majorname);
			
			int teachlocid = courseDetail.getTeachlocid();
			String teachlocat = idNameTypeMap.get(teachlocid);
			courseDetail.setTeachlocat(teachlocat);
			
			int teachsessid = courseDetail.getTeachsessid();
			String teachsess = idNameTypeMap.get(teachsessid);
			courseDetail.setTeachsess(teachsess);
		});
	}
}
