package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService{

	
	private static IMemberService service; 
	private IMemberDao dao;
	
	private MemberServiceImpl() {
		dao =MemberDaoImpl.getdao();
	}
	
	public static IMemberService getService(){
		
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public String checkById(String id) {
		// TODO Auto-generated method stub
		return dao.checkById(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return dao.selectByDong(dong);
	}

	@Override
	public String insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.insertMember(memVo);
	}

}
