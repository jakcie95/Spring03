package com.care.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
}