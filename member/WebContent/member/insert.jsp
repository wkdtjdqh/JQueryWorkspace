<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
    <%
    
    String id = (String) request.getAttribute("idval");
    
    if(id != null){
    %>
    {
    	"sw": "<%=id %>님 환영합니다"
    
    }
    
    
    
    <%}else{%>
    
    {
    	"sw": "<%=id %>님 가입실패"
    
    }
    
    
    <%	
    }
    
    %>