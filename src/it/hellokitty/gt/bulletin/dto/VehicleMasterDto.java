package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VehicleMasterDto implements Serializable {

	private Long id;
	
	private String active;

	private Date dateIns;

	private Date dateMod;

	private String description;

	private String flagChallenge;

	private String userIns;

	private String userMod;
	
	public VehicleMasterDto() {
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

	
}