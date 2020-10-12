package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService{
	
	private static IBoardService service;
	private IBoardDao dao;
	
	
	private BoardServiceImpl(){
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getservice(){
		if(service == null) service = new BoardServiceImpl();
		return service;
		
	}

	@Override
	public List<BoardVO> selectAll() {
	
		return dao.selectAll();
	}

	@Override
	public List<BoardVO> selectMyPage(Map<String, Integer> paramMap){
		
		List<BoardVO> list = null;
		
		try {
			list = dao.selectMyPage(paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}

	@Override
	public int boardCountAll() {
		
		int num =0;
		
		try {
			num =  dao.boardCountAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public int replySave(ReplyVO vo) {
		int renum = 0;
		try {
			renum = dao.replySave(vo);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return renum;
	}

	@Override
	public List<ReplyVO> replyList(int bonum) {
		
		
		List<ReplyVO> list = null;
		try {
			list = dao.replyList(bonum);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int replyDelete(int renum) {


		int cnt = 0;
		
		try {
			cnt = dao.replyDelete(renum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;		//삭제된 횟수를 리턴한다
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		
		
		int cnt = 0;
		
		try {
			cnt = dao.replyUpdate(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateHit(int bonum) {
		
		int cnt = 0;
		int hit =0;
		
		try {
			cnt = dao.updateHit(bonum); //조회수 증가
			
			//조회수 조회 
			
			if(cnt > 0) hit = dao.seletHit(bonum);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hit; //조회수 값
	}

	@Override
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int deleteBoard(int bonum) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteBoard(bonum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		
		
		int seq =  0;
		
		
		try {
			seq = dao.insertBoard(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seq;
	}

	

}
