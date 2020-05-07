package com.proj.bindingEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BoardArticle {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userId;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String title;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String content;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String boardKind;
	
	public BoardArticle() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getBoardKind() {
		return boardKind;
	}

	public void setBoardKind(String boardKind) {
		this.boardKind = boardKind;
	}
	
	
}