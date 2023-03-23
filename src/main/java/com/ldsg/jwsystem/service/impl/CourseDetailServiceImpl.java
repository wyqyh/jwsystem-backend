package com.ldsg.jwsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.CourseDetailDao;
import com.ldsg.jwsystem.dao.TypeDataDao;
import com.ldsg.jwsystem.entity.CourseDetail;
import com.ldsg.jwsystem.entity.TypeData;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.CourseDetailRequest;
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
		String teachdate = courseDetailRequest.getTeachdate();
		int teachsessid = courseDetailRequest.getTeachsessid();
		//1.根据授课日期和授课节次查询细化课表
		List<CourseDetailVo> courseDetailBySksj = this.courseDetailDao.findAllDetailBySksj(teachdate, teachsessid);
		List<TypeData> typeDatas = this.typeDataDao.listTypeData();
		//2.检查教室是否冲突，授课日期+授课节次+授课教室
		int teachlocid = courseDetailRequest.getTeachlocid();
		List<CourseDetailVo> locatConflicts = Lists.newArrayList();
		//3.检查上课时间是否冲突，授课日期+授课节次+期班号
		String classno = courseDetailRequest.getClassno();
		List<CourseDetailVo> classnoConflicts = Lists.newArrayList();
		//4.检查教员是否冲突，授课日期+授课节次+教员id
		int teacherid = courseDetailRequest.getTeacherid();
		List<CourseDetailVo> teacherConflicts = Lists.newArrayList();
		//该期班已经存在课表才进行冲突检测
		if(CollectionUtils.isNotEmpty(courseDetailBySksj) && CollectionUtils.isNotEmpty(typeDatas)) {
			fillNameInfo(courseDetailBySksj, typeDatas);
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
			//存在冲突
			if(CollectionUtils.isNotEmpty(conflictDetail)) {
				response.setCode(Message.DETAILCOURSECONFLICT.getCode());
				response.setMessage(Message.DETAILCOURSECONFLICT.getMsg());
				response.setCourseDetailVos(conflictDetail);
				return response;
			} 
		}
		CourseDetail courseDetail = new CourseDetail(courseDetailRequest.getCourseid(), teacherid, courseDetailRequest.getPrime(), 
				courseDetailRequest.getTeachtypeid(), teachdate, teachlocid, teachsessid, courseDetailRequest.getTeachcontent());
		this.courseDetailDao.addCourseDetail(courseDetail);
		response.setCode(Message.DETAILCOURSEADDSUCCESS.getCode());
		response.setMessage(Message.DETAILCOURSEADDSUCCESS.getMsg());
		return response;
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
