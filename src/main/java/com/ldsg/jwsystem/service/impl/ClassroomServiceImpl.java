package com.ldsg.jwsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.dao.ClassroomDao;
import com.ldsg.jwsystem.request.ClassroomRequest;
import com.ldsg.jwsystem.response.ClassroomResponse;
import com.ldsg.jwsystem.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	@Autowired
	private ClassroomDao classroomDao;
	
	@Override
	public void addClassroom(ClassroomRequest classroom) {
		this.classroomDao.insert(classroom);
	}

	@Override
	public PageInfo<ClassroomResponse> pageGet(ClassroomRequest classroomRequest) {
		
		String location = classroomRequest.getLocation();
		
		int pageNum = classroomRequest.getPageNum();
		int pageSize = classroomRequest.getPageSize();
		
		PageHelper.startPage(pageNum, pageSize, true);
		List<ClassroomResponse> classrooms = this.classroomDao.getAll(location);
		
		PageInfo<ClassroomResponse> pageClassroom = new PageInfo<ClassroomResponse>(classrooms);
		pageClassroom.setPageSize(pageSize);
		pageClassroom.setPageNum(pageNum);
		
		return pageClassroom;
	}

	@Override
	public void updateClassroom(ClassroomRequest classroom) {
		this.classroomDao.updateClassroom(classroom);
	}

	@Override
	public void deleteClassroom(List<Integer> ids) {
		this.classroomDao.deleteByIds(ids);
	}

}
