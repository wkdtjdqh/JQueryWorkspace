package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		//요청시 전송되는 값
		int bonum = Integer.parseInt(request.getParameter("bonum").trim());
		
		//2.service객체 얻기
		
		IBoardService service = BoardServiceImpl.getservice();
		
		//3. service 메서드 호출

		List<ReplyVO> list = service.replyList(bonum);
		
		//4. request에 저장
		request.setAttribute("list", list);
		
		//5.jsp로 이동
		request.getRequestDispatcher("board/replyList.jsp").forward(request, response);;
		
	
	}

}
