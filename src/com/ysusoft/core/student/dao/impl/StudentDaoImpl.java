package com.ysusoft.core.student.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ysusoft.core.base.dao.impl.BaseDaoImpl;
import com.ysusoft.core.student.dao.IStudentDao;
import com.ysusoft.core.student.model.Student;

@Repository
public class StudentDaoImpl extends BaseDaoImpl implements IStudentDao {

	public void addStudent() {

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		Query query = this.getSessionFactory().getCurrentSession().createQuery("from Student");
		return (List<Student>)query.list();
	}

	public List<Student> getStudents(int start, int size) {
		return null;
	}
}
