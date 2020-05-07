package com.proj.dao;

import com.proj.entity.BoardKind;

public interface BoardKindDao {

	public BoardKind getBoardKind(String theId);
	
	public void saveBoard(BoardKind theBoardKind);	
	
	public void deleteBoardKind(String theId);
}
