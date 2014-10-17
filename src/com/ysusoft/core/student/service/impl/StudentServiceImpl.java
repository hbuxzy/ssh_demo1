package com.ysusoft.core.student.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysusoft.core.student.dao.IStudentDao;
import com.ysusoft.core.student.model.Student;
import com.ysusoft.core.student.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao studentDao;
	
	public void addStudent() {

	}

	public List<Student> getAll() {
		return studentDao.getAll();
	}

	public List<Student> getStudents(int start, int size) {
		return studentDao.getStudents(start, size);
	}
	
	public List<Student> find(Map<String,Object> map,int page,int rows){
		String hql = "from Student t";
		return studentDao.find(hql, map, page, rows);
	}

}
