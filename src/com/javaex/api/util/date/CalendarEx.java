package com.javaex.api.util.date;

import java.util.Calendar;

// 캘린더 
public class CalendarEx {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Calendar custom = Calendar.getInstance();
		
		// 달력의 날짜 설정
		custom.set(2012,8, 24);	
		// 주의 : 월 정보는 실제 월보다 -1 이다. (예시로 보자면, 월을 8로 적었지만, 이건 2012.9.24 인거임)

		// 캘린더 상수로 날짜 정보를 받을 수 있음
		int year = now.get(Calendar.YEAR);	// 연 정보 get
		int month = now.get(Calendar.MONTH)+1;	// 월 정보 get		// 월정보에는 꼭 +1 해야함. 월정보는 0부터 시작하기 때문에, +1을 안하고 출력하면, 원래 월보다 -1 되어가지고 나옴
		int date = now.get(Calendar.DATE); 		// 일 정보 get
		System.out.printf("오늘은 %d년 %d월 %d일 입니다.%n", year, month, date);
		
		// 날짜 조작
		// 현재 시간으로 부터 10년 뒤로 여행하는 예시 
		Calendar future = Calendar.getInstance();
		future.add(Calendar.YEAR, 10);	// 년도 정보에다가 10을 (add)더한다는 뜻
		System.out.printf("10년 뒤: %d년 %d월 %d일 %n", future.get(Calendar.YEAR), future.get(Calendar.MONTH)+1,future.get(Calendar.DATE));
		
		// 이날은 무슨 요일?
		int dow = future.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일: " + dow);	// 1 이 일요일인가봐
		
		
	}

}
