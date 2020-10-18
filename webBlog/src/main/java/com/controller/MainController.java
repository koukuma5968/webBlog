package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.builder.PageBuilder;
import com.model.sql.dao.DaoBase;
import com.model.sql.mapper.ArticleMapper;
import com.param.ParamBean;
import com.util.RequestCipher;

@Controller
public class MainController extends PageBuilder {

	public MainController(ArticleMapper mapper) {
		DaoBase.articleMapper = mapper;
	}

	@RequestMapping(name="home", path="/")
	public String home(Model model) {

		super.execute(model);

		return "main/home";
	}

	@RequestMapping(name="category", path="/category")
	public String category(Model model, @RequestParam("get") String param) {

		RequestCipher cipr = new RequestCipher();
		ParamBean bean = cipr.decode(param);

		super.executeCategory(model, bean);

		return "main/category";
	}

	@RequestMapping(name="article", path="/article")
	public String article(Model model, @RequestParam("get") String param) {

		RequestCipher cipr = new RequestCipher();
		ParamBean bean = cipr.decode(param);

		super.executeArticle(model, bean);

		return "main/article";
	}

}
