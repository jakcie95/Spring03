package com.care.member.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Service//연산담당
public class MemberService {
	@Autowired
	MemberDAO dao;
	public MemberService() {
		System.out.println("service 생성");
	}
	public void register(MemberDTO dto) {
		dao.register(dto);
	}
	public void list(Model model) {
		ArrayList<MemberDTO> list = dao.list();
		model.addAttribute("list", list);
	}
	public void info(Model model,String id) {
		// select * from table where id=id;
		ArrayList<MemberDTO> list = dao.list();
		for(MemberDTO dto : list) {
			if(dto.getId().equals(id)) {
				model.addAttribute("dto", dto);
				break;
			}
		}
	}
	public int logchk(MemberDTO dto) {
		ArrayList<MemberDTO> list = dao.list();	
		for(MemberDTO d : list) {
			if(d.getId().equals(dto.getId())) {
				if(d.getPwd().equals(dto.getPwd())) {
					return 1; //아이디 비밀번호 일치
				}
				return 0; //아이디 일치, 비밀번호 불일치
			}
		}
			return -1; //아이디 비밀번호 불일치
	}
}