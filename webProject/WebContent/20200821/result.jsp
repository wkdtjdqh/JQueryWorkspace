<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


    <%
	    		//post����� ��쿡�� �Ʒ��� �ڵ带 �߰����ּ���!
	    		//get����� ������� �ʽ��ϴ�(�ѵ� ���ڵ�)
	   			 request.setCharacterEncoding("UTF-8"); %>
    <%
    
    
    		/* get���
    		String id = new String(request.getParameter("id").getBytes("8859_1"), "UTF-8");
    		out.print(id);
    		String pwd = new String(request.getParameter("pwd").getBytes("8859_1"), "UTF-8");
    		out.print(pwd);
    		*/
    		
    		//post ���
    		String id = request.getParameter("id");
    		out.print("���̵� : " + id + "<br>");
    		
    		String pwd = request.getParameter("pwd");
    		out.print("��й�ȣ : " + pwd + "<br>");
    		
//     		String pwdcheck= request.getParameter("pwdcheck");
//     		out.print("��й�ȣ Ȯ�� : " + pwdcheck + "<br>");
    		
//     		String name= request.getParameter("name");
//     		out.print("�̸� : " + name + "<br>");
    		
//     		String gender= request.getParameter("gender");
//     		out.print("���� : " + gender + "<br>");
    		
//     		String emailAddress= request.getParameter("emailAddress");
//     		String domain= request.getParameter("domain");
//     		out.print("�̸��� : " + emailAddress + "@" + domain + "<br>");
    		
//     		String phoneNm= request.getParameter("phoneNm");
//     		out.print("�ڵ��� ��ȣ : " + phoneNm + "<br>");
    		
//     		String Cer= request.getParameter("Cer");
//     		out.print("������� : " + Cer + "<br>");
    		
//     		String CerNm= request.getParameter("CerNm");
//     		out.print("������ȣ : " + CerNm);
    		
    		
    		
    		
    %>