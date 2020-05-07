package com.proj.dao;

import java.util.List;

import com.proj.entity.Board;

public interface BoardDao {

	public List<Board> getBoards();
	
	public Board getBoard(String theId);
	
	public void saveBoard(Board theBoard);	
	
	public void deleteBoard(String theId);
	
}
