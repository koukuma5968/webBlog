package com.controller.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.model.html.footer.FooterBean;
import com.model.html.header.HeaderBean;
import com.model.sql.dao.ArticleDao;
import com.model.sql.dao.CategoryDao;
import com.model.sql.dao.LanguageDao;
import com.model.sql.dto.ArticleMNG;
import com.model.sql.dto.CategoryMng;
import com.model.sql.dto.LanguageMng;
import com.param.ParamBean;
import com.util.RequestCipher;

public enum CommonBuilderType implements BuilderInterface {

	HEAD("headlist") {
		@Override
		public Object createBody(ParamBean param) {

			ArrayList<HeaderBean> headList = new ArrayList<HeaderBean>();
			HeaderBean head = new HeaderBean();

			head.setTitle("Home");
			head.setLink("/");

			headList.add(head);
			RequestCipher cipr = new RequestCipher();
			head = new HeaderBean();

			if (param != null) {
				if (param.getType() == 0) {
					ArticleMNG amng = ArticleDao.getArticleMNGName(param);
					head.setTitle(amng.getTitle());
				} else {
					head.setTitle(param.getPath());
				}
				head.setLink(param.getName() + cipr.encode(param));
			} else {
				head.setTitle("最新記事一覧");
				head.setLink("/");
			}

			headList.add(head);

			return headList;
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
				bean.setType(1);

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
				bean.setType(2);

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
