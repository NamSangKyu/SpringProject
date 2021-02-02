package board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import board.dto.BoardDTO;
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
	
	
}










