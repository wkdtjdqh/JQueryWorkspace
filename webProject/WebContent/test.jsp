<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
		<style>
		
		
		h1{
		color : red;
		
		}
		p{
		
		font-size: 1.2em;
			
		
		}
		
		span{
		font-size: 1.2em;
		background: blue;
		
		}
		
		</style>
		</head>
		<body>
		<!--소스에서 보이는 주석처리  -->
		<%-- 소스에서도 보이지 않는 주석처리--%>

			<h1>JSP : Java Server Page</h1>
			HTML과 Java프로그램을 동시에 사용 가능<br>
			<%
			
				String sid = request.getParameter("id");
				int a = (int) Math.floor(Math.random()*100);
				out.print("a = " + a);
			%>
			<span><%= a %></span><br>
			<%= sid %>
			
		</body>
	</html>