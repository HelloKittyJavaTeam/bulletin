package it.hellokitty.gt.bulletin.dto;

import it.hellokitty.gt.bulletin.entity.TechAreaDept;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TechAreaDeptDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8851296025868333836L;

	private Long id;
	
	private String name;
	
	public TechAreaDeptDto(){}
	
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
	 * This method returns an TechAreaDeptDto of the techAreaDept input parameter
	 * 
	 * @param techAreaDept
	 * @return TechAreaDeptDto
	 */
	public static TechAreaDeptDto from( final TechAreaDept techAreaDept ) {
		TechAreaDeptDto dto = new TechAreaDeptDto();	
		dto.setId(techAreaDept.getId());
		dto.setName(techAreaDept.getName());

		return dto;
	}
	
	/**
	 * This method returns a List of TechAreaDeptDto of the List of techAreaDeptList input parameter
	 * 
	 * @param techAreaDeptList List
	 * @return TechAreaDeptDto List
	 */
	public static List<TechAreaDeptDto> from( final List<TechAreaDept> techAreaDeptList ) {
		final List<TechAreaDeptDto> techAreaDeptListDto = new LinkedList<TechAreaDeptDto>();
		for ( final TechAreaDept techAreaDept : techAreaDeptList ) {
			techAreaDeptListDto.add( from( techAreaDept ) );
		}
		return techAreaDeptListDto;
	}
}