package com.model.html.body;

import com.model.html.body.side.SideBean;
import com.model.html.body.top.TopBean;
import com.model.sql.dto.body.article.ArticleDto;

public class BodyBean {

	private TopBean top;
	private ArticleDto article;
	private SideBean side;

	public TopBean getTop() {
		return top;
	}

	public void setTop(TopBean top) {
		this.top = top;
	}

	public ArticleDto getArticle() {
		return article;
	}

	public void setArticle(ArticleDto article) {
		this.article = article;
	}

	public SideBean getSide() {
		return side;
	}

	public void setSide(SideBean side) {
		this.side = side;
	}

}
