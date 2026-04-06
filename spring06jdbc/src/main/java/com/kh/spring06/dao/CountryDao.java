package com.kh.spring06.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.CountryDto;
import com.kh.spring06.mapper.CountryMapper;

@Repository//db나 파일을 제어하기 우히나 도구 (영속성을 가진 대상 제어 도구)
public class CountryDao {
	@Autowired// 주세요 해봐 (의존성 주입)
	private JdbcTemplate jdbcTemplate;
	@Autowired// 주세요 해봐 (의존성 주입)
	private CountryMapper countryMapper;
	
	public void insert(CountryDto countryDto) {
		String sql = "insert into country"
				+ "(country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") values(country_seq.nextval,? ,? ,? ,?)";
		Object[] params = {countryDto.getCountryRegion(),countryDto.getCountryName()
				,countryDto.getCountryCapital(),countryDto.getCountryPopulation()};
		jdbcTemplate.update(sql,params);
		
		
	}

	
}
