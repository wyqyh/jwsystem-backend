package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.request.ClassroomRequest;
import com.ldsg.jwsystem.response.ClassroomResponse;

public interface ClassroomDao {

	public void insert(ClassroomRequest classroom);
	
	public List<ClassroomResponse> getAll(@Param("location") String location);

	public void updateClassroom(ClassroomRequest classroom);
	
	public void deleteByIds(List<Integer> ids);

}
