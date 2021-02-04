package board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.QnaDTO;

@Mapper
public interface QnAMapper {

	List<QnaDTO> selectQnaList(HashMap<String, Object> map);

}
