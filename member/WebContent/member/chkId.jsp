<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    <%
    
    String id = (String)request.getAttribute("mem_id");
    
    if(id == null){ //��밡��

   	 %>
   	 
   	 {"sw" :  "��밡�� ���̵� �Դϴ�"}
   	 
   	 <%

   	 }else{//���Ұ���
   		 
   	 %>
   	 
   	 {"sw" :  "��� �Ұ��� ���̵� �Դϴ�"}
   	 
   	 <%
   	  }
   	 %>