package com.proj.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "BOARD_TB")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BoardIdx")
	private Long boardIdx;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Content")
	private String content;
	
	@Column(name = "Hits")
	private Long hits;
	
	@Column(name = "CreateDate")
	private String createDate;
	
	@Column(name = "LikeCount")
	private Long likeCount;
	
	@Column(name = "DislikeCount")
	private Long dislikeCount;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="boardKindId")
	private BoardKind boardKind;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="BoardLikeIdx")
	private List<BoardLike> boardLike;
	
	public Board() {
		
	}
	
	public Board(String title, String content, Long hits, String createDate, Long likeCount,
			Long dislikeCount, BoardKind boardKind, User user, List<BoardLike> boardLike) {
		this.title = title;
		this.content = content;
		this.hits = hits;
		this.createDate = createDate;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.boardKind = boardKind;
		this.user = user;
		this.boardLike = boardLike;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public Long getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(Long dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public BoardKind getBoardKind() {
		return boardKind;
	}

	public void setBoardKind(BoardKind boardKind) {
		this.boardKind = boardKind;
	}

	public Long getBoardIdx() {
		return boardIdx;
	}

	public User getUser() {
		return user;
	}

	public List<BoardLike> getBoardLike() {
		return boardLike;
	}

	public void setBoardIdx(Long boardIdx) {
		this.boardIdx = boardIdx;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBoardLike(List<BoardLike> boardLike) {
		this.boardLike = boardLike;
	}

	@Override
	public String toString() {
		return "Board [boardIdx=" + boardIdx + ", title=" + title + ", content=" + content + ", hits=" + hits
				+ ", createDate=" + createDate + ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount
				+ ", user=" + user + ", boardLike=" + boardLike + "]";
	}
	
	
	
}
