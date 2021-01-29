package board.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import board.dto.MemberDTO;
import board.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;
	
	public MemberService(MemberMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public MemberDTO login(String id, String pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		return mapper.login(map);
	}

}







