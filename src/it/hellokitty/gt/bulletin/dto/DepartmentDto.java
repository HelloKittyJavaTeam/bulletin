package it.hellokitty.gt.bulletin.dto;

import it.ferrari.gt.dto.BaseObjectDto;
import it.hellokitty.gt.bulletin.entity.Department;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DepartmentDto extends BaseObjectDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 334959886208801656L;

	private Long id;
		
	private String name;
		
	public DepartmentDto(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method returns an DepartmentDto of the department input parameter
	 * 
	 * @param department
	 * @return DepartmentDto
	 */
	public static DepartmentDto from( final Department department ) {
		DepartmentDto dto = new DepartmentDto();	
		dto.setId(department.getId());
		dto.setActive(department.isActive());
		dto.setCreateDate(department.getCreateDate());
		dto.setName(department.getName());
		dto.setUpdateDate(department.getUpdateDate());
		dto.setUserCreate(department.getUserCreate());
		dto.setUserUpdate(department.getUserUpdate());
		return dto;
	}
	
	/**
	 * This method returns a List of DepartmentDto of the List of departmentList input parameter
	 * 
	 * @param departmentList List
	 * @return DepartmentDto List
	 */
	public static List<DepartmentDto> from( final List<Department> departmentList ) {
		final List<DepartmentDto> departmentListDto = new LinkedList<DepartmentDto>();
		for ( final Department dealerRoles : departmentList ) {
			departmentListDto.add( from( dealerRoles ) );
		}
		return departmentListDto;
	}
}