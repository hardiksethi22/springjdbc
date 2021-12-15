package com.hardiksethi.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hardiksethi.springjdbc.entities.Student;
import com.hardiksethi.springjdbc.studentdao.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
		
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/hardiksethi/springjdbc/config.xml");
		StudentDao studentDao = context.getBean("studentdao", StudentDao.class);
		
		/*
		 * Student student = new Student(); student.setId(555);
		 * student.setName("five five"); student.setCity("five");
		 * 
		 * int r = studentDao.insert(student); System.out.println(r);
		 */

		/*
		 * Student stu = new Student(); stu.setId(555); stu.setCity("Vellore");
		 * stu.setName("tushar");
		 * 
		 * int rt = studentDao.change(stu); System.out.println(rt);
		 */
		/*
		 * Student stu = new Student(); stu.setId(555); int r = studentDao.delete(stu);
		 * System.out.println(r);
		 */

		/*
		 * Student student = studentDao.select(222); System.out.println(student);
		 */

		
		 List<Student> students = studentDao.selectAll(); for (Student s : students) {
		  System.out.println(s); }
		 
		/*
		 * JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * //insert String query =
		 * "insert into student(id,name,city) values(224,'asd','asdas')";
		 * 
		 * int result = template.update(query); System.out.println(result); }
		 */
	}
}
