package com.proj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "board_like_tb")
public class BoardLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BoardLikeIdx")
	private Long boardLikeIdx;
	
	@Column(name = "Liked")
	private int liked;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="boardIdx")
	private Board board;

	public BoardLike() {
		
	}
	
	public BoardLike(int liked, User user, Board board) {
		this.liked = liked;
		this.user = user;
		this.board = board;
	}

	public Long getBoardLikeIdx() {
		return boardLikeIdx;
	}

	public void setBoardLikeIdx(Long boardLikeIdx) {
		this.boardLikeIdx = boardLikeIdx;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	
}
