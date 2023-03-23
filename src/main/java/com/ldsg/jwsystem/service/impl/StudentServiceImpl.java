package com.ldsg.jwsystem.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.StudentDao;
import com.ldsg.jwsystem.entity.Student;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.StudentRequest;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.service.StudentService;
import com.ldsg.jwsystem.utils.XssfUtils;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public MessageCode uploadStuinfo(MultipartFile studeInfoXls, int classid) {
		String filename = studeInfoXls.getOriginalFilename();
		try {
			List<Student> students = Lists.newArrayList();
			XssfUtils xssfUtils = new XssfUtils();
            if (filename.endsWith(".xls")){
            	students = xssfUtils.readXLS(studeInfoXls, classid);
            }else {
            	students = xssfUtils.readXLSX(studeInfoXls, classid);
            }
            this.studentDao.batchAddStus(students);
        } catch (IOException e) {
            e.printStackTrace();
            return new MessageCode(Message.FILEUPLOADFAILURE.getCode(), Message.FILEUPLOADFAILURE.getMsg());
        }
		return new MessageCode(Message.FILEUPLOADSUCCESS.getCode(), Message.FILEUPLOADSUCCESS.getMsg());
	}

	@Override
	public PageInfo<Student> pageGetStudent(StudentRequest studentRequest) {
		
		int pagenum = studentRequest.getPageNum();
		int pagesize = studentRequest.getPageSize();
		
		PageHelper.startPage(pagenum, pagesize, true);
		List<Student> students = this.studentDao.listStudent(studentRequest);
		
		PageInfo<Student> pageStus = new PageInfo<Student>(students);
		pageStus.setPageNum(pagenum);
		pageStus.setPageSize(pagesize);
		return pageStus;
	}
}
