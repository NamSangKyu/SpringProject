package board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import board.dto.QnaDTO;
import board.mapper.QnAMapper;

@Service
public class QnAService {
	private QnAMapper mapper;

	public QnAService(QnAMapper mapper) {
		super();
		this.mapper = mapper;
	}

	public List<QnaDTO> selectQnaList(String id, int pageNo, String grade) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id",id );
		map.put("pageNo",pageNo);
		
		return mapper.selectQnaList(map);
	}
	
}
