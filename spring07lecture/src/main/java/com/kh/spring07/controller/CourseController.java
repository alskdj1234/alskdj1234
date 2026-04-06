package com.kh.spring07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.CourseDao;
import com.kh.spring07.dto.CourseDto;

@RestController
@RequestMapping("/course")//공용주소
public class CourseController {
@Autowired
 CourseDao courseDao;
@RequestMapping("/insert")//개별주소 (공용주소와 합쳐짐)
public String courseInsert(@ModelAttribute CourseDto courseDto) {
	courseDao.insert(courseDto);
	return "등록 완";
}
}
