<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <%  request.setCharacterEncoding("UTF-8"); %>
    
    <%
    
    	String name= request.getParameter("name");
  		out.print("이름 : " + name + "<br>");
  		
  	    String address= request.getParameter("emailAddress");
  		out.print("이메일주소 : " + address + "<br>");
  		
  		String content= request.getParameter("content");
  		out.print("내용 : " + content + "<br>");
  		
  		
    
    %>