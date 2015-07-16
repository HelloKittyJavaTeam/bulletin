package it.hellokitty.gt.bulletin.entity;

import it.hellokitty.gt.bulletin.utils.Utils;
import it.hellokitty.gt.entity.BaseObject;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Index;

@Entity
@Table(name = "BULLETIN")
@NamedQueries({
    @NamedQuery(name=Bulletin.ALL,
                query="SELECT a FROM Bulletin a"),
    @NamedQuery(name=Bulletin.IDENTITY,
                query="SELECT a FROM Bulletin a WHERE a.id = :id"),
    @NamedQuery(name=Bulletin.FIND_BY_TAG,
    			query="SELECT b FROM Bulletin b WHERE b.id IN (SELECT t.bulletin.id FROM Tag t WHERE t.word = :word)"),
    @NamedQuery(name=Bulletin.FIND_BY_TAG_ADMIN,
    			query="SELECT b FROM Bulletin b WHERE b.id IN (SELECT t.bulletin.id FROM Tag t WHERE t.word = :word) AND b.active = 1"),
    @NamedQuery(name=Bulletin.FIND_BY_TAG_LIKE,
    			query="SELECT b FROM Bulletin b WHERE b.id IN (SELECT t.bulletin.id FROM Tag t WHERE t.word LIKE :word)"),
    @NamedQuery(name=Bulletin.FIND_BY_TAG_LIKE_ADMIN,
    			query="SELECT b FROM Bulletin b WHERE b.id IN (SELECT t.bulletin.id FROM Tag t WHERE t.word LIKE :word) AND b.active = 1")
    })
public class Bulletin extends BaseObject implements Serializable{
	private static final long serialVersionUID = -1647039563610840864L;
	public static final String ALL = "Bulletin.ALL";
	public static final String IDENTITY = "Bulletin.IDENTITY";
	public static final String FIND_BY_TAG ="Bulletin.FIND_BY_TAG";
	public static final String FIND_BY_TAG_ADMIN ="Bulletin.FIND_BY_TAG_ADMIN";
	public static final String FIND_BY_TAG_LIKE ="Bulletin.FIND_BY_TAG_LIKE";
	public static final String FIND_BY_TAG_LIKE_ADMIN ="Bulletin.FIND_BY_TAG_LIKE_ADMIN";
	
	@Transient
	Utils utils = new Utils();
	
