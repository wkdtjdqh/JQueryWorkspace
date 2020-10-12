<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


	<%  request.setCharacterEncoding("UTF-8"); %>
    
    <%
    
	    String name= request.getParameter("name");
		out.print("이름 : " + name + "<br>");
		
	    String address= request.getParameter("address");
		out.print("주소 : " + address + "<br>");
		
		String email= request.getParameter("emailAddress");
		out.print("이메일 : " + email + "<br>");
		
		String gender= request.getParameter("gender");
		out.print("성별 : " + gender + "<br>");
		
		
	
    
    
    %>