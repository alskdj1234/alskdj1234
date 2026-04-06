package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.CountryDao;
import com.kh.spring06.dto.CountryDto;
@RestController //등록 (제어 반전)
public class CountryController {
@Autowired// 주세요 해봐 (의존성 주입)
private CountryDao countryDao;

@RequestMapping("/insert")
public  String insert(@ModelAttribute CountryDto countryDto) {
	
	countryDao.insert(countryDto);
	return " 등록 완 ";
}
}
