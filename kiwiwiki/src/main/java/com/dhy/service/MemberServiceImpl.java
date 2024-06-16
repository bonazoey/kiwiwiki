package com.dhy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhy.dao.MemberDAO;
import com.dhy.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO login(String id, String pw) {
		return memberDAO.getMember(id, pw);
	}
}
