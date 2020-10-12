package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ReadHitUpdate
 */
@WebServlet("/ReadHitUpdate")
public class ReadHitUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadHitUpdate() {
 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1.요청 시 데이터 가져오기
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		//2.
		IBoardService service = BoardServiceImpl.getservice();
		
		//3.
		//조회수를 증가와 조회 메서드 호출
		int hit = service.updateHit(bonum);
	
		//4.
		request.setAttribute("hit",hit);
		
		
		//5.
		request.getRequestDispatcher("board/hitResult.jsp").forward(request, response);
	}

}
