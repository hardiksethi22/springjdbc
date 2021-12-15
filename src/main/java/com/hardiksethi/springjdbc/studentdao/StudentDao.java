package com.hardiksethi.springjdbc.studentdao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hardiksethi.springjdbc.entities.Student;

public interface StudentDao {
	
	
	public int insert(Student student);
	public int change(Student student);
	public int delete(Student student);
	public Student select(int studentId);
	public List<Student> selectAll();
}
