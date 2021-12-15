package com.hardiksethi.springjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hardiksethi.springjdbc.studentdao.StudentDao;
import com.hardiksethi.springjdbc.studentdao.StudentDaoIMPL;

@Configuration
@ComponentScan(basePackages = {"com.hardiksethi.springjdbc.studentdao"})
public class jdbcConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	/*
	 * @Bean("studentdao") public StudentDao getStudentDao() { StudentDaoIMPL stu =
	 * new StudentDaoIMPL();
	 * 
	 * stu.setJdbcTemplate(getJdbcTemplate()); return stu; }
	 */
}
