package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.AdUsers;
import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.dto.BaseObjectDto;
import it.hellokitty.gt.entity.BaseObject;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	 * @param attachment
	 * @return
	 */
	public static AttachmentDto from( final Attachment attachment ) {
		AttachmentDto dto = new AttachmentDto();
		dto.setActive(attachment.isActive());
		dto.setAttachment(attachment.getAttachment());
		dto.setCreateDate(attachment.getCreateDate());
		dto.setFileName(attachment.getFileName());
		dto.setId(attachment.getId());
		dto.setUpdate(attachment.getUpdate());
		dto.setUserCreated(attachment.getUserCreated());
	    dto.setUserUpdate(attachment.getUserUpdate());	
		return dto;
	}
	
	/**
	 * @param attachment List
	 * @return
	 */
	public static List<AttachmentDto> from( final List<Attachment> attachments ) {
		final List<AttachmentDto> attachmentsDto = new LinkedList<AttachmentDto>();
		for ( final Attachment attachment : attachments ) {
			attachmentsDto.add( from( attachment ) );
		}
		return attachmentsDto;
	}
}
