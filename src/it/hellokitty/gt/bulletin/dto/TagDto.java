package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import it.hellokitty.gt.dto.BaseObjectDto;

public class TagDto extends BaseObjectDto implements Serializable{
	
	private Long id;

	private String word;
	
	public TagDto(){}
	
	public String getWord(){
		return this.word;
	}
	
	public void setWord(String word){
		this.word = word;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}






