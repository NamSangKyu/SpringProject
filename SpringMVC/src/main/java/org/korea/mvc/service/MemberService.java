package org.korea.mvc.service;

import org.korea.mvc.dao.MemberDAO;
import org.korea.mvc.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDAO dao;

	public MemberService(MemberDAO dao) {
		this.dao = dao;
	};
	
	public MemberDTO login(String id, String pass) {
		return dao.login(id, pass);
	}
	
}
