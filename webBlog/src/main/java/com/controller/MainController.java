package com.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.sql.dao.ArticleDao;
import com.model.sql.mapper.ArticleMapper;

@Controller
public class MainController {

	public MainController(ArticleMapper mapper) {
		ArticleDao.articleMapper = mapper;
	}

	@RequestMapping(name="main", path="/top")
	public String sidemenu(Model model) {
		model.addAttribute("title", "ブログ（仮）");
		model.addAttribute("Largeitem", "Spring WEBアプリケーション");
		model.addAttribute("Largetext", "Spring bootを使ったWEBアプリケーションの作成<BR>導入からプロジェクト作成まで");

		String[] strs = {"> ホーム", "> java"};
		ArrayList<HashMap<String, String>> headLinkList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> linkMap = null;
		for (String str : strs) {
			linkMap = new HashMap<String, String>();
			linkMap.put("link", str);
			headLinkList.add(linkMap);
		}

		model.addAttribute("headLinkList", headLinkList);

		String[][] sidestrs = {{"Title", "Spring WEBアプリケーション"}};

		ArrayList<HashMap<String, String>> sideLinkList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> sidelinkMap = null;
		for (String[] sidestr : sidestrs) {
			sidelinkMap = new HashMap<String, String>();
			sidelinkMap.put("linkid", sidestr[0]);
			sidelinkMap.put("linkitem", sidestr[1]);
			sideLinkList.add(sidelinkMap);
		}

		model.addAttribute("sideLinkList", sideLinkList);

		return "main/main";
	}
}
