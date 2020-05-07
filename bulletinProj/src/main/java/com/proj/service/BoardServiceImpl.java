package com.proj.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.bindingEntity.BoardArticle;
import com.proj.dao.BoardDao;
import com.proj.dao.BoardLikeDao;
import com.proj.dao.UserDao;
import com.proj.entity.Board;
import com.proj.entity.BoardKind;
import com.proj.entity.BoardLike;
import com.proj.entity.User;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private BoardLikeDao boardLikeDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public List<Board> getBoards() {
		
		return boardDao.getBoards();
	}

	@Override
	@Transactional
	public Board getBoard(Long theId) {
		
		return boardDao.getBoard(theId);
	}

	@Override
	@Transactional
	public void saveBoard(BoardArticle boardArticle) {
		
		Board theBoard = new Board();
		User theUser = userDao.getUser(boardArticle.getUserId());
		
		// TODO temporarily...
		BoardKind boardKind = new BoardKind();
		boardKind.setBoardKindId(boardArticle.getBoardKind());
		boardKind.setBoardKindName(boardArticle.getBoardKind());
		theBoard.setBoardKind(boardKind);
		
		theBoard.setContent(boardArticle.getContent());
		theBoard.setTitle(boardArticle.getTitle());
		theBoard.setLikeCount(0L);
		theBoard.setDislikeCount(0L);
		theBoard.setHits(0L);
		theBoard.setUser(theUser);
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		
		theBoard.setCreateDate(currentTime);
		
		BoardLike boardLike  = new BoardLike();
		
		boardLike.setUser(theUser);
		boardLike.setBoard(theBoard);
		boardLike.setLiked(0);
		
		List<BoardLike> li = new ArrayList<>();
		li.add(boardLike);
		theBoard.setBoardLike(li);
		
		boardDao.saveBoard(theBoard);
		boardLikeDao.saveBoardLike(boardLike);
	}

	@Override
	@Transactional
	public void deleteBoard(Long theId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void likeBoard(Long theId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void dislikeBoard(Long theId) {
		// TODO Auto-generated method stub
		
	}

}
