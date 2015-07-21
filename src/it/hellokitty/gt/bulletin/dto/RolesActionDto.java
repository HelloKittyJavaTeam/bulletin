package it.hellokitty.gt.bulletin.dto;

import it.ferrari.gt.dto.BaseObjectDto;
import it.hellokitty.gt.bulletin.entity.RolesAction;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RolesActionDto extends BaseObjectDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8290577666602624565L;

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

	/**
	 * This method returns an RolesActionDto of the rolesAction input parameter
	 * 
	 * @param rolesAction
	 * @return RolesActionDto
	 */
	public static RolesActionDto from( final RolesAction rolesAction ) {
		RolesActionDto dto = new RolesActionDto();	
		dto.setId(rolesAction.getId());
		dto.setActive(rolesAction.isActive());
		dto.setCreateDate(rolesAction.getCreateDate());
		dto.setAction(rolesAction.getAction());
		dto.setRoles(rolesAction.getRoles());
		dto.setUpdateDate(rolesAction.getUpdateDate());
		dto.setUserCreate(rolesAction.getUserCreate());
		dto.setUserUpdate(rolesAction.getUserUpdate());

		return dto;
	}
	
	/**
	 * This method returns a List of RolesActionDto of the List of rolesActionList input parameter
	 * 
	 * @param rolesActionList List
	 * @return RolesActionDto List
	 */
	public static List<RolesActionDto> from( final List<RolesAction> rolesActionList ) {
		final List<RolesActionDto> rolesActionListDto = new LinkedList<RolesActionDto>();
		for ( final RolesAction rolesAction : rolesActionList ) {
			rolesActionListDto.add( from( rolesAction ) );
		}
		return rolesActionListDto;
	}
}
