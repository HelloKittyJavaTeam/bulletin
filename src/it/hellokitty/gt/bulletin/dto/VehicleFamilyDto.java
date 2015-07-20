package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.VehicleFamily;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class VehicleFamilyDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7109826231223968886L;

	private String id;
	
	private String active;

	private Date dateIns;

	private Date dateMod;

	private String description;

	private String userIns;

	private String userMod;
	
	
	public VehicleFamilyDto() {
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
			this.active = "N";
		}
	}

	public Date getDateIns() {
		return this.dateIns;
	}

	public void setDateIns(Date dateIns) {
		this.dateIns = dateIns;
	}

	public Date getDateMod() {
		return this.dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserIns() {
		return this.userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUserMod() {
		return this.userMod;
	}

	public void setUserMod(String userMod) {
		this.userMod = userMod;
	}
	
	/**
	 * This method returns an VehicleFamilyDto of the vehicleFamilyDept input parameter
	 * 
	 * @param vehicleFamilyDept
	 * @return VehicleFamilyDto
	 */
	public static VehicleFamilyDto from( final VehicleFamily vehicleFamilyDept ) {
		VehicleFamilyDto dto = new VehicleFamilyDto();	
		dto.setActive(vehicleFamilyDept.isActive());
		dto.setDateIns(vehicleFamilyDept.getDateIns());
		dto.setId(vehicleFamilyDept.getId());
		dto.setDateMod(vehicleFamilyDept.getDateMod());
		dto.setDescription(vehicleFamilyDept.getDescription());
		dto.setUserIns(vehicleFamilyDept.getUserIns());
		dto.setUserMod(vehicleFamilyDept.getUserMod());

		return dto;
	}
	
	/**
	 * This method returns a List of VehicleFamilyDto of the List of vehicleFamilyList input parameter
	 * 
	 * @param vehicleFamilyList List
	 * @return VehicleFamilyDto List
	 */
	public static List<VehicleFamilyDto> from( final List<VehicleFamily> vehicleFamilyList ) {
		final List<VehicleFamilyDto> vehicleFamilyListDto = new LinkedList<VehicleFamilyDto>();
		for ( final VehicleFamily vehicleFamily : vehicleFamilyList ) {
			vehicleFamilyListDto.add( from( vehicleFamily ) );
		}
		return vehicleFamilyListDto;
	}
}