package com.dhy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhy.domain.BoardVO;
import com.dhy.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("hotList", service.getHotList());
		model.addAttribute("recentList", service.getRecentList());
		model.addAttribute("randomList", service.getRandomList());
		return "home";
	}
	
	@RequestMapping(value = "getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model) {
		return "boardList";
	}
	
	@RequestMapping(value = "getSearchList", method = RequestMethod.GET)
	public String getSearchList(String keyword, Model model) {
		model.addAttribute("searchList", service.getSearchList(keyword));
		model.addAttribute("keyword", keyword);
		return "board/boardList";
	}
	
	@RequestMapping(value = "getBoard", method = RequestMethod.GET)
	public String getBoard(String title, Model model) {
		model.addAttribute("content", service.getBoard(title));
		return "board/board";
	}
	
	@RequestMapping(value = "insertBoard", method = RequestMethod.GET)
	public String insertBoard(String title, Model model) {
		model.addAttribute("title", title);
		return "board/insertBoard";
	}
	
	@RequestMapping(value = "insertBoard", method = RequestMethod.POST)
	public String insertBoard(String title, String text, HttpSession session, Model model) {
		service.insertBoard(title, text, (String)session.getAttribute("id"));
		model.addAttribute("content", service.getBoard(title));
		return "board/board";
	}

}
