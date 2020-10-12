package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class CheckById
 */
@WebServlet("/checkById")
public class CheckById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
 
    public CheckById() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. 클라이언트 요청 시 전송되는 데이터를 받는다
		
		String userId = request.getParameter("id");
		//2. service객체 얻어오기
		IMemberService service = MemberServiceImpl.getService();
		
		//3. 결과값 변수 = service 메서드 호출
		
		String chkId = service.checkById(userId);
		//결과값은 null이거나 a001,b001 
		
		
		
		//4. 결과값을 view페이지에서 사용하기 위해  request scope에 저장한다
		request.setAttribute("idValue", chkId);
		
		
		//5. view 페이지로 이동(forward/redirect) - 처리 결과를 출력한다 
		/*
		 * forward : controller의 결과값을 server내에서 view페이지로 이동한다 ==> request response를 view와 servlet에서 공유할 수 있다
		 * redirect : controller의 결과값을 응답하고 저장되어 있던 결과값이 사라져 view에서 출력 되지 않는다 ==>request response를 view와 servlet에서 공유할 수 있다
		 * 
		 */
		RequestDispatcher disp = request.getRequestDispatcher("member/chkId.jsp");
		disp.forward(request, response);
		
		
		//6. 처리한 결과를 출력 대신 응답 데이터를 생성 - json object
		
		
	}

}
