package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class selectByDong
 */
@WebServlet("/zip.do")
public class SelectByDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SelectByDong() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			request.setCharacterEncoding("utf-8"); //get방식일때는 server.xml에서 이미 설정되었으므로 post에서만 설정해준다
			
			//1. client 요청 시 전송되는 값을 받는가
			
			String dongVal = request.getParameter("dong");
			
			//2. service 객체 얻어오기
			
			IMemberService service = MemberServiceImpl.getService();
		
			//3. 결과값 = service메서드 호출
			
			List<ZipVO> list = service.selectByDong(dongVal);
		
			//4. 결과 값을 request scope에 저장
			
			request.setAttribute("listVal", list);
		
			//5. jsp로 foward한다
			RequestDispatcher disp = request.getRequestDispatcher("member/zip.jsp");
			
			disp.forward(request, response);
		
	}

}
