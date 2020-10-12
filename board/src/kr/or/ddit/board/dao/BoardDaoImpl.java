package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.config.BulidSqlMapClient;

import com.ibatis.sqlmap.client.SqlMapClient;

/*
 * Mapper를 실행하기 위한 sqlMapClient 객체가 필요 -BuildSqlMapClient에서 얻어오기
 * service에서 사용할 dao 객체를 생성하고 리턴
 * 
 */

public class BoardDaoImpl implements IBoardDao{

	//객체 선언
	private static IBoardDao dao;
	private SqlMapClient smc;
	
	private BoardDaoImpl(){
		smc = BulidSqlMapClient.getSqlMapClient();
	}
	
	public static IBoardDao getDao(){
		if(dao == null)dao = new BoardDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectAll() {

		List<BoardVO> list = null;
		
		try {
			list = smc.queryForList("board.selectAll");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BoardVO> selectMyPage(Map<String, Integer> paramMap) throws SQLException {
		
		return smc.queryForList("board.selectMyPage",paramMap);
		
	
	}

	@Override
	public int boardCountAll() throws SQLException {
		
		return (Integer) smc.queryForObject("board.boardCountAll");
	}

	@Override
	public int replySave(ReplyVO vo) throws SQLException {
		
		
		return (Integer) smc.insert("reply.replySave",vo);
	}

	@Override
	public List<ReplyVO> replyList(int bonum) throws SQLException {
		
		
		
		return smc.queryForList("reply.replyList",bonum);
	}

	@Override
	public int replyDelete(int renum) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)smc.delete("reply.replyDelete",renum);
	}

	@Override
	public int replyUpdate(ReplyVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return  (Integer)smc.update("reply.replyUpdate",vo);
	}

	@Override
	public int updateHit(int bonum) throws SQLException {
		
		return (Integer)smc.update("board.updateHit",bonum);
	}

	@Override
	public int seletHit(int bonum) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)smc.queryForObject("board.seletHit",bonum);
	}

	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		
		return  (Integer)smc.update("board.updateBoard",vo);
	}

	@Override
	public int deleteBoard(int bonum) throws SQLException {
		
		return (Integer)smc.delete("board.deleteBoard",bonum);
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return (Integer)smc.insert("board.insertBoard",vo);
	}

}
