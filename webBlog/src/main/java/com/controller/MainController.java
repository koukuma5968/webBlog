package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.builder.PageBuilder;
import com.model.sql.dao.ArticleDao;
import com.model.sql.mapper.ArticleMapper;

@Controller
public class MainController extends PageBuilder {

	public MainController(ArticleMapper mapper) {
		ArticleDao.articleMapper = mapper;
	}

	@RequestMapping(name="main", path="/top")
	public String sidemenu(Model model) {

		super.execute(model);

		return "main/top";
	}
}
