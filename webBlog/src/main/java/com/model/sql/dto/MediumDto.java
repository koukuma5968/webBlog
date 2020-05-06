package com.model.sql.dto;

import java.util.List;

public class MediumDto extends BaseDto {

	private List<SmallDto> smallList;

	public List<SmallDto> getSmallList() {
		return smallList;
	}

	public void setSmallList(List<SmallDto> smallList) {
		this.smallList = smallList;
	}
}
