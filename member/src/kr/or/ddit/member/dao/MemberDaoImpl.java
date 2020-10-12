package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildSqlMapClient;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{

	private static IMemberDao dao;
	
	private SqlMapClient smc;
	
	public MemberDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	public static IMemberDao getdao() {
		if(dao == null ) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public String checkById(String id) {
		
		String chkId = "";
		
		try {
			chkId = (String) smc.queryForObject("join.CheckById",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chkId;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {

		List<ZipVO> vo = null;
		
		try {
			vo = smc.queryForList("join.SelectByDong",dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public String insertMember(MemberVO memVo) {
		String resultId = "";
		
		try {
			resultId = (String) smc.insert("join.InsertMember",memVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultId;
	}


}
