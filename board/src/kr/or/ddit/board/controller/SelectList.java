package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class SelectAll
 */
@WebServlet("/SelectList.do")


public class SelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 리스트를 가져온다
		//1. 클라이언트 요청 시 전송되는 데이터  받기
		//2. service 객체 얻기
		IBoardService service = BoardServiceImpl.getservice();
		
		//3. service 메서드 호출
		
		List<BoardVO> list = service.selectAll();
		
		
		//4. 결과값을 request scope에 저장
		
		request.setAttribute("listVal", list);
		
		
		//5. jsp로  이동한다
		RequestDispatcher rd = request.getRequestDispatcher("board/listAll.jsp");
		rd.forward(request, response);
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pameter가 있는 것 : 페이지별 리스트 수행
		
		//1. 클라이언트 요청 시 전송되는 데이터  받기
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		//2. service 객체 얻기
		IBoardService service = BoardServiceImpl.getservice();
		
		
		//3. service 메서드 호출 
		int totalCount = service.boardCountAll(); //게시판 글의 총 갯수
		
		//한 페이지 당 출력할 글 갯수
		int perList =3;
		//한 화면에 출력될 페이지 갯수
		int perPage = 2;
		
		int totalPage = (int)Math.ceil((double)totalCount / perList); // -> 페이지의 끝을 확인하기 위해서 총 페이지 수를 구한다
		
		int startPage = ((page-1) /perPage * perPage) +1;
		int endPage = startPage + perPage -1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		
		int start = (page-1)*perList+1;
		
		int end = start + perList -1;
		if(end > totalCount) end = totalCount;
		
		//각페이지에 출력될 시작번호와 끝번호
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		//페이지에 출력될 글 가져오기
		List<BoardVO> list = service.selectMyPage(map);
		
		
		//결과값을 request scope에 저장한다
		request.setAttribute("listPage", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		//5. jsp로  이동한다
		RequestDispatcher rd = request.getRequestDispatcher("board/listPage.jsp");
		rd.forward(request, response);
		
	}

}
