<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


	<%  request.setCharacterEncoding("UTF-8"); %>
    
    <%
    
	    String name= request.getParameter("name");
		out.print("�̸� : " + name + "<br>");
		
	    String address= request.getParameter("address");
		out.print("�ּ� : " + address + "<br>");
		
		String email= request.getParameter("emailAddress");
		out.print("�̸��� : " + email + "<br>");
		
		String gender= request.getParameter("gender");
		out.print("���� : " + gender + "<br>");
		
		
	
    
    
    %>