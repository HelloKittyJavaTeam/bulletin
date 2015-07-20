package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.BulletinUser;
import it.hellokitty.gt.dto.BaseObjectDto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class BulletinUserDto extends BaseObjectDto implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 8753027010691127118L;

	private Long id;
	
	private String userName;

	private Boolean download;
	
	private Long nRead;

	public BulletinUserDto(){}
	
	public Long getId(){
		return id;
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

	/**
	 * This method returns an BulletinDto of the bulletin input parameter
	 * 
	 * @param bulletinUser
	 * @return BulletinUserDto
	 */
	public static BulletinUserDto from( final BulletinUser bulletinUser ) {
		BulletinUserDto dto = new BulletinUserDto();
		dto.setActive(bulletinUser.isActive());
		dto.setCreateDate(bulletinUser.getCreateDate());
		dto.setDownload(bulletinUser.getDownload());
		dto.setnRead(bulletinUser.getnRead());
		dto.setId(bulletinUser.getId());
		dto.setUpdateDate(bulletinUser.getUpdateDate());
		dto.setUserCreate(bulletinUser.getUserCreate());
	    dto.setUserUpdate(bulletinUser.getUserUpdate());	
		return dto;
	}
	
	/**
	 * This method returns a List of BulletinUserDto of the List of bulletinUsers input parameter
	 * 
	 * @param bulletinUsers List
	 * @return BulletinUserDto List
	 */
	public static List<BulletinUserDto> from( final List<BulletinUser> bulletinUsers ) {
		final List<BulletinUserDto> bulletinUsersDto = new LinkedList<BulletinUserDto>();
		for ( final BulletinUser bulletinUser : bulletinUsers ) {
			bulletinUsersDto.add( from( bulletinUser ) );
		}
		return bulletinUsersDto;
	}
}