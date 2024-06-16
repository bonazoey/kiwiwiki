package com.dhy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dhy.domain.MemberVO;
import com.dhy.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getloginPage() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String pw, HttpServletRequest request, Model model) {
		System.out.println("[INFO] 로그인 시도");
		MemberVO vo = memberService.login(id, pw);
		if (vo == null) {
			model.addAttribute("msg", "로그인 정보가 알맞지 않습니다.");
			return "login/login";
		}
		HttpSession session = request.getSession();
		System.out.println("[INFO] 로그인 성공 ID : " + vo.getId());
		session.setAttribute("info", vo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
