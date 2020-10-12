package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	

//	1. 전체리스트 -메서드 이름은 mapper의 아이디 이름과 동일하게 설정한다
	public List<BoardVO> selectAll();

	
//	1-1 페이지별 리스트 
	
	public List<BoardVO> selectMyPage(Map<String, Integer> paramMap);
	
	
//	1-2 전체 글 갯수 가져오기 (select count(*) from ) 
	public int boardCountAll();
	
//		- 전체 페이지 수 구하기
//		- 한 페이지 당 출력된 글 갯수
//		- 한 화면에서 출력된 페이지 개수
//		
//
//	2. 글쓰기 
	public int insertBoard(BoardVO vo);
	
	
//	3. 글수정하기 / 삭제
	
	//글 수정
	public int updateBoard(BoardVO vo);
	
	//글삭제
	
	public int deleteBoard(int bonum);
	
	
//		4. 댓글 저장
	
	public int replySave(ReplyVO vo);//저장할 땐 리턴 타입 void 리턴 타입은 renum
	
	
//		5. 댓글 수정/ 삭제
	
	public int replyUpdate(ReplyVO vo);
	
	public int replyDelete(int renum);
	
//		6. 댓글 리스트
	public List<ReplyVO> replyList(int bonum);
	
//		7. 조회수 증가
	public int updateHit(int bonum);
	
 
	

}
