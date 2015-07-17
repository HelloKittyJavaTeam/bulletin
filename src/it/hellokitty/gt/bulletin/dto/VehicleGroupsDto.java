package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class VehicleGroupsDto implements Serializable {
	
	private Long id;
	

	private String active;

	private Date dateIns;

	private Date dateMod;

	private BigDecimal dcsCatalogRelease;

	private BigDecimal dcsCatalogVersion;

	private String familyCode;

	private String dcsVehicleclass;

	private String description;

	private String model;

	private BigDecimal projectId;

	private String suspended;

	private String userIns;

	private String userMod;

	public VehicleGroupsDto() {
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

	public BigDecimal getDcsCatalogRelease() {
		return this.dcsCatalogRelease;
	}

	public void setDcsCatalogRelease(BigDecimal dcsCatalogRelease) {
		this.dcsCatalogRelease = dcsCatalogRelease;
	}

	public BigDecimal getDcsCatalogVersion() {
		return this.dcsCatalogVersion;
	}

	public void setDcsCatalogVersion(BigDecimal dcsCatalogVersion) {
		this.dcsCatalogVersion = dcsCatalogVersion;
	}

	public String getDcsVehicleclass() {
		return this.dcsVehicleclass;
	}

	public void setDcsVehicleclass(String dcsVehicleclass) {
		this.dcsVehicleclass = dcsVehicleclass;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getProjectId() {
		return this.projectId;
	}

	public void setProjectId(BigDecimal projectId) {
		this.projectId = projectId;
	}

	public String getSuspended() {
		return this.suspended;
	}

	public void setSuspended(String suspended) {
		this.suspended = suspended;
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

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}
}