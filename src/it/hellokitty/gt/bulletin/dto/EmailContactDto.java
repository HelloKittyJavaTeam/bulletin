package it.hellokitty.gt.bulletin.dto;

import it.ferrari.gt.dto.BaseObjectDto;
import it.hellokitty.gt.bulletin.entity.EmailContact;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class EmailContactDto extends BaseObjectDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 583005705208883039L;

	private Long id;

    private String email;

	private String name;

    private String surname;

    private String role;

    private String country;

    public EmailContactDto(){}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * This method returns an EmailContactDto of the emailContact input parameter
	 * 
	 * @param emailContact
	 * @return EmailContactDto
	 */
	public static EmailContactDto from( final EmailContact emailContact ) {
		EmailContactDto dto = new EmailContactDto();	
		dto.setId(emailContact.getId());
		dto.setActive(emailContact.isActive());
		dto.setCreateDate(emailContact.getCreateDate());
		dto.setName(emailContact.getName());
		dto.setCountry(emailContact.getCountry());
		dto.setEmail(emailContact.getEmail());
		dto.setRole(emailContact.getRole());
		dto.setSurname(emailContact.getSurname());
		dto.setUpdateDate(emailContact.getUpdateDate());
		dto.setUserCreate(emailContact.getUserCreate());
		dto.setUserUpdate(emailContact.getUserUpdate());
		return dto;
	}
	
	/**
	 * This method returns a List of EmailContactDto of the List of emailContactList input parameter
	 * 
	 * @param emailContactList List
	 * @return EmailContactDto List
	 */
	public static List<EmailContactDto> from( final List<EmailContact> emailContactList ) {
		final List<EmailContactDto> emailContactListDto = new LinkedList<EmailContactDto>();
		for ( final EmailContact emailContact : emailContactList ) {
			emailContactListDto.add( from( emailContact ) );
		}
		return emailContactListDto;
	}
}
