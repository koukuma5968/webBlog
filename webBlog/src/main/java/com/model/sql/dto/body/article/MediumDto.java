package com.model.sql.dto.body.article;

import java.util.List;

public class MediumDto {

	private int id;
	private String headLine;
	private String headText;
	private List<SmallDto> smallList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getHeadText() {
		return headText;
	}

	public void setHeadText(String headText) {
		this.headText = headText;
	}

	public List<SmallDto> getSmallList() {
		return smallList;
	}

	public void setSmallList(List<SmallDto> smallList) {
		this.smallList = smallList;
	}

}
