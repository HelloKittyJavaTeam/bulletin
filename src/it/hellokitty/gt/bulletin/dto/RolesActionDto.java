package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.dto.BaseObjectDto;
import java.io.Serializable;

public class RolesActionDto extends BaseObjectDto implements Serializable{

	
	private Long id;
	
	private String roles;
	
	private String action;
	
	public RolesActionDto(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
