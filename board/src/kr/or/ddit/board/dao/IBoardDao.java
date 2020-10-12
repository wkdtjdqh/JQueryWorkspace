package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapException;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
	
//	1. 전체리스트 -메서드 이름은 mapper의 아이디 이름과 동일하게 설정한다
	public List<BoardVO> selectAll();

	
//	1-1 페이지별 리스트 
	
	public List<BoardVO> selectMyPage(Map<String, Integer> paramMap) throws SQLException;
	
	
//	1-2 전체 글 갯수 가져오기 (select count(*) from ) 
	public int boardCountAll() throws SQLException;
	
	public int replySave(ReplyVO vo) throws SQLException;
	
	
	//댓글 리스트
	public List<ReplyVO> replyList(int bonum) throws SQLException;
	
	//댓글 삭제
	public int replyDelete(int renum) throws SQLException;
	
	
	public int replyUpdate(ReplyVO vo) throws SQLException;
	
	
	//조회수 증가
	public int updateHit(int bonum) throws SQLException;
	
	
	//조회수 조회	- 결과 값은 hit
	public int seletHit(int bonum) throws SQLException;
	
	//글수정
	public int updateBoard(BoardVO vo) throws SQLException;
	
	//글삭제
	public int deleteBoard(int bonum) throws SQLException;
	
	//2. 글쓰기 
	public int insertBoard(BoardVO vo) throws SQLException;


}
