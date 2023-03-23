package com.ldsg.jwsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.ClassroomRequest;
import com.ldsg.jwsystem.response.ClassroomResponse;

public interface ClassroomService {

	void addClassroom(ClassroomRequest classroom);

	PageInfo<ClassroomResponse> pageGet(ClassroomRequest classroomRequest);

	void updateClassroom(ClassroomRequest classroom);

	void deleteClassroom(List<Integer> roomIds);

}
