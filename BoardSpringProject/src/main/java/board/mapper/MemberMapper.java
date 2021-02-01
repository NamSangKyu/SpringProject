package board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO login(Map<String, Object> map);
	MemberDTO selectMember(String id);
	int updateMember(MemberDTO dto);
	List<MemberDTO> selectAllMember();
	
}
