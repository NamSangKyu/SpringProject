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
		if(grade.equals("master"))
			return mapper.selectQnaAdminList(pageNo);
		return mapper.selectQnaList(map);
	}
 
	public int insertQnA(QnaDTO qnaDTO) {
		return mapper.insertQnA(qnaDTO);
	}

	public int selectCount() {
		return mapper.selectCount();
	}

	public QnaDTO selectQna(int qno) {
		mapper.updateQnAStatus(qno);
		return mapper.selectQna(qno);
	}

	public int updateResponse(int qno, String str) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qno", qno);
		map.put("answer", str);
		
		return mapper.updateResponse(map);
	}
	
}








