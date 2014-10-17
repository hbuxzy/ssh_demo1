<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
  <head>   
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  function createStudent(){
	  var count = document.getElementById("count").value;
	  alert(count);
  }
  function jumpPage(){
	  var count = document.getElementById("page").value;
	  window.location.href = "<%=basePath%>student/list.action?page="+count;
  }
  
  </script>
  <body>
  <center>
    studentList page. <br />
    
  查询耗时：  <label><s:property value="#request.mills"/></label> 毫秒  <br />
    第<input id="page" name="page" value="<s:property value="#request.page"/>" /> 页的数据 <button onclick="jumpPage();">Jump</button> <br />
    十条数据：<br />
    
    <s:iterator value="#request.students" var="var">
      ID:<s:property value="#var.ID"/> 
      name:<s:property value="#var.name"/> <br />
    </s:iterator>
    
    
    <br />
  </center>
  </body>
</html>
