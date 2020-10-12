package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	
	
	public String checkById(String id);
	
	public List<ZipVO> selectByDong(String dong);
	
	
	public String insertMember(MemberVO memVo);
	
	
	
}
