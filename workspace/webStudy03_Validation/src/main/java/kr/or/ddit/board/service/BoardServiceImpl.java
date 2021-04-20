package kr.or.ddit.board.service;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.controller.BoardUpdateController;
import kr.or.ddit.board.dao.AttatchDAOImpl;
import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IAttatchDAO;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.CustomException;
import kr.or.ddit.utils.CryptoUtil;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDAO boardDAO = new BoardDAOImpl();
	private IAttatchDAO attatchDAO = new AttatchDAOImpl();
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	private SqlSessionFactory sessionFactory =
			CustomSqlSessionFactoryBuilder.getSessionFactory();
	
	private void encodePassword(BoardVO board) {
		String bo_pass = board.getBo_pass();
		if(StringUtils.isBlank(bo_pass)) return;
		try {
			String encodedPass = CryptoUtil.sha512(bo_pass);
			board.setBo_pass(encodedPass);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	private int processes(BoardVO board,SqlSession session) {
		File saveFolder = new File("D:/attatches");
		int cnt = 0;
		List<AttatchVO> attatchList = board.getAttatchList();
		if(attatchList!=null && attatchList.size()>0) {
			cnt += attatchDAO.insertAttatches(board, session);
			
			try {
				for(AttatchVO attatch : attatchList) {
//					if(1==1)
//						throw new RuntimeException("강제 발생 예외");
					attatch.saveTo(saveFolder);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return cnt;
	}
	
	private int deleteprocesses(BoardVO board,SqlSession session) {
		int[] deleNo = board.getDelAttNos();
		int cnt = 0;
		if(deleNo!=null && deleNo.length>0) {
		List<String> deleNames = 
				attatchDAO.selectSaveNamesForDelete(board); 
		
		
		attatchDAO.deleteAttathes(board, session);
		
		String foldername = "D:/attatches";
		for(String deleName:deleNames) {
			File file = new File(foldername, deleName);
			file.delete();
			cnt++;
		}
		}
		
		return cnt;
	}
	
	@Override
	public ServiceResult createBoard(BoardVO board) {
		ServiceResult result = ServiceResult.FAIL;
		//==========비밀번호 암호화==========
		encodePassword(board);
		//===============================
		try(
				// true로 나두면 한번실행후 자동커밋
			SqlSession session = sessionFactory.openSession(false);
		){
			int cnt = boardDAO.insertBoard(board, session);
			if(cnt > 0) {
				//==========첨부파일 처리==========
				cnt += processes(board, session);
				//==============================
				if(cnt > 0) {
					result = ServiceResult.OK;
					session.commit();
				}
			}			
		}	//try end
		return result;
	}
	
	@Override
	public int retrieveBoardCount(PagingVO<BoardVO> pagingVO) {
		return boardDAO.selectBoardCount(pagingVO);
	}

	@Override
	public List<BoardVO> retrieveBoardList(PagingVO<BoardVO> pagingVO) {
		return boardDAO.selectBoardList(pagingVO);
	}

	@Override
	public BoardVO retrieveBoard(BoardVO search) {
		BoardVO board = boardDAO.selectBoard(search);
		if(board==null)
			throw new CustomException(search.getBo_no()+"에 해당하는 게시글이 없음");
		return board;
	}

	@Override
	public ServiceResult modifyBoard(BoardVO board) {
		
		try(
				SqlSession session = sessionFactory.openSession(false)
			){
			ServiceResult result = ServiceResult.INVALIDPASSWORD;
			
			encodePassword(board);
			int cnt = boardDAO.updateBoard(board, session);
			if(cnt>0) {
				cnt += processes(board,session);
				cnt += deleteprocesses(board,session);
				
				if(cnt > 0)
					result = ServiceResult.OK;
				session.commit();
			}
			return result;
		}// try end
		
		
	}

	@Override
	public ServiceResult removeBoard(BoardVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttatchVO download(int att_no) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean boardAuthenticate(BoardVO search) {
		BoardVO saved = boardDAO.selectBoard(search);
		encodePassword(search);
		String savedPass = saved.getBo_pass();
		String inputPass = search.getBo_pass();
		return savedPass.equals(inputPass);
	}
}
























