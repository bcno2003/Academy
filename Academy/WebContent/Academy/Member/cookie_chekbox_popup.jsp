<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
 <title>popup</title>
<SCRIPT language="JavaScript"> 
<!-- 
function setCookie( name, value, expiredays ) 
{ 
var todayDate = new Date(); 
todayDate.setDate( todayDate.getDate() + expiredays ); 
document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
} 

function closeWin() 
{ 
if ( document.pop.Notice.checked ) 
setCookie( "Notice", "done" , 1);//1은 하루동안 새창을 열지 않게 합니다. 
window.close(); 
} 
// --> 
</SCRIPT> 
</head>
<body>
<jsp:include page="popUpPage.jsp"></jsp:include>
<form name=pop> 
<p align="center"> 
<input type=checkbox name="Notice" value="">다음부터 공지창 띄우지 않음<a href="javascript:history.onclick=closeWin()">[닫기]</a>   
</form> 
</body>
</html>
