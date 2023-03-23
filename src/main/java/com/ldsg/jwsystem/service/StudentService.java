package com.ldsg.jwsystem.service;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.entity.Student;
import com.ldsg.jwsystem.request.StudentRequest;
import com.ldsg.jwsystem.response.MessageCode;

public interface StudentService {

	public MessageCode uploadStuinfo(MultipartFile studeInfoXls, int classid);

	public PageInfo<Student> pageGetStudent(StudentRequest studentRequest);

}
