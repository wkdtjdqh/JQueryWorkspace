<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


    <%
	    		//post방식의 경우에는 아래의 코드를 추가해주세요!
	    		//get방식은 적용되지 않습니다(한들 인코딩)
	   			 request.setCharacterEncoding("UTF-8"); %>
    <%
    
    
    		/* get방식
    		String id = new String(request.getParameter("id").getBytes("8859_1"), "UTF-8");
    		out.print(id);
    		String pwd = new String(request.getParameter("pwd").getBytes("8859_1"), "UTF-8");
    		out.print(pwd);
    		*/
    		
    		//post 방식
    		String id = request.getParameter("id");
    		out.print("아이디 : " + id + "<br>");
    		
    		String pwd = request.getParameter("pwd");
    		out.print("비밀번호 : " + pwd + "<br>");
    		
//     		String pwdcheck= request.getParameter("pwdcheck");
//     		out.print("비밀번호 확인 : " + pwdcheck + "<br>");
    		
//     		String name= request.getParameter("name");
//     		out.print("이름 : " + name + "<br>");
    		
//     		String gender= request.getParameter("gender");
//     		out.print("성별 : " + gender + "<br>");
    		
//     		String emailAddress= request.getParameter("emailAddress");
//     		String domain= request.getParameter("domain");
//     		out.print("이메일 : " + emailAddress + "@" + domain + "<br>");
    		
//     		String phoneNm= request.getParameter("phoneNm");
//     		out.print("핸드폰 번호 : " + phoneNm + "<br>");
    		
//     		String Cer= request.getParameter("Cer");
//     		out.print("인증방법 : " + Cer + "<br>");
    		
//     		String CerNm= request.getParameter("CerNm");
//     		out.print("인증번호 : " + CerNm);
    		
    		
    		
    		
    %>