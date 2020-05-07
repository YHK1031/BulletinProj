package com.proj.dao;

import java.util.List;

import com.proj.entity.BoardLike;

public interface BoardLikeDao {

	public List<BoardLike> getBoardLikes();
	
	public BoardLike getBoardLike(Long theId);
	
	public void saveBoardLike(BoardLike theBoard);	
	
	public void deleteBoardLike(Long theId);
	
}
