package com.hardiksethi.springjdbc.studentdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hardiksethi.springjdbc.entities.Student;

@Component("studentdao")
public class StudentDaoIMPL implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student s) {
		// TODO Auto-generated method stub
        String query = "insert into student(id,name,city) values(?,?,?)";
        int r = this.jdbcTemplate.update(query,s.getId(),s.getName(),s.getCity());
		return r;
	}
	
	public int change(Student student) {
		// TODO Auto-generated method stub
		String query="update student set name=?, city =? where id =?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(), student.getId());
		return r;
	}
	
	public int delete(Student student) {
		// TODO Auto-generated method stub
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query,student.getId());
		return r;
	}
	
	public Student select(int studentId) {
		// TODO Auto-generated method stub
		String query = "select * from student where id =?";
		RowMapper<Student> rowmapper = new RowMapperIMPL();
		Student student = this.jdbcTemplate.queryForObject(query, rowmapper, studentId);
		return student;
	}
	
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		
		String query = "select * from student";
		List<Student> studentlist = this.jdbcTemplate.query(query, new RowMapperIMPL());
		return studentlist;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
