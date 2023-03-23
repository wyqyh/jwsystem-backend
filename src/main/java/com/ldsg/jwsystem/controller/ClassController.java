package com.ldsg.jwsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.ClassRequest;
import com.ldsg.jwsystem.request.PageClassRequest;
import com.ldsg.jwsystem.response.ClassResponse;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.service.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@GetMapping("/get/classno")
	public List<String> getClassno() {
		return this.classService.getClassno();
	}
	
	@GetMapping("/get/{cid}")
	public ClassResponse getClassById(@PathVariable("cid") int cid) {
		return this.classService.getClassById(cid);
	}
	
	@PostMapping("/add")
	public MessageCode addClass(@RequestBody ClassRequest classRequest) {
		return this.classService.addClass(classRequest);
	}
	
	@PostMapping("/list")
	public PageInfo<ClassResponse> pageListClass(@RequestBody PageClassRequest pageClassRequest) {
		return this.classService.pageListClass(pageClassRequest);
	}
	
	@PostMapping("/update")
	public MessageCode updateClass(@RequestBody ClassRequest classRequest) {
		return this.classService.updateClass(classRequest);
	}
	
	@PostMapping("/delete")
	public void deleteClass(@RequestBody List<Integer> delClassIds) {
		this.classService.deleteClass(delClassIds);
	}
}
