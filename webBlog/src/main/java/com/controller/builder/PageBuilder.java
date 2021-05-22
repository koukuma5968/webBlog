package com.controller.builder;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.param.ParamBean;
import com.util.FileUtil;
import com.util.Historylog;

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

	public void executeContent(Model model, ParamBean bean) {

		for (CommonBuilderType common : CommonBuilderType.values()) {
			model.addAttribute(common.getKey(), common.createBody(bean));
		}

		for (ContentDownloadBuilderType page : ContentDownloadBuilderType.values()) {
			model.addAttribute(page.getKey(), page.createBody(bean));
		}

	}

	protected HashMap<String, Object> executeApi() {

		HashMap<String, Object> ret = new HashMap<String, Object>();
		for (CommonBuilderType common : CommonBuilderType.values()) {
			ret.put(common.getKey(), common.createBody(null));
		}

		for (TopMenuBuilderType page : TopMenuBuilderType.values()) {
			ret.put(page.getKey(), page.createBody(new ParamBean()));
		}

		return ret;
	}

	public void executeDownload(ParamBean bean, HttpServletResponse response, String userAgent) {

		Historylog.setDownloadHistory(userAgent);
		FileUtil.downloadFile(response, bean.getPath(), bean.getFilename());
	}

}
