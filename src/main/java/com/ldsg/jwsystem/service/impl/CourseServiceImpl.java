package com.ldsg.jwsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.CourseDao;
import com.ldsg.jwsystem.dao.TypeDataDao;
import com.ldsg.jwsystem.entity.Course;
import com.ldsg.jwsystem.entity.TypeData;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.CourseRequest;
import com.ldsg.jwsystem.request.PageCourseRequest;
import com.ldsg.jwsystem.response.CourseResponse;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.response.UserResponse;
import com.ldsg.jwsystem.service.CourseService;
import com.ldsg.jwsystem.service.UserService;
import com.ldsg.jwsystem.utils.Constant;
import com.ldsg.jwsystem.vo.CourseVo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private TypeDataDao typeDataDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public PageInfo<CourseResponse> listCourse(PageCourseRequest pageCourseRequest) {
		List<CourseResponse> courses = Lists.newArrayList();
		int pagenum = pageCourseRequest.getPagenum();
		int pagesize = pageCourseRequest.getPagesize();
		
		PageHelper.startPage(pagenum, pagesize, true);
		List<CourseVo> courseVos = this.courseDao.pageGetCourses(pageCourseRequest);
		List<TypeData> typeDatas = this.typeDataDao.listTypeData();
		List<UserResponse> users = this.userService.getUsers();
		if(CollectionUtils.isNotEmpty(courseVos) && CollectionUtils.isNotEmpty(typeDatas) && CollectionUtils.isNotEmpty((users))) {
			Map<Integer, String> idNameTypeMap = typeDatas.stream().collect(Collectors.toMap(TypeData::getId, TypeData::getName));
			courses = courseVos.stream().map(course -> {
				CourseResponse courseResp = this.transCourse(course, idNameTypeMap, users);
				return courseResp;
			}).collect(Collectors.toList());
		}
		PageInfo<CourseResponse> pageCourses = new PageInfo<CourseResponse>(courses);
		pageCourses.setPageNum(pagenum);
		pageCourses.setPageSize(pagesize);
		return pageCourses;
	}

	private CourseResponse transCourse(CourseVo course, Map<Integer, String> idNameTypeMap, List<UserResponse> users) {
		int termid = course.getTermid();
		String termname = idNameTypeMap.get(termid);
		int majorid = course.getMajorid();
		String majorname = idNameTypeMap.get(majorid);
		int deptid = course.getDeptid();
		String deptname = idNameTypeMap.get(deptid);
		int trainlevelid = course.getTrainlevelid();
		String trainlevel = idNameTypeMap.get(trainlevelid);
		int tasktypeid = course.getTasktypeid();
		String tasktype = idNameTypeMap.get(tasktypeid);
		int practicetypeid = course.getPracticetype();
		String practicetype = idNameTypeMap.get(practicetypeid);
		String prime = "主讲";
		int primeid = course.getPrime();
		if(primeid == 0) {
			prime = "辅讲";
		} else if(primeid == 2) {
			prime = "主讲，辅讲";
		}
		String teacherids = course.getTeacherid();
		List<UserResponse> teachIdNames = this.getTeacherInfo(teacherids, users);
		String teachername = StringUtils
				.join(teachIdNames.stream().map(teach -> teach.getName()).collect(Collectors.toList()), Constant.COMMA);
		return new CourseResponse(course.getId(), course.getClassid(), course.getClassno(), termname, trainlevel,
				course.getCoursename(), majorname, course.getStunum(), deptname, tasktype, practicetype,
				course.getTheroyhour(), course.getPracticehour(), prime, course.getBatchcoeff(), teachername,
				teachIdNames, course.getCreateTime());
	}

	private List<UserResponse> getTeacherInfo(String teacherids, List<UserResponse> users) {
		List<String> teachIds = Stream.of(teacherids.split(Constant.COMMA)).collect(Collectors.toList());
		List<UserResponse> res = users.stream().filter(user -> teachIds.contains(String.valueOf(user.getId())))
				.collect(Collectors.toList());
		return res;
	}

	@Override
	public List<CourseResponse> getCoursename() {
		return this.courseDao.getCoursename();
	}

	@Override
	public MessageCode addCourse(CourseRequest courseRequest) {
		//判断该期班是否存在同名课程
		int classid = courseRequest.getClassid();
		List<Course> courses = this.courseDao.getCourseByClassid(classid);
		
		String coursename = StringUtils.deleteWhitespace(courseRequest.getCoursename());
		if(CollectionUtils.isNotEmpty(courses)) {
			List<String> coursenames = courses.stream()
					.map(course -> StringUtils.deleteWhitespace(course.getCoursename())).collect(Collectors.toList());
			if(coursenames.contains(coursename)) {
				return new MessageCode(Message.COURSENAMEEXISTENCE.getCode(), Message.COURSENAMEEXISTENCE.getMsg());
			}
		}
		
		String teacherid = StringUtils.join(courseRequest.getTeacherids(), Constant.COMMA);
		Course course = new Course(classid, coursename, courseRequest.getPracticetype(), courseRequest.getTheroyhour(),
				courseRequest.getPracticehour(), courseRequest.getPrime(), courseRequest.getBatchcoeff(), teacherid);

		this.courseDao.addCourse(course);
		return new MessageCode(Message.COURSEADDSUCCESS.getCode(), Message.COURSEADDSUCCESS.getMsg());
	}

	
}
