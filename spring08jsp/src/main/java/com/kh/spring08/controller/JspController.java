package com.kh.spring08.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jsp")
public class JspController {
	//화면에 전달해야 할 데이터가 있다면 모델을 매개변수에 선언하고 데이터 추가
	@RequestMapping("/test01")
	public String test01(Model model) {
		//model에 원하는 데이터를 "이름을 붙여서" 전달
		//model.addAttribute("이름", 값) (String, object)
		model.addAttribute("message", "Hello MVC Pattern!");
		Random r = new Random();
		int dice = r.nextInt(6)+1;
		model.addAttribute("dice",dice);
		int lotto = r.nextInt(45) + 1;
		model.addAttribute("lotto", lotto);
		return "/WEB-INF/views/jsp/test01.jsp";
	}

	@GetMapping("/test02")
	public String test02(Model model, @RequestParam String birth) {
		
	
		LocalDate d = LocalDate.parse(birth);
		LocalDate cur = LocalDate.now();
		Period period = Period.between(d, cur);
		int globalAge = period.getYears();
		
		int koreanAge = cur.getYear()-d.getYear()+1;
		
		
		model.addAttribute("globalAge",globalAge);
		model.addAttribute("koreanAge",koreanAge);
		
	
	return "/WEB-INF/views/jsp/test02.jsp";
	}

	
	@GetMapping("/test03")
	public String test03(Model model, @RequestParam long krw) {
		
		Float won = (float)krw;
		Float todayDollar = 1472.75f;
		Float usdKrw = won/todayDollar;
		
		Float todayYen = 9.32f;
		Float yenKrw = won/todayYen;
		
		Float todayYuan =214.99f;
		Float yuanKrw = won/todayYuan;
		
		Format f = new DecimalFormat("#,##0.00");
		
		
		model.addAttribute("usdKrw", f.format(usdKrw));
		model.addAttribute("yenKrw", f.format(yenKrw));
		model.addAttribute("yuanKrw", f.format(yuanKrw));
		
		return "/WEB-INF/views/jsp/test03.jsp";
		
		
		
	}


}
