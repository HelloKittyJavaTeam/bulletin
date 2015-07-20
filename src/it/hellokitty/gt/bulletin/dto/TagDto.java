package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.Tag;
import it.hellokitty.gt.dto.BaseObjectDto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TagDto extends BaseObjectDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3747470161564347269L;

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
	
	/**
	 * This method returns an TagDto of the tag input parameter
	 * 
	 * @param tag
	 * @return TagDto
	 */
	public static TagDto from( final Tag tag ) {
		TagDto dto = new TagDto();	
		dto.setActive(tag.isActive());
		dto.setCreateDate(tag.getCreateDate());
		dto.setId(tag.getId());
		dto.setUpdateDate(tag.getUpdateDate());
		dto.setUserCreate(tag.getUserCreate());
		dto.setUserUpdate(tag.getUserUpdate());
		dto.setWord(tag.getWord());

		return dto;
	}
	
	/**
	 * This method returns a List of TagDto of the List of tagList input parameter
	 * 
	 * @param tagList List
	 * @return TagDto List
	 */
	public static List<TagDto> from( final List<Tag> tagList ) {
		final List<TagDto> tagListDto = new LinkedList<TagDto>();
		for ( final Tag tag : tagList ) {
			tagListDto.add( from( tag ) );
		}
		return tagListDto;
	}
}






