<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <%  request.setCharacterEncoding("UTF-8"); %>
    
    <%
    
    	String name= request.getParameter("name");
  		out.print("�̸� : " + name + "<br>");
  		
  	    String address= request.getParameter("emailAddress");
  		out.print("�̸����ּ� : " + address + "<br>");
  		
  		String content= request.getParameter("content");
  		out.print("���� : " + content + "<br>");
  		
  		
    
    %>