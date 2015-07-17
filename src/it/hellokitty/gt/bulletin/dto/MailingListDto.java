package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.dto.BaseObjectDto;

import java.io.Serializable;
import java.util.List;

public class MailingListDto extends BaseObjectDto implements Serializable{

	private Long id;
	
	private String name;
	
	public MailingListDto(){}
	
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
