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

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;

@Controller
@RequestMapping("/country")
public class CountryController {
 @Autowired
 	private CountryDao countryDao;
 
 	//등록(화면과 처리 코드 결합)
 	// 입력 -> 처리 + 출력
 	@GetMapping("/insert")
 	public String insert() {
 		return "/WEB-INF/views/country/insert.jsp";
 	}
 	
 	@PostMapping("/insert")
 	public String insert(@ModelAttribute CountryDto countryDto) {
 		
 		countryDao.insert(countryDto);
 		return "redirect:./insertComplete";
 	}
 	
 	@RequestMapping("/insertComplete")
 	public String insertComplete() {
 		return"/WEB-INF/views/country/insertComplete.jsp";
 	}
 	
 	@RequestMapping("/list")
 	public String list(Model model,
 			@RequestParam(required=false) String column, @RequestParam(required=false) String keyword ) {
 		List<CountryDto> list = countryDao.selectList(column,keyword);
 		
 		model.addAttribute("list", list);
 		
 		return"/WEB-INF/views/country/list.jsp";
 		
 	}
}
