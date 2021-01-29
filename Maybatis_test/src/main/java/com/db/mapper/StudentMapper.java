package com.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.db.StudentDTO;

@Mapper
public interface StudentMapper {
	public List<StudentDTO> selectAllStudent();
}
