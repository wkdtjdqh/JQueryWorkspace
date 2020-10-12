<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    <%
    	List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("list");
    %>
    [
    <% 
    
    	for(int i =0; i<list.size(); i++){
    			ReplyVO vo = list.get(i);
    			if(i>0) out.println(",");
	
  	%>
    		
    	{
    		"renum" : "<%=vo.getRenum() %>",
    		 "name" : "<%=vo.getName() %>",
    		 "redate" : "<%= vo.getRedate() %>",
    		 "cont" : "<%=vo.getCont().replaceAll("\r","").replaceAll("\n","<br>")%>"
    
    	}
    		
    <%
    	}
  
    %>
    ]