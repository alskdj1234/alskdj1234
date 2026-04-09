package com.kh.spring09.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.CourseDao;
import com.kh.spring09.dto.CourseDto;
import com.kh.spring09.exception.TargetNotfoundException;

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
	
	@RequestMapping("/list")
	public String list (Model model,@RequestParam(required=false) String column, @RequestParam(required=false) String keyword){
		List<CourseDto> list = courseDao.selectList(column,keyword);
		model.addAttribute("list", list);
		return"/WEB-INF/views/course/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail (Model model, @RequestParam int courseNo) {
		CourseDto courseDto = courseDao.selectOne(courseNo);
		if(courseDto==null)throw new TargetNotfoundException("강좌가 존재하지 않아요");
		model.addAttribute("courseDto", courseDto);
		return "/WEB-INF/views/course/detail.jsp";
	}
 	
}
