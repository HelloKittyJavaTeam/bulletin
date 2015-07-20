package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.Bulletin;
import it.hellokitty.gt.bulletin.utils.Utils;
import it.hellokitty.gt.dto.BaseObjectDto;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;


public class BulletinDto extends BaseObjectDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 641168933380329725L;

	private Long id;
		
	private String priority;

	private String status;

	private String titleIt;

	private String descriptionIt;

	private String contentIt;

	private String titleEn;

	private String descriptionEn;

	private String contentEn;

	private String titleFr;

	private String descriptionFr;

	private String contentFr;

	private String titleEs;

	private String descriptionEs;

	private String contentEs;

	private String titleJp;

	private String descriptionJp;

	private String contentJp;

	private String titleZh;

	private String descriptionZh;

	private String contentZh;

	private String titleDe;

	private String descriptionDe;

	private String contentDe;
	
	public BulletinDto(){}
	
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

	public String getTitle(String language){
		String result = null;
		try {
			Utils utils = new Utils();
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
			Utils utils = new Utils();
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
			Utils utils = new Utils();
			Method method = this.getClass().getMethod(utils.getContentMap().get(language));
			result = (String) method.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * This method returns an BulletinDto of the bulletin input parameter
	 * 
	 * @param bulletin
	 * @return BulletinDto
	 */
	public static BulletinDto from( final Bulletin bulletin ) {
		BulletinDto dto = new BulletinDto();
		dto.setActive(bulletin.isActive());
		dto.setContentDe(bulletin.getContentDe());
		dto.setContentDe(bulletin.getContentEn());
		dto.setContentDe(bulletin.getContentEs());
		dto.setContentDe(bulletin.getContentFr());
		dto.setContentDe(bulletin.getContentIt());
		dto.setContentDe(bulletin.getContentJp());
		dto.setContentDe(bulletin.getContentZh());
		dto.setDescriptionDe(bulletin.getDescriptionDe());
		dto.setDescriptionEn(bulletin.getDescriptionEn());
		dto.setDescriptionEs(bulletin.getDescriptionEs());
		dto.setDescriptionFr(bulletin.getDescriptionFr());
		dto.setDescriptionIt(bulletin.getDescriptionIt());
		dto.setDescriptionJp(bulletin.getDescriptionJp());
		dto.setDescriptionZh(bulletin.getDescriptionZh());
		dto.setId(bulletin.getId());
		dto.setPriority(bulletin.getPriority());
		dto.setStatus(bulletin.getStatus());
		dto.setTitleDe(bulletin.getTitleDe());
		dto.setTitleEn(bulletin.getTitleEn());
		dto.setTitleEs(bulletin.getTitleEs());
		dto.setTitleFr(bulletin.getTitleFr());
		dto.setTitleIt(bulletin.getTitleIt());
		dto.setTitleJp(bulletin.getTitleJp());
		dto.setTitleZh(bulletin.getTitleZh());
		dto.setCreateDate(bulletin.getCreateDate());
		dto.setUpdateDate(bulletin.getUpdateDate());
		dto.setUserCreate(bulletin.getUserCreate());
	    dto.setUserUpdate(bulletin.getUserUpdate());	
		return dto;
	}
	
	/**
	 * This method returns a List of AttachmentHistoryDto of the List of attachmentHistories input parameter
	 * 
	 * @param bullettins List
	 * @return BulletinDto List
	 */
	public static List<BulletinDto> from( final List<Bulletin> bullettins ) {
		final List<BulletinDto> bullettinsDto = new LinkedList<BulletinDto>();
		for ( final Bulletin bulletin : bullettins ) {
			bullettinsDto.add( from( bulletin ) );
		}
		return bullettinsDto;
	}
}