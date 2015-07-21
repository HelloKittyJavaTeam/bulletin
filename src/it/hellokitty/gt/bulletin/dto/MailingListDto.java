package it.hellokitty.gt.bulletin.dto;

import it.ferrari.gt.dto.BaseObjectDto;
import it.hellokitty.gt.bulletin.entity.MailingList;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MailingListDto extends BaseObjectDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3657542882396675329L;

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
	
	/**
	 * This method returns an MailingListDto of the mailingList input parameter
	 * 
	 * @param mailingList
	 * @return MailingListDto
	 */
	public static MailingListDto from( final MailingList mailingList ) {
		MailingListDto dto = new MailingListDto();	
		dto.setId(mailingList.getId());
		dto.setActive(mailingList.isActive());
		dto.setCreateDate(mailingList.getCreateDate());
		dto.setName(mailingList.getName());
		dto.setUpdateDate(mailingList.getUpdateDate());
		dto.setUserCreate(mailingList.getUserCreate());
		dto.setUserUpdate(mailingList.getUserUpdate());

		return dto;
	}
	
	/**
	 * This method returns a List of MailingListDto of the List of mailingList input parameter
	 * 
	 * @param mailingList List
	 * @return MailingListDto List
	 */
	public static List<MailingListDto> from( final List<MailingList> mailingList ) {
		final List<MailingListDto> mailingListListDto = new LinkedList<MailingListDto>();
		for ( final MailingList mailingListElem : mailingList ) {
			mailingListListDto.add( from( mailingListElem ) );
		}
		return mailingListListDto;
	}
}
