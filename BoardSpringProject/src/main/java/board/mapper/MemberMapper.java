package board.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO login(Map<String, Object> map);
	
}
