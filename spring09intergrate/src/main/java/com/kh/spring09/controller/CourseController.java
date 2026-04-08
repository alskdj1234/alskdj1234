package com.kh.spring09.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;




import com.kh.spring09.dao.CourseDao;

import com.kh.spring09.dto.CourseDto;

@Controller
@RequestMapping("/course") // 공용주소
public class CourseController {
	@Autowired
	private CourseDao courseDao;

	@RequestMapping("/insert1")
 	public String insert1() {
 		return "/WEB-INF/views/course/insert1.jsp";
 	}
 	
	@RequestMapping("/insert2")
 	public String insert2(@ModelAttribute CourseDto courseDto) {
 		
 		courseDao.insert(courseDto);
 		return "redirect:./insert3";
 	}
	
	@RequestMapping("/insert3")
 	public String insert3() {
 		return"/WEB-INF/views/course/insert3.jsp";
 	}
 	
 	
}
