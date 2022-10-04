<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 조금이라도 데이터를 보내야하 하는게 있다면 controller를 방문해야 하기 때문에
	// .jsp를 하면 안.된.다
	
	response.sendRedirect("login.do");

%>