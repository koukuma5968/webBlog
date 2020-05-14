package com.model.sql.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.model.sql.dto.body.article.ArticleDto;

@Mapper
public interface ArticleMapper {

	public ArticleDto SEL_ATICLE_BY_ID(String id);
}
