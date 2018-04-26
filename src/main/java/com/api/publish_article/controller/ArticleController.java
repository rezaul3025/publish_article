package com.api.publish_article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(name="/")
public class ArticleController {

	public ArticleController() {
		
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String navIndex(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/article_list", method=RequestMethod.GET)
	public String navArticleList(Model model) {
		return "article_list";
	}

}
