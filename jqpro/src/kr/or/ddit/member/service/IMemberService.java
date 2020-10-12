package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;


public interface IMemberService {
	
	//아이디 중복 검사
	//select MEM_ID from member  where = 'korea'
	//<select id ="" parameterClass ="" resultClass = "">
	public String checkById(String id);
	
	
	//우편번호 찾기
	 
	public List<ZipVO> selectByDong(String dong);
	
	//가입하기
	//<insert id = "" parameterclass ="memVo">
	public String insertMember(MemberVO memVo);
	

}
