package board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import board.dto.BoardDTO;
import board.dto.CommentDTO;
import board.dto.FileDTO;
import board.mapper.BoardMapper;

@Service
public class BoardService {
	private BoardMapper mapper;

	public BoardService(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public List<BoardDTO> selectBoardList(int page) {
		return mapper.selectBoardList(page);
	}

	public int selectCount() {
		return mapper.selectCount();
	}

	public void addCount(int bno) {
		mapper.addCount(bno);
	}

	public BoardDTO selectBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	public List<CommentDTO> selectBoardComment(int bno) {
		return mapper.selectBoardComment(bno);
	}

	public int insertComment(CommentDTO dto) {
		return mapper.insertBoardComment(dto); 		
	}

	public int updateCommentLike(int cno) {
		return mapper.updateCommentLike(cno);
	}

	public int updateCommentHate(int cno) {
		return mapper.updateCommentHate(cno);
	}

	public int addBoardLikeHate(int mode, int bno) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mode", mode);
		map.put("bno", bno);
		mapper.addBoardLikeHate(map);
		BoardDTO dto = mapper.selectBoard(bno);
		if(mode == 0)
			return dto.getbLike();
		else
			return dto.getbHate();
	}

	public int newBno() {
		return mapper.newBno();
	}

	public int insertBoard(BoardDTO dto) {
		return mapper.insertBoard(dto);
	}

	public void insertFileList(ArrayList<FileDTO> fList) {
		for(int i = 0;i<fList.size();i++)
			mapper.insertFileList(fList.get(i));
		
	}

	public List<FileDTO> selectFileList(int bno) {
		return mapper.selectFileList(bno);
	}
	
	
}










