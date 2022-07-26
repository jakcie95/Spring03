package com.care.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@GetMapping("info")
	public String info(
			//편한대로 사용가능
			@RequestParam String id,
			HttpServletRequest request,
			MemberDTO dto, Model model) {
			System.out.println("id : "+id);
			System.out.println("request : "+request.getParameter("id"));
			System.out.println("dto : "+dto.getId());
			
			ms.info(model, id);
		return "mvc_quiz/info";
	}
	@PostMapping("logchk")
	public String logchk(MemberDTO dto,
						RedirectAttributes rs) {
		int result = ms.logchk(dto);
		if(result == 1) {
			return "redirect:success?id="+dto.getId();
		}
		rs.addFlashAttribute("result",result);
		return "redirect:Mainpage";
	}
	@GetMapping("success")
	public String success(String id, Model model) {
		ms.info(model, id);
		return "mvc_quiz/success";
	}
	
}
	

