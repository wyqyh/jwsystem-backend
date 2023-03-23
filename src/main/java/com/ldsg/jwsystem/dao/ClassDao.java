package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.Class;
import com.ldsg.jwsystem.request.ClassRequest;
import com.ldsg.jwsystem.request.PageClassRequest;

public interface ClassDao {

	public List<String> getClassno();

	public void addClass(ClassRequest classRequest);

	public List<Class> pageGetClass(PageClassRequest pageClassRequest);

	public Class getByClassno(@Param("classno") String classno);
	
	public Class getClassById(@Param("id") int id);

	public void updateClass(ClassRequest classRequest);

	public void deleteClass(List<Integer> delClassIds);
}
