package com.ysusoft.core.base.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	public HttpServletRequest request;
	public HttpServletResponse response;
	public HttpSession session;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setRequestAttribute(String key, Object value) {
		this.request.setAttribute(key, value);
	}
	
	public Object getRequestAttribute(String key) {
		return this.request.getAttribute(key);
	}
	
	public String getRequestParameter(String key) {
		return this.request.getParameter(key);
	}
	
	public void setSessionAttribute(String key, Object value) {
		this.session.setAttribute(key, value);
	}
	
	public Object getSessionAttribute(String key) {
		return this.session.getAttribute(key);
	}
}
