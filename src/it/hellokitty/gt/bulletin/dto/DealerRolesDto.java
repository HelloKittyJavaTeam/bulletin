package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.DealerRoles;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DealerRolesDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3248050585802033003L;

	private Long id;

	private String role;

	public DealerRolesDto(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * This method returns an DealerRolesDto of the dealerRoles input parameter
	 * 
	 * @param dealerRoles
	 * @return DealerRolesDto
	 */
	public static DealerRolesDto from( final DealerRoles dealerRoles ) {
		DealerRolesDto dto = new DealerRolesDto();	
		dto.setId(dealerRoles.getId());
		dto.setRole(dealerRoles.getRole());
		return dto;
	}
	
	/**
	 * This method returns a List of DealerRolesDto of the List of dealerRolesList input parameter
	 * 
	 * @param dealerRolesList List
	 * @return DealerRolesDto List
	 */
	public static List<DealerRolesDto> from( final List<DealerRoles> dealerRolesList ) {
		final List<DealerRolesDto> dealerRolesListDto = new LinkedList<DealerRolesDto>();
		for ( final DealerRoles dealerRoles : dealerRolesList ) {
			dealerRolesListDto.add( from( dealerRoles ) );
		}
		return dealerRolesListDto;
	}
}