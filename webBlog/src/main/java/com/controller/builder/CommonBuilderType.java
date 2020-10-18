package com.controller.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.model.html.footer.FooterBean;
import com.model.html.header.HeaderBean;
import com.model.sql.dao.CategoryDao;
import com.model.sql.dao.LanguageDao;
import com.model.sql.dto.CategoryMng;
import com.model.sql.dto.LanguageMng;
import com.param.ParamBean;
import com.util.RequestCipher;

public enum CommonBuilderType implements BuilderInterface {

	HEAD("head") {
		@Override
		public Object createBody(ParamBean param) {

			HeaderBean head = new HeaderBean();
			if (param != null) {
				head.setTitle("Home");
			} else {
				head.setTitle("最新記事一覧");
			}
			return head;
		}

	},
	CATEGORY("categoryList") {
		@Override
		public Object createBody(ParamBean param) {

			ArrayList<Object> categoryList = new ArrayList<Object>();
			List<CategoryMng> cateList = CategoryDao.SEL_CATEGORY_MNG();
			Iterator<CategoryMng> it = cateList.iterator();
			while (it.hasNext()) {

				HashMap<String, Object> body = new HashMap<String, Object>();
				CategoryMng cate = it.next();

				ParamBean bean = new ParamBean();
				bean.setId(cate.getId());
				bean.setPath(cate.getName());

				RequestCipher cipr = new RequestCipher();

				body.put("name", cate.getName());
				body.put("encParam", cipr.encode(bean));

				categoryList.add(body);
			}

			return categoryList;
		}

	},
	LANGUAGE("languageList") {

		@Override
		public Object createBody(ParamBean param) {

			ArrayList<Object> languageList = new ArrayList<Object>();
			List<LanguageMng> langList = LanguageDao.SEL_LANGUAGE_MNG();
			Iterator<LanguageMng> it = langList.iterator();
			while (it.hasNext()) {

				HashMap<String, Object> body = new HashMap<String, Object>();
				LanguageMng lang = it.next();

				ParamBean bean = new ParamBean();
				bean.setId(lang.getId());
				bean.setPath(lang.getName());

				RequestCipher cipr = new RequestCipher();

				body.put("name", lang.getName());
				body.put("encParam", cipr.encode(bean));

				languageList.add(body);
			}

			return languageList;
		}
		
	},
	FOOT("foot") {
		@Override
		public Object createBody(ParamBean bean) {

			FooterBean foot = new FooterBean();

			return foot;
		}

	};

	private CommonBuilderType(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return this.key;
	}
}
