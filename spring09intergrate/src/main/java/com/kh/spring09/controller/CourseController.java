package com.kh.spring09.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.spring09.dao.CourseDao;

import com.kh.spring09.dto.CourseDto;

@Controller
@RequestMapping("/course") // 공용주소
public class CourseController {
	@Autowired
	private CourseDao courseDao;

	//@RequestMapping(value="/insert", method = RequestMethod.GET)
 	@GetMapping("/insert")
	public String insert() {
 		return "/WEB-INF/views/course/insert.jsp";
 	}
 	
	//@RequestMapping(value="/insert", method = RequestMethod.POST)
 	@PostMapping("/insert")
 	public String insert(@ModelAttribute CourseDto courseDto) {
 		
 		courseDao.insert(courseDto);
 		return "redirect:./insertComplete";
 	}
	
	@RequestMapping("/insertComplete")
 	public String insertComplete() {
 		return"/WEB-INF/views/course/insertComplete.jsp";
 	}
 	
 	
}
