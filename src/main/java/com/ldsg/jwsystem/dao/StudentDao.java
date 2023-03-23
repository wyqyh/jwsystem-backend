package com.ldsg.jwsystem.dao;

import java.util.List;

import com.ldsg.jwsystem.entity.Student;
import com.ldsg.jwsystem.request.StudentRequest;

public interface StudentDao {

	public void batchAddStus(List<Student> stus);

	public List<Student> listStudent(StudentRequest studentRequest);
}
