package it.hellokitty.gt.bulletin.dto;

import it.ferrari.gt.dto.BaseObjectDto;
import it.hellokitty.gt.bulletin.entity.AttachmentHistory;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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
	 * This method returns an AttachmentHistoryDto of the attachmentHistory input parameter
	 * 
	 * @param attachment
	 * @return AttachmentHistoryDto
	 */
	public static AttachmentHistoryDto from( final AttachmentHistory attachmentHistory ) {
		AttachmentHistoryDto dto = new AttachmentHistoryDto();
		dto.setActive(attachmentHistory.isActive());
		dto.setId(attachmentHistory.getId());
		dto.setBulletinId(attachmentHistory.getBulletinId());
		dto.setnDownload(attachmentHistory.getnDownload());
		dto.setCreateDate(attachmentHistory.getCreateDate());
		dto.setUpdateDate(attachmentHistory.getUpdateDate());
		dto.setUserCreate(attachmentHistory.getUserCreate());
	    dto.setUserUpdate(attachmentHistory.getUserUpdate());	
		return dto;
	}
	
	/**
	 * This method returns a List of AttachmentHistoryDto of the List of attachmentHistories input parameter
	 * 
	 * @param attachment List
	 * @return AttachmentHistoryDto List
	 */
	public static List<AttachmentHistoryDto> from( final List<AttachmentHistory> attachmentHistories ) {
		final List<AttachmentHistoryDto> attachmentsDto = new LinkedList<AttachmentHistoryDto>();
		for ( final AttachmentHistory attachmentHistory : attachmentHistories ) {
			attachmentsDto.add( from( attachmentHistory ) );
		}
		return attachmentsDto;
	}
}
