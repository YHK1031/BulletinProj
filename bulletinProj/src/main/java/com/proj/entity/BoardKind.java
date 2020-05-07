package com.proj.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOARD_KIND_TB")
public class BoardKind {

	@Id
	@Column(name = "BoardKindId")
	private String boardKindId;
	
	@Column(name = "BoardKindName")
	private String boardKindName;
	
	@OneToMany(mappedBy="boardKind", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boards;

	public String getBoardKindId() {
		return boardKindId;
	}

	public void setBoardKindId(String boardKindId) {
		this.boardKindId = boardKindId;
	}

	public String getBoardKindName() {
		return boardKindName;
	}

	public void setBoardKindName(String boardKindName) {
		this.boardKindName = boardKindName;
	}

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}
	
	
	
}
