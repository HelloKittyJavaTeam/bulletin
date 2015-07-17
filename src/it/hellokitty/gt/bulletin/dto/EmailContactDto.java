package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.dto.BaseObjectDto;

import java.io.Serializable;

public class EmailContactDto extends BaseObjectDto implements Serializable{
	
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
}