	@Id 
	@GeneratedValue(generator = "SEQ_BULLETIN_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_BULLETIN_ID", allocationSize = 1, initialValue = 0)
	@Basic(optional = false)
	@Column(name="ID")
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="TECHAREA_ID")
	private TechAreaDept techAreaDept;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="BULLETIN_ID", referencedColumnName="ID")
	private List<Tag> tags;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="BULLETIN_ID", referencedColumnName="ID")
	private List<BulletinUser> bulletinUsers;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="BULLETIN_ID", referencedColumnName="ID")
	private List<Attachment> bulletinAttachments;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_DEALER",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="ID_DEALER"))
	private List<Dealers> dealers;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_VEHICLE_FAMILY",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="VEHICLE_FAMILY_ID"))
	private List<VehicleFamily> vehicleFamilies;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_VEHICLE_GROUP",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="VEHICLE_GROUP_ID"))
	private List<VehicleGroups> vehicleGroups;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_VEHICLE_MASTER",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="VEHICLE_MASTER_ID"))
	private List<VehicleMaster> vehicleMasters;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_CONTACT",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="EMAILCONTACT_ID"))
	private List<EmailContact> emailContacts;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_MAILINGLIST",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="MAILINGLIST_ID"))
	private List<MailingList> mailingLists;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_GEOAREA",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="ID_AREA"))
	private List<GeoAreas> Areas;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_REGION",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="ID_REGION"))
	private List<GeoRegions> regions;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="BULLETIN_COUNTRY",
			joinColumns=@JoinColumn(name="BULLETIN_ID"),
			inverseJoinColumns=@JoinColumn(name="ID_COUNTRY"))
	private List<GeoCountries> countries;
	
	@Column(name="PRIORITY",length=20)
	private String priority;
	
	@Column(name="STATUS",length=20)
	private String status;

	@Index
	@Column(name="IT_TITLE")
	private String titleIt;

	@Index
	@Column(name="IT_DESCRIPTION")
	private String descriptionIt;

	@Index
	@Column(name="IT_CONTENT")
	private String contentIt;

	@Index
	@Column(name="EN_TITLE")
	private String titleEn;

	@Index
	@Column(name="EN_DESCRIPTION")
	private String descriptionEn;

	@Index
	@Column(name="EN_CONTENT")
	private String contentEn;

	@Index
	@Column(name="FR_TITLE")
	private String titleFr;

	@Index
	@Column(name="FR_DESCRIPTION")
	private String descriptionFr;

	@Index
	@Column(name="FR_CONTENT")
	private String contentFr;

	@Index
	@Column(name="ES_TITLE")
	private String titleEs;

	@Index
	@Column(name="ES_DESCRIPTION")
	private String descriptionEs;

	@Index
	@Column(name="ES_CONTENT")
	private String contentEs;

	@Index
	@Column(name="JP_TITLE")
	private String titleJp;

	@Index
	@Column(name="JP_DESCRIPTION")
	private String descriptionJp;

	@Index
	@Column(name="JP_CONTENT")
	private String contentJp;

	@Index
	@Column(name="ZH_TITLE")
	private String titleZh;

	@Index
	@Column(name="ZH_DESCRIPTION")
	private String descriptionZh;

	@Index
	@Column(name="ZH_CONTENT")
	private String contentZh;

	@Index
	@Column(name="DE_TITLE")
	private String titleDe;

	@Index
	@Column(name="DE_DESCRIPTION")
	private String descriptionDe;

	@Index
	@Column(name="DE_CONTENT")
	private String contentDe;
	
	public Bulletin(){}
	
	public Bulletin(String user){
		super(user);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TechAreaDept getTechAreaDept() {
		return techAreaDept;
	}

	public void setTechAreaDept(TechAreaDept techAreaDept) {
		this.techAreaDept = techAreaDept;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Attachment> getBulletinAttachments() {
		return bulletinAttachments;
	}

	public void setBulletinAttachments(List<Attachment> bulletinAttachments) {
		this.bulletinAttachments = bulletinAttachments;
	}

	public List<Dealers> getDealers() {
		return dealers;
	}

	public void setDealers(List<Dealers> dealers) {
		this.dealers = dealers;
	}

	public List<EmailContact> getEmailContacts() {
		return emailContacts;
	}

	public void setEmailContacts(List<EmailContact> emailContacts) {
		this.emailContacts = emailContacts;
	}

	public List<MailingList> getMailingLists() {
		return mailingLists;
	}

	public void setMailingLists(List<MailingList> mailingLists) {
		this.mailingLists = mailingLists;
	}

	public List<GeoAreas> getAreas() {
		return Areas;
	}

	public void setGeoAreas(List<GeoAreas> geoAreas) {
		this.Areas = geoAreas;
	}

	public List<GeoRegions> getRegions() {
		return regions;
	}

	public void setRegions(List<GeoRegions> regions) {
		this.regions = regions;
	}

	public List<GeoCountries> getCountries() {
		return countries;
	}

	public void setCountries(List<GeoCountries> countries) {
		this.countries = countries;
	}

	public String getTitleIt() {
		return titleIt;
	}

	public void setTitleIt(String titleIt) {
		this.titleIt = titleIt;
	}

	public String getDescriptionIt() {
		return descriptionIt;
	}

	public void setDescriptionIt(String descriptionIt) {
		this.descriptionIt = descriptionIt;
	}

	public String getContentIt() {
		return contentIt;
	}

	public void setContentIt(String contentIt) {
		this.contentIt = contentIt;
	}

	public String getTitleEn() {
		return titleEn;
	}

	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getContentEn() {
		return contentEn;
	}

	public void setContentEn(String contentEn) {
		this.contentEn = contentEn;
	}

	public String getTitleFr() {
		return titleFr;
	}

	public void setTitleFr(String titleFr) {
		this.titleFr = titleFr;
	}

	public String getDescriptionFr() {
		return descriptionFr;
	}

	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}

	public String getContentFr() {
		return contentFr;
	}

	public void setContentFr(String contentFr) {
		this.contentFr = contentFr;
	}

	public String getTitleEs() {
		return titleEs;
	}

	public void setTitleEs(String titleEs) {
		this.titleEs = titleEs;
	}

	public String getDescriptionEs() {
		return descriptionEs;
	}

	public void setDescriptionEs(String descriptionEs) {
		this.descriptionEs = descriptionEs;
	}

	public String getContentEs() {
		return contentEs;
	}

	public void setContentEs(String contentEs) {
		this.contentEs = contentEs;
	}

	public String getTitleJp() {
		return titleJp;
	}

	public void setTitleJp(String titleJp) {
		this.titleJp = titleJp;
	}

	public String getDescriptionJp() {
		return descriptionJp;
	}

	public void setDescriptionJp(String descriptionJp) {
		this.descriptionJp = descriptionJp;
	}

	public String getContentJp() {
		return contentJp;
	}

	public void setContentJp(String contentJp) {
		this.contentJp = contentJp;
	}

	public String getTitleZh() {
		return titleZh;
	}

	public void setTitleZh(String titleZh) {
		this.titleZh = titleZh;
	}

	public String getDescriptionZh() {
		return descriptionZh;
	}

	public void setDescriptionZh(String descriptionZh) {
		this.descriptionZh = descriptionZh;
	}

	public String getContentZh() {
		return contentZh;
	}

	public void setContentZh(String contentZh) {
		this.contentZh = contentZh;
	}

	public String getTitleDe() {
		return titleDe;
	}

	public void setTitleDe(String titleDe) {
		this.titleDe = titleDe;
	}

	public String getDescriptionDe() {
		return descriptionDe;
	}

	public void setDescriptionDe(String descriptionDe) {
		this.descriptionDe = descriptionDe;
	}

	public String getContentDe() {
		return contentDe;
	}

	public void setContentDe(String contentDe) {
		this.contentDe = contentDe;
	}

	public List<BulletinUser> getBulletinUsers() {
		return bulletinUsers;
	}

	public void setBulletinUsers(List<BulletinUser> bulletinUsers) {
		this.bulletinUsers = bulletinUsers;
	}
	
	public String getTitle(String language){
		String result = null;
		try {
			Method method = this.getClass().getMethod(utils.getTitleMap().get(language));
			result = (String) method.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String getDescription(String language){
		String result = null;
		try {
			Method method = this.getClass().getMethod(utils.getDescriptionMap().get(language));
			result = (String) method.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String getContent(String language){
		String result = null;
		try {
			Method method = this.getClass().getMethod(utils.getContentMap().get(language));
			result = (String) method.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public List<VehicleFamily> getVehicleFamilies() {
		return vehicleFamilies;
	}

	public void setVehicleFamilies(List<VehicleFamily> vehicleFamilies) {
		this.vehicleFamilies = vehicleFamilies;
	}

	public List<VehicleGroups> getVehicleGroups() {
		return vehicleGroups;
	}

	public void setVehicleGroups(List<VehicleGroups> vehicleGroups) {
		this.vehicleGroups = vehicleGroups;
	}

	public List<VehicleMaster> getVehicleMasters() {
		return vehicleMasters;
	}

	public void setVehicleMasters(List<VehicleMaster> vehicleMasters) {
		this.vehicleMasters = vehicleMasters;
	}

	public void setAreas(List<GeoAreas> areas) {
		Areas = areas;
	}
}