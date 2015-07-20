package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.VehicleMaster;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class VehicleMasterDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8985753533361158187L;

	private Long id;
	
	private String active;

	private Date dateIns;

	private Date dateMod;

	private String description;

	private String flagChallenge;

	private String userIns;

	private String userMod;
	
	public VehicleMasterDto() {}

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

	public String getFlagChallenge() {
		return this.flagChallenge;
	}

	public void setFlagChallenge(String flagChallenge) {
		this.flagChallenge = flagChallenge;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
	 * This method returns an VehicleMasterDto of the vehicleMaster input parameter
	 * 
	 * @param vehicleMaster
	 * @return VehicleMasterDto
	 */
	public static VehicleMasterDto from( final VehicleMaster vehicleMaster ) {
		VehicleMasterDto dto = new VehicleMasterDto();	
		dto.setActive(vehicleMaster.isActive());
		dto.setDateIns(vehicleMaster.getDateIns());
		dto.setDateMod(vehicleMaster.getDateMod());
		dto.setDescription(vehicleMaster.getDescription());
		dto.setFlagChallenge(vehicleMaster.getFlagChallenge());
		dto.setId(vehicleMaster.getId());
		dto.setUserIns(vehicleMaster.getUserIns());
		dto.setUserMod(vehicleMaster.getUserMod());

		return dto;
	}
	
	/**
	 * This method returns a List of VehicleMasterDto of the List of vehicleMasterList input parameter
	 * 
	 * @param vehicleMasterList List
	 * @return VehicleMasterDto List
	 */
	public static List<VehicleMasterDto> from( final List<VehicleMaster> vehicleMasterList ) {
		final List<VehicleMasterDto> vehicleMasterListDto = new LinkedList<VehicleMasterDto>();
		for ( final VehicleMaster vehicleMaster : vehicleMasterList ) {
			vehicleMasterListDto.add( from( vehicleMaster ) );
		}
		return vehicleMasterListDto;
	}
}