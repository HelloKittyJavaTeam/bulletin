package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;
import it.hellokitty.gt.dto.BaseObjectDto;
import it.hellokitty.gt.entity.BaseObject;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class AttachmentHistoryDto extends BaseObjectDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6751607621856543302L;

	private Long id;
	
	private Long bulletinId;
	
	private Long nDownload;

	public AttachmentHistoryDto(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBulletinId() {
		return bulletinId;
	}

	public void setBulletinId(Long bulletinId) {
		this.bulletinId = bulletinId;
	}

	public Long getnDownload() {
		return nDownload;
	}

	public void setnDownload(Long nDownload) {
		this.nDownload = nDownload;
	}

	/**
	 * @param attachment
	 * @return
	 */
	public static AttachmentHistoryDto from( final AttachmentHistory attachmentHistory ) {
		AttachmentHistoryDto dto = new AttachmentHistoryDto();
		dto.setActive(attachmentHistory.isActive());
		dto.setId(attachmentHistory.getId());
		dto.setBulletinId(attachmentHistory.getBulletinId());
		dto.setnDownload(attachmentHistory.getnDownload());
		dto.setCreateDate(attachmentHistory.getCreateDate());
		dto.setUpdate(attachmentHistory.getUpdate());
		dto.setUserCreated(attachmentHistory.getUserCreated());
	    dto.setUserUpdate(attachmentHistory.getUserUpdate());	
		return dto;
	}
	
	/**
	 * @param attachment List
	 * @return
	 */
	public static List<AttachmentHistoryDto> from( final List<AttachmentHistory> attachments ) {
		final List<AttachmentHistoryDto> attachmentsDto = new LinkedList<AttachmentHistoryDto>();
		for ( final AttachmentHistory attachment : attachments ) {
			attachmentsDto.add( from( attachment ) );
		}
		return attachmentsDto;
	}
}
