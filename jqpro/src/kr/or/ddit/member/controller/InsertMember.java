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
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;


@WebServlet("/insert.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertMember() {
        super();
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//1. client 요청 시 전송되는 값을 받는다
		
		String id = request.getParameter("mem_id");
		String pass = request.getParameter("mem_pass");
		String name = request.getParameter("mem_name");
		String bir = request.getParameter("mem_bir");
		String mail = request.getParameter("mem_mail");
		String hp = request.getParameter("mem_hp");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_bir(bir);
		vo.setMem_mail(mail);
		vo.setMem_hp(hp);
		vo.setMem_zip(zip);
		vo.setMem_add1(add1);
		vo.setMem_add2(add2);
		
	
		//2. service 객체 얻어오기
		
		IMemberService service = MemberServiceImpl.getService();
	
		//3. 결과값 = service메서드 호출
		
		String inidval = service.insertMember(vo);
		
		//4. 결과 값을 request scope에 저장
		
		request.setAttribute("idval", inidval);
	
		//5. jsp로 foward한다
		RequestDispatcher disp = request.getRequestDispatcher("member/insert.jsp");
		
		disp.forward(request, response);
		
		
		
	}

}
