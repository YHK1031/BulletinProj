package com.proj.service;

import java.util.List;

import com.proj.bindingEntity.BoardArticle;
import com.proj.entity.Board;

public interface BoardService {

	public List<Board> getBoards();
	
	public Board getBoard(Long theId);
	
	public void saveBoard(BoardArticle boardArticle);	
	
	public void deleteBoard(Long theId);
	
	public void likeBoard(Long theId);
	
	public void dislikeBoard(Long theId);
}
