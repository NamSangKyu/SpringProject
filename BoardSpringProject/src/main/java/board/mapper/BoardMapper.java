package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDTO;
import board.dto.CommentDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> selectBoardList(int page);
	int selectCount();
	void addCount(int bno);
	BoardDTO selectBoard(int bno);
	List<CommentDTO> selectBoardComment(int bno);
	int insertBoardComment(CommentDTO dto);
	int updateCommentLike(int cno);
	int updateCommentHate(int cno);

}










