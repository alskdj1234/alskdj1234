<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<h1>국가 상세 정보</h1>

<!-- 리스트 태그(ul, ol) 

ul은 순서 없는 리스트
ol은 순서 있는 리스트
li는 리스트 내부 항목

-->

<ul>

	<li>번호 : ${countryDto.countryNo}</li>
	<li>대륙 : ${countryDto.countryRegion}</li>
	<li>이름 : ${countryDto.countryName}</li>
	<li>수도 : ${countryDto.countryCapital}</li>
	<li>인구 : ${countryDto.countryPopulation}명</li>


</ul>

<h2>
	<a href="./list">목록으로 </a>
</h2>

<h2>
	<a href="./insert">등록하기 </a>
</h2>





