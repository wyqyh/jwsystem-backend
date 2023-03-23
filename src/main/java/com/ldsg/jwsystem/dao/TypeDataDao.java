package com.ldsg.jwsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldsg.jwsystem.entity.TypeData;
import com.ldsg.jwsystem.response.TypeDataResponse;

public interface TypeDataDao {

	public void insert(TypeData typeData);
	
	public List<TypeDataResponse> getByTypeids(List<Integer> typeids);
	
	public void deleteByIds(List<Integer> ids);

	public void updateTypeData(@Param("dataid") int dataid, @Param("typeid") int typeid, 
			@Param("typeno") String typeno, @Param("name") String name);

	public List<TypeDataResponse> getDataByTypeno(@Param("typeno") String typeno);

	public List<TypeDataResponse> getDataByTypenos(List<String> typenos);
	
	public List<TypeData> listTypeData();
}
