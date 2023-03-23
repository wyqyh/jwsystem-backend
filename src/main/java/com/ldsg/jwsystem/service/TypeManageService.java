package com.ldsg.jwsystem.service;

import java.util.List;
import java.util.Map;

import com.ldsg.jwsystem.entity.TypeManage;
import com.ldsg.jwsystem.response.TypeDataResponse;

public interface TypeManageService {

	public List<TypeManage> getAllType();

	public void addType(String no, String name);

	public void deleteTypeByIds(List<Integer> typeids);

	public List<TypeDataResponse> getTypeDataBytypeid(List<Integer> typeIds);
	
	public void addTypeData(int typeid, String typeno, String name);

	public void deleteTypeDataByIds(List<Integer> ids);

	public void updateTypeData(int dataid, int typeid, String typeno, String name);

	public List<TypeDataResponse> getDataByTypeno(String typeno);

	public Map<String, List<TypeDataResponse>> getDataByTypenos(List<String> typeNos);
}
