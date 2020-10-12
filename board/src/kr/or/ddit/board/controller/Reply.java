package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/Reply.do")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//댓글 삭제하기
		
		//1. 요청 시 데이타
				int renum = Integer.parseInt(request.getParameter("renum"));
				
		//2.
				IBoardService service = BoardServiceImpl.getservice();
				
		//3. 
				
				int cnt = service.replyDelete(renum);
				
				
		//request에 저장
				request.setAttribute("result", cnt);
		
		//jsp로 이동
				request.getRequestDispatcher("board/reply.jsp").forward(request, response);;
				
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//1. 요청 시 데이타
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name = request.getParameter("name");
		String cont = request.getParameter("cont");
		
		
		ReplyVO vo = new ReplyVO();
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		
		//2. service객체 얻기
		IBoardService service = BoardServiceImpl.getservice();
		
		//3.service 메서드 호출
		int renum = service.replySave(vo);
		
		//4. request scope에 저장
		
		request.setAttribute("result", renum);
		
		//5.jsp로 이동
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);;

		
	}

}
