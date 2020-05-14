package com.model.sql.dao;

import com.model.sql.dto.body.article.ArticleDto;
import com.model.sql.mapper.ArticleMapper;

public class ArticleDao {

	public static ArticleMapper articleMapper = null;

	public static ArticleDto getArticle(String id) {

		return articleMapper.SEL_ATICLE_BY_ID(id);

	}

}
