package com.proj.bindingEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.proj.validation.FieldMatch;
import com.proj.validation.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "pw", second = "matchingPw", message = "The password fields must match")
})
public class BulletinUser {


	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String id;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String pw;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPw;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;

	public BulletinUser() {

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

	public String getMatchingPw() {
		return matchingPw;
	}

	public void setMatchingPw(String matchingPw) {
		this.matchingPw = matchingPw;
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

}
