package com.ysusoft.core.student.service;

import java.util.List;
import java.util.Map;

import com.ysusoft.core.student.model.Student;

public interface IStudentService {
	public void addStudent();
	
	public List<Student> getAll();
	
	public List<Student> getStudents(int start,int size);
	
	public List<Student> find(Map<String,Object> map,int page,int rows);
	
}
