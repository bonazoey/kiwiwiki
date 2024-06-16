package com.dhy.service;

import com.dhy.domain.MemberVO;

public interface MemberService {
	
	MemberVO login(String id, String pw);
}
