<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    
    	<%
    	int hit = (Integer)request.getAttribute("hit");
    	
    	
    	%>
    	
    	{
    	
    	"hit" : "<%=hit %>"
    	
    	
    	}