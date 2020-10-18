package com.model.sql.dao;

import java.util.List;

import com.model.sql.dto.LanguageMng;

public class LanguageDao extends DaoBase {

	public static List<LanguageMng> SEL_LANGUAGE_MNG() {
		return articleMapper.SEL_LANGUAGE_MNG();
	}
}
