package kr.or.ddit.member.controller;

import java.util.Scanner;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

public class MemberController {
	
	
	private IMemberService service;
	
	private Scanner sc;
	
	public MemberController() {

		service = MemberServiceImpl.getService();
		sc = new Scanner(System.in);
		
	}
	

}
