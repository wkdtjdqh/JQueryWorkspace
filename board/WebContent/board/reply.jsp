<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <%
    
    int result = (Integer)request.getAttribute("result");	//controller���� servlet�� ������ �̸� �״�� �����´�
	if(result > 0){
		
	%>
	
	{"sw" : "����"}
	
	<% }else{%>
	
	{"sw" : "����"}
	
	<%	
	}
    %>