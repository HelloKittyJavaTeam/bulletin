package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.dto.BaseObjectDto;
import it.hellokitty.gt.entity.BaseObject;

import java.io.Serializable;
import java.util.List;



public class DepartmentDto extends BaseObjectDto implements Serializable{
	
	private Long id;
		
	private String name;
		
	public DepartmentDto(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}