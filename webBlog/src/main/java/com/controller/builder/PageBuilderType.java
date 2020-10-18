package com.controller.builder;

import java.util.HashMap;

import com.model.sql.dao.SideLinkDao;
import com.param.ParamBean;

public enum PageBuilderType implements BuilderInterface {

	ARTICLE("articleBean") {
		@Override
		public Object createBody(ParamBean param) {

			String articleHtml = this.getHtmlPass().concat(param.getPath()).concat(this.getHtml());
			String articleCss = this.getCssPass().concat(param.getPath()).concat(getCss());

			HashMap<String, String> articleBean = new HashMap<String, String>();

			articleBean.put("articleHtml", articleHtml);
			articleBean.put("articleCss", articleCss);

			return articleBean;
		}

	},
	SIDE("sideLink") {
		@Override
		public Object createBody(ParamBean param) {
			return SideLinkDao.SEL_SIDE_LINK(param);
		}
	};

	private PageBuilderType(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return this.key;
	}

	private String htmlPass = "common/article/";
	private String html = "/sheet001.html";
	private String cssPass = "/article/";
	private String css = "/stylesheet.css";

	public String getHtmlPass() {
		return htmlPass;
	}

	public String getHtml() {
		return html;
	}

	public String getCssPass() {
		return cssPass;
	}

	public String getCss() {
		return css;
	}

}
