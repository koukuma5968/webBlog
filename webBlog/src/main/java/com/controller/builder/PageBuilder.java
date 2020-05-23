package com.controller.builder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class PageBuilder {

	private RequestMapping[] mapping;

	protected boolean execute(Model model) {

//		BufferedReader html = null;
//		try {
//			html = new BufferedReader(new FileReader(this.getClass().getResource("/").getPath().concat("/templates/common/article/sheet001.html")));
//
//			String str = null;
//			while ((str = html.readLine()) != null) {
//				System.out.println(str);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				html.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

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
