package com.db;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.mapper.StudentMapper;

@Service
public class StudentService {
	private StudentMapper mapper;

	public StudentService(StudentMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public List<StudentDTO> selectAllStudent(){
		return mapper.selectAllStudent();
	}
	
}





