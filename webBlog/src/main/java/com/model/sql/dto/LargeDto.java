package com.model.sql.dto;

import java.util.List;

public class LargeDto extends BaseDto {

	private String contents;
	private List<MediumDto> mediumList;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<MediumDto> getMediumList() {
		return mediumList;
	}

	public void setMediumList(List<MediumDto> mediumList) {
		this.mediumList = mediumList;
	}

	
}
