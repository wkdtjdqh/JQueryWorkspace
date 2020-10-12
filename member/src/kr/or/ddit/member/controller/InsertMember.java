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
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/insert.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
	
		//2. 
		
		IMemberService service = MemberServiceImpl.getService();
	
		//3. 
		
		String inidval = service.insertMember(vo);
		
		//4. 
		
		request.setAttribute("idval", inidval);
	
		//5. 
		RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
		
		rd.forward(request, response);
		
	}

}
