package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/write.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		
		//1.요청 시 데이터
		BoardVO vo = new BoardVO();
		vo.setWip(request.getRemoteAddr());
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2. 서비스 객체
		IBoardService service = BoardServiceImpl.getservice();
		
		//메서드 호출
		int seq = service.insertBoard(vo);
		
		//4.  request 저장
		request.setAttribute("result", seq);
		
		//5. jsp로 이동
		request.getRequestDispatcher("board/reply.jsp").forward(request, response);
		
//		String writer = request.getParameter("wWriter");
//		request.getParameter("wSubject");
//		request.getParameter("wMail");
//		request.getParameter("wPassword");
//		request.getParameter("wContent");
		
		
		
		
		
		
		
	}

}
