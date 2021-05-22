package com.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.builder.PageBuilder;
import com.model.sql.dao.DaoBase;
import com.model.sql.mapper.ArticleMapper;
import com.param.ParamBean;
import com.util.RequestCipher;
import com.util.UserAgentType;

@Controller
public class MainController extends PageBuilder {

	public MainController(ArticleMapper mapper) {
		DaoBase.articleMapper = mapper;
	}

	@RequestMapping(name="home", path="/")
	public String home(Model model, @RequestHeader("User-Agent") String userAgent) {

		String ret = "main/home";
		if (UserAgentType.checkMobile(userAgent)) {
			ret = "mobile/m	home";
		} else {
			super.execute(model);
		}

		return ret;
	}

	@RequestMapping(name="category", path="/category")
	public String category(Model model, @RequestParam("get") String param, @RequestHeader("User-Agent") String userAgent) {

		RequestCipher cipr = new RequestCipher();
		ParamBean bean = cipr.decode(param);
		bean.setName("/category?get=");

		super.executeCategory(model, bean);

		return "main/category";
	}

	@RequestMapping(name="article", path="/article")
	public String article(Model model, @RequestParam("get") String param, @RequestHeader("User-Agent") String userAgent) {

		RequestCipher cipr = new RequestCipher();
		ParamBean bean = cipr.decode(param);
		bean.setName("/article?get=");

		super.executeArticle(model, bean);

		return "main/article";
	}

	@RequestMapping(name="content", path="/content")
	public String content(Model model, @RequestParam("get") String param, @RequestHeader("User-Agent") String userAgent) {

		RequestCipher cipr = new RequestCipher();
		ParamBean bean = cipr.decode(param);

		super.executeContent(model, bean);

		return "main/content";
	}

	@RequestMapping(name="download", path="/download")
	public String download(Model model, @RequestParam("get") String param, @RequestHeader("User-Agent") String userAgent, HttpServletResponse response) {

		RequestCipher cipr = new RequestCipher();
		ParamBean bean = cipr.decode(param);

		super.executeDownload(bean, response, userAgent);

		return null;
	}
}
