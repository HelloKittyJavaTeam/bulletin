package it.hellokitty.gt.bulletin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the VEHICLE_MASTER database table.
 * 
 */
@Entity
@Table(name="VEHICLE_MASTER")
@NamedQuery(name="VehicleMaster.findAll", query="SELECT x FROM VehicleMaster x")
public class VehicleMaster implements Serializable {
	private static final long serialVersionUID = 5387186627413211422L;

	@Id
	@Column(name="ID")
	private Long id;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_VEHICLE_MASTER",
			joinColumns=@JoinColumn(name="VEHICLE_MASTER_ID"),
			inverseJoinColumns=@JoinColumn(name="BULLETIN_ID"))
	private List<Bulletin> bulletins;
	
	private String active;

	@Column(name="DATE_INS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIns;

	@Column(name="DATE_MOD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMod;

	private String description;

	@Column(name="FLAG_CHALLENGE")
	private String flagChallenge;

	@Column(name="USER_INS")
	private String userIns;

	@Column(name="USER_MOD")
	private String userMod;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="VEHICLE_GROUP_ID", referencedColumnName="ID")
	private VehicleGroups group;

	public VehicleMaster() {
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

	public VehicleGroups getGroup() {
		return group;
	}

	public void setGroup(VehicleGroups group) {
		this.group = group;
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

	public List<Bulletin> getBulletins() {
		return bulletins;
	}

	public void setBulletins(List<Bulletin> bulletins) {
		this.bulletins = bulletins;
	}
}