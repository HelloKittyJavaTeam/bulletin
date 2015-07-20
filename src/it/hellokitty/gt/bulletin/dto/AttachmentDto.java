package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.dto.BaseObjectDto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class AttachmentDto extends BaseObjectDto implements Serializable{
	
	private static final long serialVersionUID = 8782608453442997818L;

	private Long id;

	private String attachment;
	
	private String fileName;

	public AttachmentDto(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * This method returns an AttachmentDTO of the attachment input parameter
	 * 
	 * @param attachment
	 * @return AttachmentDto
	 */
	public static AttachmentDto from( final Attachment attachment ) {
		AttachmentDto dto = new AttachmentDto();
		dto.setActive(attachment.isActive());
		dto.setAttachment(attachment.getAttachment());
		dto.setCreateDate(attachment.getCreateDate());
		dto.setFileName(attachment.getFileName());
		dto.setId(attachment.getId());
		dto.setUpdateDate(attachment.getUpdateDate());
		dto.setUserCreate(attachment.getUserCreate());
	    dto.setUserUpdate(attachment.getUserUpdate());	
		return dto;
	}
	
	/**
	 * This method returns a List of AttachmentDTO of the List of attachment input parameter
	 * 
	 * @param attachment List
	 * @return AttachmentDto List
	 */
	public static List<AttachmentDto> from( final List<Attachment> attachments ) {
		final List<AttachmentDto> attachmentsDto = new LinkedList<AttachmentDto>();
		for ( final Attachment attachment : attachments ) {
			attachmentsDto.add( from( attachment ) );
		}
		return attachmentsDto;
	}
}