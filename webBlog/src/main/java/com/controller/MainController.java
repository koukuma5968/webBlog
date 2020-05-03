package com.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(name="main", path="/top")
	public String sidemenu(Model model) {
		model.addAttribute("title", "ブログ（仮）");
		model.addAttribute("Largeitem", "Spring WEBアプリケーション");
		model.addAttribute("Largetext", "Spring bootを使ったWEBアプリケーションの作成");

		String[] strs = {"> ホーム", "> java"};
		ArrayList<HashMap<String, String>> headLinkList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> linkMap = null;
		for (String str : strs) {
			linkMap = new HashMap<String, String>();
			linkMap.put("link", str);
			headLinkList.add(linkMap);
		}

		model.addAttribute("headLinkList", headLinkList);

		return "main/main";
	}
}
