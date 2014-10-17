package com.ysusoft.core.student.dao;

import java.util.List;
import java.util.Map;

import com.ysusoft.core.student.model.Student;

public interface IStudentDao {
	
	public void addStudent();
	
	public List<Student> getAll();
	
	public List<Student> getStudents(int start,int size);
	
	public List<Student> find(String hql,Map<String,Object> map,int page,int rows);
	
}