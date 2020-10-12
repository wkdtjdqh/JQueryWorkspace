<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <%
    
    int result = (Integer)request.getAttribute("result");	//controller에서 servlet에 설정한 이름 그대로 가져온다
	if(result > 0){
		
	%>
	
	{"sw" : "성공"}
	
	<% }else{%>
	
	{"sw" : "실패"}
	
	<%	
	}
    %>