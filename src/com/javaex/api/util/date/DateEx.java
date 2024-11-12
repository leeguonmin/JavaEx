package com.javaex.api.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 데이트 클래스 (날짜, 시간) 
// 일반 클래스가 아니라서 불러줘야한다 (컨트롤+쉬프트+o => import java.util.Date;)
public class DateEx {

	public static void main(String[] args) {
		// 날짜 데이터만 
		// 실제 기능은 캘린더에 위임
		Date now=new Date();		// 현재 날짜와 시간 
		
		System.out.println(now);		
		
		// 형식화 출력 
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("FULL Format:" + df.format(now));
		df=DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("LONG Format:" + df.format(now));
		df=DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("MEDIUM Format:" + df.format(now));
		df=DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("SHORT Format:" + df.format(now));
		System.out.println();
		
		// 심플 데이트 포맷 (SimpleDateFormat) 활용 형식화 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		System.out.println("SDF:" + sdf.format(now));
		
		

	}

}
