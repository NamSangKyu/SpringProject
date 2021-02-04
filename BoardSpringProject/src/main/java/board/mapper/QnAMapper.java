package board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.QnaDTO;

@Mapper
public interface QnAMapper {
	List<QnaDTO> selectQnaList(HashMap<String, Object> map);
	int insertQnA(QnaDTO qnaDTO);
	int selectCount();
	List<QnaDTO> selectQnaAdminList(int pageNo);
	QnaDTO selectQna(int qno);
	int updateQnAStatus(int qno);
	int updateResponse(HashMap<String, Object> map);

}
