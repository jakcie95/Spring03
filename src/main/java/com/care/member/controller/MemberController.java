package com.care.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller//연결역활
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("Mainpage")
	public String Mainpage() {
		return "mvc_quiz/Mainpage";
		//리턴 경로와 jsp경로가 같으면 리턴 생략 가능
	}
	@GetMapping("register_form")
	public String registerForm() {
		return "mvc_quiz/register_form";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		ms.register(dto);
		return "mvc_quiz/Mainpage";
	}
	@GetMapping("list")
	public String list(Model model) {
		ms.list(model);
		return "mvc_quiz/list";
	}
	
}
