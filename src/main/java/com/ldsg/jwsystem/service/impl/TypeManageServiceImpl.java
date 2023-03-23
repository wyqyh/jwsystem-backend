package com.ldsg.jwsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldsg.jwsystem.dao.TypeDataDao;
import com.ldsg.jwsystem.dao.TypeManageDao;
import com.ldsg.jwsystem.entity.TypeData;
import com.ldsg.jwsystem.entity.TypeManage;
import com.ldsg.jwsystem.response.TypeDataResponse;
import com.ldsg.jwsystem.service.TypeManageService;

@Service
public class TypeManageServiceImpl implements TypeManageService {
	
	@Autowired
	private TypeManageDao typeManageDao;
	
	@Autowired
	private TypeDataDao typeDataDao;

	@Override
	public List<TypeManage> getAllType() {
		return this.typeManageDao.getAll();
	}

	@Override
	public void addType(String no, String name) {
		this.typeManageDao.insert(no, name);
	}

	@Override
	public void deleteTypeByIds(List<Integer> ids) {
		this.typeManageDao.deleteByIds(ids);
	}
	
	@Override
	public List<TypeDataResponse> getTypeDataBytypeid(List<Integer> typeIds) {
		return this.typeDataDao.getByTypeids(typeIds);
	}
	
	@Override
	public void addTypeData(int typeid, String typeno, String name) {
		TypeData typeData = new TypeData(typeid, typeno, name);
		this.typeDataDao.insert(typeData);
	}
	
	@Override
	public void deleteTypeDataByIds(List<Integer> ids) {
		this.typeDataDao.deleteByIds(ids);
	}

	@Override
	public void updateTypeData(int dataid, int typeid, String typeno, String name) {
		this.typeDataDao.updateTypeData(dataid, typeid, typeno, name);
	}

	@Override
	public List<TypeDataResponse> getDataByTypeno(String typeno) {
		return this.typeDataDao.getDataByTypeno(typeno);
	}

	@Override
	public Map<String, List<TypeDataResponse>> getDataByTypenos(List<String> typeNos) {
		List<TypeDataResponse> typeDatas = this.typeDataDao.getDataByTypenos(typeNos);
		if(CollectionUtils.isNotEmpty(typeDatas)) {
			return typeDatas.stream().collect(Collectors.groupingBy(TypeDataResponse::getTypeno));
		}
		return null;
	}
}
