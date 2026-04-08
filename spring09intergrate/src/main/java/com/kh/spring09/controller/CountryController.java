package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
 	
}
