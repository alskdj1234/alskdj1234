package com.kh.spring07.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.CourseDto;
import com.kh.spring07.mapper.CourseMapper;

@Repository//파일 또는 dbms 제어도구
public class CourseDao {
@Autowired
	private JdbcTemplate jdbcTemplate;
@Autowired
	private CourseMapper courseMapper;

public void insert(CourseDto courseDto) {
	String sql = "insert into course"
			+ "(course_no, course_name, category, "
			+ "lecture_time, fee, class_type "
			+ ")values(seq_course.nextval,?,?,?,?,?)";
	
		Object[] params = {courseDto.getCourseName(), courseDto.getCategory(),
				courseDto.getLectureTime(),courseDto.getFee(),
				courseDto.getClassType()};
		jdbcTemplate.update(sql,params);
		
		
}
		

}
