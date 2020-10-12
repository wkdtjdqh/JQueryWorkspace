<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%

	List<BoardVO> list = (List<BoardVO>)request.getAttribute("listVal");
	
%>
[

<%
for(int i = 0; i<list.size(); i++){
	BoardVO vo = list.get(i);
	if(i>0)out.println(",");

%>
	{
	
	"seq" : "<%= vo.getSeq() %>",
	"subject" : "<%= vo.getSubject() %>",
	"writer" : "<%= vo.getWriter() %>",
	"mail" : "<%= vo.getMail() %>",
	"content" : "<%= vo.getContent() %>",
	"hit" : "<%= vo.getHit() %>",
	"wdate" : "<%= vo.getWdate() %>"

	}
	
<%} %>


]

