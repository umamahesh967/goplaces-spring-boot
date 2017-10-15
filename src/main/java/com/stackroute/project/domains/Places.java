package com.stackroute.project.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Places {
	
	@Id
	@ApiModelProperty(notes = "The database generated product ID")
	private String id;
	
	@ApiModelProperty(notes = "The application-specific product Place Name")
	private String name;
	
	public Places() {
		super();
	}
	
	public Places(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
