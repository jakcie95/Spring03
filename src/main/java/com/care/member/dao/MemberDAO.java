package com.care.member.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.member.dto.MemberDTO;

@Repository//db에서 정보 끌어오는 역할
public class MemberDAO {
	private ArrayList<MemberDTO> list;
	public MemberDAO() {
		list = new ArrayList<MemberDTO>();
	}
	public void register(MemberDTO dto) {
		list.add(dto);
	}
	public ArrayList<MemberDTO> list() {
		// select * from table;
		return list;
	}
}
