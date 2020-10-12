<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <%
    
    	List<BoardVO> list = (List<BoardVO>)request.getAttribute("listPage");
    
    	int total =(Integer) request.getAttribute("totalPage");
    	int sp =(Integer) request.getAttribute("startPage");
    	int ep =(Integer) request.getAttribute("endPage");
    	
    	
    %>
    {
    
    "totalP" : "<%= total %>",
    "startP" : "<%= sp %>",
    "endP" : "<%= ep %>",
    "datas" :
 
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
		"content" : "<%= vo.getContent().replaceAll("\r","").replaceAll("\n","<br>") %>",
		"hit" : "<%= vo.getHit() %>",
		"wdate" : "<%= vo.getWdate() %>"
	
		}
	
	<%
		} 
	%>


	]

}