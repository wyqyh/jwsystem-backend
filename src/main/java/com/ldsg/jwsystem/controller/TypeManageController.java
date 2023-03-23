package com.ldsg.jwsystem.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.ldsg.jwsystem.entity.TypeManage;
import com.ldsg.jwsystem.response.TypeDataResponse;
import com.ldsg.jwsystem.service.TypeManageService;

@RestController
@RequestMapping("/type")
public class TypeManageController {

	@Autowired
	private TypeManageService typeManageService;
	
	@GetMapping("/get")
	public List<TypeManage> getAllType() {
		return this.typeManageService.getAllType();
	}
	
	@PostMapping("/add")
	public void add(@RequestParam("typeno") String no, @RequestParam("name") String name) {
		this.typeManageService.addType(no, name);
	}
	
	@PostMapping("/delete")
	public void deleteTypeByIds(@RequestBody int[] ids) {
		if(ArrayUtils.isNotEmpty(ids)) {
			List<Integer> typeids = Arrays.stream(ids).boxed().collect(Collectors.toList());
			this.typeManageService.deleteTypeByIds(typeids);
		}
	}
	
	@PostMapping("/data/get")
	public List<TypeDataResponse> getTypeDataBytypeid(@RequestBody int[] typeids) {
		List<Integer> typeIds = Lists.newArrayList();
		if(ArrayUtils.isNotEmpty(typeids)) {
			typeIds = Arrays.stream(typeids).boxed().collect(Collectors.toList());
		}
		return this.typeManageService.getTypeDataBytypeid(typeIds);
	}
	
	@PostMapping("/data/get/typeno")
	public List<TypeDataResponse> getDataByTypeno(@RequestParam("typeno") String typeno) {
		return this.typeManageService.getDataByTypeno(typeno);
	}
	
	@PostMapping("/data/get/typenos")
	public Map<String, List<TypeDataResponse>> getDataByTypenos(@RequestBody String[] typenos) {
		List<String> typeNos = Lists.newArrayList();
		if(ArrayUtils.isNotEmpty(typenos)) {
			typeNos = Stream.of(typenos).collect(Collectors.toList());
		}
		return this.typeManageService.getDataByTypenos(typeNos);
	}
	
	@PostMapping("/data/add")
	public void addTypeData(@RequestParam("typeid") int typeid, @RequestParam("typeno") String typeno, 
			@RequestParam("name") String name) {
		this.typeManageService.addTypeData(typeid, typeno, name);
	}
	
	@PostMapping("/data/update")
	public void updateTypeData(@RequestParam("dataid") int dataid, @RequestParam("typeid") int typeid, 
			@RequestParam("typeno") String typeno, @RequestParam("name") String name) {
		this.typeManageService.updateTypeData(dataid, typeid, typeno, name);
	}
	
	@PostMapping("/data/del")
	public void delTypeDataByIds(@RequestBody int[] ids) {
		if(ArrayUtils.isNotEmpty(ids)) {
			List<Integer> idList = Arrays.stream(ids).boxed().collect(Collectors.toList());
			this.typeManageService.deleteTypeDataByIds(idList);
		}
	}
}
