<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
    <%
    
    String id = (String) request.getAttribute("idval");
    
    if(id != null){
    %>
    {
    	"sw": "<%=id %>�� ȯ���մϴ�"
    
    }
    
    
    
    <%}else{%>
    
    {
    	"sw": "<%=id %>�� ���Խ���"
    
    }
    
    
    <%	
    }
    
    %>