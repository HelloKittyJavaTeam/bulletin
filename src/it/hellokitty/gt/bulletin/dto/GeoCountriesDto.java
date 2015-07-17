package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class GeoCountriesDto implements Serializable {
	
	private String id;
		
	private String descriptionIt;
	
	private String descriptionEn;
	
	private String descriptionFr;
	
	private String descriptionDe;
	
	private String descriptionEs;
	
	private String descriptionZh;
	
	private String descriptionJp;
	
	private Date dateIns;
	
	private Date dateMod;
	
	private String userIns;
	
	private String userMod;
	
	private String active;
	
	private String idIso3166;

	private String idIso31663;
	
	public GeoCountriesDto(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getDescriptionIt() {
		return descriptionIt;
	}

	public void setDescriptionIt(String descriptionIt) {
		this.descriptionIt = descriptionIt;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionFr() {
		return descriptionFr;
	}

	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}

	public String getDescriptionDe() {
		return descriptionDe;
	}

	public void setDescriptionDe(String descriptionDe) {
		this.descriptionDe = descriptionDe;
	}

	public String getDescriptionEs() {
		return descriptionEs;
	}

	public void setDescriptionEs(String descriptionEs) {
		this.descriptionEs = descriptionEs;
	}

	public String getDescriptionZh() {
		return descriptionZh;
	}

	public void setDescriptionZh(String descriptionZh) {
		this.descriptionZh = descriptionZh;
	}

	public String getDescriptionJp() {
		return descriptionJp;
	}

	public void setDescriptionJp(String descriptionJp) {
		this.descriptionJp = descriptionJp;
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
			this.active = "N";
		}
	}

	public String getIdIso3166() {
		return idIso3166;
	}

	public void setIdIso3166(String idIso3166) {
		this.idIso3166 = idIso3166;
	}

	public String getIdIso31663() {
		return idIso31663;
	}

	public void setIdIso31663(String idIso31663) {
		this.idIso31663 = idIso31663;
	}
}
