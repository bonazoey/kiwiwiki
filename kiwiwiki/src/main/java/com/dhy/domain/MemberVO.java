package com.dhy.domain;

import lombok.Data;

@Data
public class MemberVO {

	private String id;
	private String pw;
	private String nick;
	private String email;
	private String phone;
	private String addr;
	
	public MemberVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
}
