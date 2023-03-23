package com.ldsg.jwsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ldsg.jwsystem.dao.ClassDao;
import com.ldsg.jwsystem.dao.DepartmentDao;
import com.ldsg.jwsystem.dao.TypeDataDao;
import com.ldsg.jwsystem.entity.Class;
import com.ldsg.jwsystem.entity.Department;
import com.ldsg.jwsystem.entity.TypeData;
import com.ldsg.jwsystem.enums.Message;
import com.ldsg.jwsystem.request.ClassRequest;
import com.ldsg.jwsystem.request.PageClassRequest;
import com.ldsg.jwsystem.response.ClassResponse;
import com.ldsg.jwsystem.response.MessageCode;
import com.ldsg.jwsystem.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private ClassDao classDao;
	
	@Autowired
	private TypeDataDao typeDataDao;

	@Autowired
	private DepartmentDao deptDao;
	
	@Override
	public List<String> getClassno() {
		return classDao.getClassno();
	}

	@Override
	public MessageCode addClass(ClassRequest classRequest) {
		String classno = classRequest.getClassno();
		Class cls = this.classDao.getByClassno(classno);
		if(cls != null) {
			return new MessageCode(Message.CLASSNOEXIST.getCode(), Message.CLASSNOEXIST.getMsg());
		}
		this.classDao.addClass(classRequest);
		return new MessageCode(Message.CLASSADDSUCCESS.getCode(), Message.CLASSADDSUCCESS.getMsg());
	}

	@Override
	public PageInfo<ClassResponse> pageListClass(PageClassRequest pageClassRequest) {
		List<ClassResponse> res = Lists.newArrayList();
		int pageNum = pageClassRequest.getPagenum();
		int pageSize = pageClassRequest.getPagesize();
		
		PageHelper.startPage(pageNum, pageSize, true);
		List<Class> classes = this.classDao.pageGetClass(pageClassRequest);
		List<TypeData> typeDatas = this.typeDataDao.listTypeData();
		if(CollectionUtils.isNotEmpty(classes) && CollectionUtils.isNotEmpty(typeDatas)) {
			Map<Integer, String> idNameTypeMap = typeDatas.stream().collect(Collectors.toMap(TypeData::getId, TypeData::getName));
			res = classes.stream().map(cls -> {
				int termid = cls.getTermid();
				String termname = idNameTypeMap.get(termid);
				int deptid = cls.getDeptid();
				String deptname = getlevel2dept(deptid);
				int majorid = cls.getMajorid();
				String majorname = idNameTypeMap.get(cls.getMajorid());
				int trainlevelid = cls.getTrainlevelid();
				String trainlevel = idNameTypeMap.get(cls.getTrainlevelid());
				int tasktypeid = cls.getTasktypeid();
				String tasktype = idNameTypeMap.get(cls.getTasktypeid());
				return new ClassResponse(cls.getId(), cls.getClassno(), cls.getStunum(), termid, termname, deptid, deptname, majorid, majorname, 
						trainlevelid, trainlevel, tasktypeid, tasktype, cls.getCreateTime());
			}).collect(Collectors.toList());
		}
		PageInfo<ClassResponse> pageClass = new PageInfo<ClassResponse>(res);
		pageClass.setPageNum(pageNum);
		pageClass.setPageSize(pageSize);
		return pageClass;
	}

	private String getlevel2dept(int deptid) {
		List<Department> depts = this.deptDao.getDepartment(null);
		String res = "";
		if(CollectionUtils.isNotEmpty(depts)) {
			Map<Integer, Department> deptMap = depts.stream().collect(Collectors.toMap(Department::getId, dept -> dept));
			Department dept = deptMap.get(deptid);
			res = dept.getName();
			int pid = dept.getPid();
			if(pid > 0) {
				Department pdept = deptMap.get(pid);
				res = pdept.getName() + " / " + res;
			}
		}
		return res;
	}

	@Override
	public MessageCode updateClass(ClassRequest classRequest) {
		int id = classRequest.getId();
		Class cls = this.classDao.getClassById(id);
		String reqClassno = classRequest.getClassno();
		String classno = cls.getClassno();
		/**
		 * 如果请求中的期班号和根据id查询的期班号不一致，表示修改了期班号，需要先判断期班号是否重复
		 */
		if(!classno.equals(reqClassno)) {
			cls = this.classDao.getByClassno(reqClassno);
			if(cls != null) {
				return new MessageCode(Message.CLASSNOEXIST.getCode(), Message.CLASSNOEXIST.getMsg());
			}
		}
		this.classDao.updateClass(classRequest);
		return new MessageCode(Message.CLASSUPDATESUCCESS.getCode(), Message.CLASSUPDATESUCCESS.getMsg());
	}

	@Override
	public void deleteClass(List<Integer> delClassIds) {
		this.classDao.deleteClass(delClassIds);
	}

	@Override
	public ClassResponse getClassById(int cid) {
		Class cls = this.classDao.getClassById(cid);
		List<TypeData> typeDatas = this.typeDataDao.listTypeData();
		if(cls != null && CollectionUtils.isNotEmpty(typeDatas)) {
			Map<Integer, String> idNameTypeMap = typeDatas.stream().collect(Collectors.toMap(TypeData::getId, TypeData::getName));
			int termid = cls.getTermid();
			String termname = idNameTypeMap.get(termid);
			int deptid = cls.getDeptid();
			String deptname = getlevel2dept(deptid);
			int majorid = cls.getMajorid();
			String majorname = idNameTypeMap.get(cls.getMajorid());
			int trainlevelid = cls.getTrainlevelid();
			String trainlevel = idNameTypeMap.get(cls.getTrainlevelid());
			int tasktypeid = cls.getTasktypeid();
			String tasktype = idNameTypeMap.get(cls.getTasktypeid());
			return new ClassResponse(cls.getId(), cls.getClassno(), cls.getStunum(), termid, termname, deptid, deptname, majorid, majorname, 
					trainlevelid, trainlevel, tasktypeid, tasktype, cls.getCreateTime());
		}
		return null;
	}

}
