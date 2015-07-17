package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.bulletin.entity.DealerRoles;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Index;

public class DealerRolesDto implements Serializable {
	
	
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
	
	public static DealerRolesDto from( final DealerRoles dealerRoles ) {
		DealerRolesDto dto = new DealerRolesDto();	
		dto.setId(dealerRoles.getId());
		dto.setRole(dealerRoles.getRole());
		return dto;
	}
	
	public static List<DealerRolesDto> from( final List<DealerRoles> dealerRolesList ) {
		final List<DealerRolesDto> dealerRolesListDto = new LinkedList<DealerRolesDto>();
		for ( final DealerRoles dealerRoles : dealerRolesList ) {
			dealerRolesListDto.add( from( dealerRoles ) );
		}
		return dealerRolesListDto;
	}
}