package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import sun.security.krb5.internal.crypto.CksumType;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.BuildSqlMapClient;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

/*
 * Mapper의 sql문을 실행하기 위해서 sqlMapClient 객체를 얻어온다
 * dao객체를 service에서 사용할 수 있도록 자신의 객체를 생성하고 리턴한다 
 * 
 */

public class MemberDaoImpl implements IMemberDao{
	
	private SqlMapClient client;
	private static IMemberDao dao;
	
	//생성자
	private MemberDaoImpl(){
		
		client = BuildSqlMapClient.getSqlMapClient();
	
		
	}
	
	//리턴하는 메서드
	public static IMemberDao getDao(){
		if( dao ==null) dao = new MemberDaoImpl();
		return dao;
	}

	
	//아이디 중복 검사하는 메서드 
	@Override
	public String checkById(String id) {
		// TODO Auto-generated method stub
		String checkId =null;
		try {
			checkId = (String) client.queryForObject("join.CheckById",id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return checkId;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {

		List<ZipVO> list = null;
		
		try {
			list = client.queryForList("join.SelectByDong",dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertMember(MemberVO memVo) {
		
			String resId= null;
			
			try {
				resId = (String) client.insert("join.InsertMember",memVo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return resId;
	}

}
