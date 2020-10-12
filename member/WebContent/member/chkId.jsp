<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%
    
    String id = (String)request.getAttribute("mem_id");
    
    if(id == null){ //사용가능

   	 %>
   	 
   	 {"sw" :  "사용가능 아이디 입니다"}
   	 
   	 <%

   	 }else{//사용불가능
   		 
   	 %>
   	 
   	 {"sw" :  "사용 불가능 아이디 입니다"}
   	 
   	 <%
   	  }
   	 %>