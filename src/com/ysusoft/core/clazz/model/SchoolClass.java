package com.ysusoft.core.clazz.model;

import java.io.Serializable;
import java.util.List;

import com.ysusoft.core.student.model.Student;

public class SchoolClass implements Serializable {
	private static final long serialVersionUID = 5910222914250970164L;
	private String ID;
	private String name;
	private List<Student> students;
	
	public SchoolClass(){
	}

	public SchoolClass(String ID,String name){
		this.ID = ID;
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
