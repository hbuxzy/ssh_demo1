package com.ysusoft.core.student.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ysusoft.core.base.action.BaseAction;
import com.ysusoft.core.student.model.Student;
import com.ysusoft.core.student.service.IStudentService;

/**
 * @caption: 
 */
public class StudentAction extends BaseAction{
	
	@Autowired(required=true)
	private IStudentService studentService;
	public String addStudent(){
		return "SUCCESS";
	}
	
	/**
	 * 分页查询所有的任务 如果有条件 按照条件查询
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String list(){
		String pageStr = request.getParameter("page");
		if(pageStr == null) {
			pageStr = "1";
		}
		int page = Integer.parseInt(pageStr);
		int rows = 10;
		Date startTime = new Date();
		List students = studentService.find(null, page, rows);
		Date endTime = new Date();
		long mills = endTime.getTime() - startTime.getTime();
		
		System.out.println("page:"+page+" mills:"+mills);
		request.setAttribute("students", students);
		request.setAttribute("mills", mills);
		request.setAttribute("page", page);
		return "SUCCESS";
	}
	
	public String listAll(){
		Date startTime = new Date();
		
		List students = studentService.getAll();
		Date endTime = new Date();
		long mills = endTime.getTime() - startTime.getTime();
		
		int studentCount = students.size();
		request.setAttribute("studentCount", studentCount);
		
		List stus = new ArrayList();
		for(int i=1;i<10;i++){
			stus.add(students.get(studentCount-i));
		}
		request.setAttribute("students", stus);
		request.setAttribute("mills", mills);
		return "listAll";
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	
	
}
