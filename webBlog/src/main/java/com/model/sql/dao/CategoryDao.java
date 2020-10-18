package com.model.sql.dao;

import java.util.List;

import com.model.sql.dto.CategoryMng;

public class CategoryDao extends DaoBase {

	public static List<CategoryMng> SEL_CATEGORY_MNG() {
		return articleMapper.SEL_CATEGORY_MNG();
	}
}
