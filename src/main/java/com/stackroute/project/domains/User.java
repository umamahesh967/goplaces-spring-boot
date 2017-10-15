package com.stackroute.project.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {
	
	@Id
	@ApiModelProperty(notes = "Accessible  to specific user")
	private String username;
	
	@ApiModelProperty(notes = "Accessible to user password")
	private String password;
	
    //constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//methods
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
