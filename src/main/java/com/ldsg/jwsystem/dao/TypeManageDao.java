package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.TypeManage;

public interface TypeManageDao {
	
	public void insert(@Param("no") String no, @Param("name") String name);
	
	public List<TypeManage> getAll();
	
	public void deleteByIds(List<Integer> id);
}
