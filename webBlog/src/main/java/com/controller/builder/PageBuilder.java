package com.controller.builder;

import org.springframework.ui.Model;

import com.param.ParamBean;

public class PageBuilder {

	protected void execute(Model model) {

		for (CommonBuilderType common : CommonBuilderType.values()) {
			model.addAttribute(common.getKey(), common.createBody(null));
		}

		for (TopMenuBuilderType page : TopMenuBuilderType.values()) {
			model.addAttribute(page.getKey(), page.createBody(new ParamBean()));
		}

	}

	public void executeArticle(Model model, ParamBean bean) {

		for (CommonBuilderType common : CommonBuilderType.values()) {
			model.addAttribute(common.getKey(), common.createBody(bean));
		}

		for (PageBuilderType page : PageBuilderType.values()) {
			model.addAttribute(page.getKey(), page.createBody(bean));
		}

	}

	public void executeCategory(Model model, ParamBean bean) {

		for (CommonBuilderType common : CommonBuilderType.values()) {
			model.addAttribute(common.getKey(), common.createBody(bean));
		}

		for (TopMenuBuilderType page : TopMenuBuilderType.values()) {
			model.addAttribute(page.getKey(), page.createBody(bean));
		}

	}
}
