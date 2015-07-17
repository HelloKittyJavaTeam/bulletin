package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.util.List;

import it.hellokitty.gt.dto.BaseObjectDto;




public class TechAreaDeptDto extends BaseObjectDto implements Serializable{
	
	private Long id;
	
	private String name;
	
	public TechAreaDeptDto(){}
	
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
