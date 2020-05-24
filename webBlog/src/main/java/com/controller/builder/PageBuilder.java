package com.controller.builder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class PageBuilder {

	private RequestMapping[] mapping;

	protected boolean execute(Model model) {

//		BufferedReader html = null;
//		BufferedWriter out = null;
//		try {
//			html = new BufferedReader(new FileReader(this.getClass().getResource("/").getPath().concat("/templates/common/article/SpringToolInst/SpringToolInst.html")));
//
//			String str = null;
//			while ((str = html.readLine()) != null) {
//				int index = str.indexOf(">T1<");
//				if (index > 0) {
//					System.out.println(str);
//					str = str.replace(">T1<", " id='T1'>T1<");
//				}
//			}
//			out = new BufferedWriter(new FileWriter(this.getClass().getResource("/").getPath().concat("/templates/common/article/SpringToolInst/SpringToolInst.html")));
//			out.write(str);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				html.close();
//				out.flush();
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
