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
 * Servlet implementation class BoardDelete
 */
@WebServlet("/delete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청 시 데이터 
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		//2.
		IBoardService service = BoardServiceImpl.getservice();
		
		//3.
		
		int cnt = service.deleteBoard(bonum);
		
		//4.
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);
		
		
		
	}

}
