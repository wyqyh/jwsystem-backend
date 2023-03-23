package com.ldsg.jwsystem.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.request.ClassRequest;
import com.ldsg.jwsystem.request.PageClassRequest;
import com.ldsg.jwsystem.response.ClassResponse;
import com.ldsg.jwsystem.response.MessageCode;

public interface ClassService {

	public List<String> getClassno();

	public MessageCode addClass(ClassRequest classRequest);

	public PageInfo<ClassResponse> pageListClass(PageClassRequest pageClassRequest);

	public MessageCode updateClass(ClassRequest classRequest);

	public void deleteClass(List<Integer> delClassIds);

	public ClassResponse getClassById(int cid);

}
