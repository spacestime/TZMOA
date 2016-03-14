<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	
  <body>
    <s:iterator value="roleList" >
    	<s:property value="id"/>,
    	<s:property value="name"/>,
    	<s:property value="description"/>
    	<%--使用s:a标签 可以自动加上前面的工程 名称和后面的扩展名--%>
    	<s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a> 
    	<s:a action="role_editUI?id=%{id}">修改</s:a>
    	<br/>
    </s:iterator>
    <br/>
    <s:a action="role_addUI">添加 </s:a>
    
  </body>
</html>
