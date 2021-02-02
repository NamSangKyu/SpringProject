package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> selectBoardList(int page);
	int selectCount();
	void addCount(int bno);
	BoardDTO selectBoard(int bno);

}
