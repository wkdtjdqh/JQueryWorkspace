<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    [
    
    <table>
	 <tr><td style = "width:100px;">�����ȣ</td><td>�ּ�</td><td style = "width:100px;">����</td></tr>
	 <tr></tr>
    
    <%
    List<ZipVO> list = (List<ZipVO>)request.getAttribute("zipList");
    
    for(int i = 0; i<list.size();i++){
    	ZipVO vo = list.get(i);
    	String bunji = vo.getBunji();
    	if(bunji == null){
    		bunji ="";
    	}
    	
    	%>
    	
    	<tr>
    	<td><%=vo.getZipcode() %></td>
    	<td><%=vo.getSido() %><%= vo.getGugun() %><%=vo.getDong() %></td>
    	<td><%=bunji %></td>
    	
    	</tr>
    	
    	
    <% 
    	
    }
    
    %>
   </table>