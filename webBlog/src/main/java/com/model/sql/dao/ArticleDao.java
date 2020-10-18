package com.model.sql.dao;

import java.util.List;

import com.model.sql.dto.ArticleMNG;

public class ArticleDao extends DaoBase {

	public static List<ArticleMNG> getArticleMNG() {
		return articleMapper.SEL_ARTILCE_MNG();
	}
}
