package com.dhy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhy.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model) {
		return "boardList";
	}
	
	@RequestMapping(value = "getSearchList", method = RequestMethod.GET)
	public String getSearchList(String keyword, Model model) {
		model.addAttribute("searchList", service.getSearchList(keyword));
		return "board/boardList";
	}
	
	@RequestMapping(value = "getBoard", method = RequestMethod.GET)
	public String getBoard(String title, Model model) {
		model.addAttribute("content", service.getBoard(title));
		return "board/board";
	}
	
}
