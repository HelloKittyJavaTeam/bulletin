package it.hellokitty.gt.bulletin.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import it.hellokitty.gt.bulletin.entity.Attachment;
import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.dto.BaseObjectDto;

public class BulletinUserDto extends BaseObjectDto implements Serializable{
		
	private Long id;
	
	private String userName;

	private Boolean download;
	
	private Long nRead;

	public BulletinUserDto(){
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDownload() {
		return download;
	}

	public void setDownload(Boolean download) {
		this.download = download;
	}

	public Long getnRead() {
		return nRead;
	}

	public void setnRead(Long nRead) {
		this.nRead = nRead;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static BulletinUserDto from( final BulletinUser bulletinUser ) {
		BulletinUserDto dto = new BulletinUserDto();
		dto.setActive(bulletinUser.isActive());
		dto.setCreateDate(bulletinUser.getCreateDate());
		dto.setDownload(bulletinUser.getDownload());
		dto.setnRead(bulletinUser.getnRead());
		dto.setId(bulletinUser.getId());
		dto.setUpdate(bulletinUser.getUpdate());
		dto.setUserCreated(bulletinUser.getUserCreated());
	    dto.setUserUpdate(bulletinUser.getUserUpdate());	
		return dto;
	}
	
	public static List<BulletinUserDto> from( final List<BulletinUser> bulletinUsers ) {
		final List<BulletinUserDto> bulletinUsersDto = new LinkedList<BulletinUserDto>();
		for ( final BulletinUser bulletinUser : bulletinUsers ) {
			bulletinUsersDto.add( from( bulletinUser ) );
		}
		return bulletinUsersDto;
	}
}