package com.proj.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user_tb")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class User {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "PW")
	private String pw;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "VALIDITY")
	private int validity;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="role_id")
	private Role role;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="BoardIdx")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Board> boards;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="BoardLikeIdx")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BoardLike> boardLike;
	
	public User() {
	}
	
	public User(String id, String pw, String firstName, String lastName, String email, int validity, Role role,
			List<Board> boards, List<BoardLike> boardLike) {
		this.id = id;
		this.pw = pw;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.validity = validity;
		this.role = role;
		this.boards = boards;
		this.boardLike = boardLike;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public List<Board> getBoards() {
		return boards;
	}

	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	public List<BoardLike> getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(List<BoardLike> boardLike) {
		this.boardLike = boardLike;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", validity=" + validity + ", role=" + role + "]";
	}

}
