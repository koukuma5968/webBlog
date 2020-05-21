package com.controller.builder;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class PageBuilder {

	private RequestMapping[] mapping;

	protected boolean execute(Model model) {

		for (PageBuilderType page : PageBuilderType.values()) {
			model.addAttribute(page.createBody());
		}

		return true;
	}

	protected void request() {
		mapping = super.getClass().getAnnotationsByType(RequestMapping.class);
		for (RequestMapping map : mapping) {
			map.annotationType();
			map.name();
		}
	}
}
