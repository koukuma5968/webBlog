package com.model.sql.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.model.sql.dto.Article;

@Mapper
public interface ArticleMapper {

	public Article SEL_ATICLE_BY_ID(String id);
}
