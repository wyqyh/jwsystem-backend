package com.ldsg.jwsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.ldsg.jwsystem.entity.Student;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.StudentRequest;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.service.StudentService;
import com.ldsg.jwsystem.utils.XssfUtils;

@RestController
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    /**
     * 导出学生信息模板模板
     */
    @GetMapping("/export/xlsmodel")
    public void exportXlsModel(HttpServletResponse response, HttpServletRequest request) throws Exception {
        XssfUtils xfu = new XssfUtils();
        xfu.exportXlsModel(request, response);
    }
    
    @PostMapping("/upload")
    public MessageCode uploadStuinfoXls(@RequestParam("stuinfo") MultipartFile studeInfoXls,
    		@RequestParam("classid") int classid) {
    	if (studeInfoXls == null || studeInfoXls.getSize() == 0) {
            return new MessageCode(Message.FILEERROR.getCode(), Message.FILEERROR.getMsg());
        }
        String filename = studeInfoXls.getOriginalFilename();
        if (!(filename.endsWith(".xls") || filename.endsWith(".xlsx"))){
            return new MessageCode(Message.FILETYPEWRONG.getCode(), Message.FILETYPEWRONG.getMsg());
        }
    	return this.studentService.uploadStuinfo(studeInfoXls, classid);
    }
    
    @PostMapping("/list")
    public PageInfo<Student> pageGetStudent(@RequestBody StudentRequest studentRequest) {
    	return this.studentService.pageGetStudent(studentRequest);
    }
}
