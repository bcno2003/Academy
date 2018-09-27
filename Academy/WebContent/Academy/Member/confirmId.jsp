<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="DAO.MemberDAO"%>
<%@ page import = "db.JdbcUtil" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDAO memberDAO = MemberDAO.getInstense();
String id = request.getParameter("id");
boolean result = memberDAO.confirmId(id);
if(result){%>
<center>
<br /><br />
<h3>이미 사용중인 ID 입니다.</h3>
</center>
<%}else {%>
<center>
<br /><br />
<h3>입력하신 <%=id %>는 사용하실 수 있는 ID입니다.</h3>
</center>
<%} %>
<center>
<br /><br />
<input type="button" value="돌아가기" onClick="window.close()">
</center>
</body>
</html>