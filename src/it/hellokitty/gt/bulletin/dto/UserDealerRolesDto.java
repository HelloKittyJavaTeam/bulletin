package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.UserDealerRoles;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserDealerRolesDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2552604858417127198L;

	private Long id;
	
	private String username;
	
	private String language;
	
	private Date dateIns;

	private Date dateMod;
	
	private String userIns;

	private String userMod;
	
	private String active;

	public UserDealerRolesDto(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getDateIns() {
		return dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateMod() {
		return dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public String getUserIns() {
		return userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUserMod() {
		return userMod;
	}

	public void setUserMod(String userMod) {
		this.userMod = userMod;
	}
	
	public boolean isActive() {
		if(active.equals("Y")){
			return true;
		} else {
			return false;
		}
	}

	public void setActive(boolean active) {
		if(active){
			this.active = "Y";
		} else {
			this.active ="N";
		}
	}
	
	/**
	 * This method returns an UserDealerRolesDto of the userDealerRoles input parameter
	 * 
	 * @param userDealerRoles
	 * @return UserDealerRolesDto
	 */
	public static UserDealerRolesDto from( final UserDealerRoles userDealerRoles ) {
		UserDealerRolesDto dto = new UserDealerRolesDto();	
		dto.setActive(userDealerRoles.isActive());
		dto.setDateIns(userDealerRoles.getDateIns());
		dto.setDateMod(userDealerRoles.getDateMod());
		dto.setId(userDealerRoles.getId());
		dto.setLanguage(userDealerRoles.getLanguage());
		dto.setUserIns(userDealerRoles.getUserIns());
		dto.setUserMod(userDealerRoles.getUserMod());
		dto.setUsername(userDealerRoles.getUsername());

		return dto;
	}
	
	/**
	 * This method returns a List of UserDealerRolesDto of the List of userDealerRolesList input parameter
	 * 
	 * @param userDealerRolesList List
	 * @return UserDealerRolesDto List
	 */
	public static List<UserDealerRolesDto> from( final List<UserDealerRoles> userDealerRolesList ) {
		final List<UserDealerRolesDto> userDealerRolesDto = new LinkedList<UserDealerRolesDto>();
		for ( final UserDealerRoles userDealerRoles : userDealerRolesList ) {
			userDealerRolesDto.add( from( userDealerRoles ) );
		}
		return userDealerRolesDto;
	}
}
