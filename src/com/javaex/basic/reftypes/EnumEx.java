package com.javaex.basic.reftypes;

/*
// 여기다쓰면 에러나서, Enum 박스를 따로 만들어줬음. 이름 Week
public enum Week {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	FRIDAY,
	SATURDAY
}
*/






public class EnumEx {

	public static void main(String[] args) {
		usingEnum();
		
		// switchPractine()의 enum 버전
//		switchEnumPractice();

	}

	public static void usingEnum() {
		Week today = Week.TUESDAY;
		// 열거 상수 쓰는 방법
		
		System.out.printf("Today is %s(%d)%n", 
						today.name(), 		// 열거 상수를 문자열(String)로
						today.ordinal());	// 문자열(String)을 열거 상수로
		
		
		
		
//		String dayStr = "BIRDTHDAY" 	// 이렇게 Week 에 없는거쓰면, 에러나
		String dayStr = "FRIDAY";
		
		// String -> 열거상수 convert
		Week obj = Week.valueOf(dayStr);
		System.out.printf(obj.name() + " " + obj.ordinal());
		
		// 열거 상수 목록
		System.out.println(" Enum Week:");
		
		
		Week[] days = Week.values();		// []가 배열 표시임 / 배열은, 상자를 만들때, 같은 데이터 여러개를 배열시키는. 그냥 쉽게 말하면 week 안에 있는 데이터로 배열 하겠다고. 7개 방 생기겠지
		
		for (int i = 0; i < days.length; ++i) {
			Week day = days[i];
			System.out.printf("%s -> %d%n", day.name(), day.ordinal());
		}
		
		// compareTo : 두 객제 사이의 순서를 비교하는 매서드
		Week otherDay = Week.FRIDAY;
		// TUESDAY와 FRIDAY의 순번 비교
		System.out.println(today.compareTo(otherDay));
		
	}
	
	
	
	private static void switchEnumPractice() {
		// conditionEx에서 switchPractine() 복사
		
		Week day = Week.TUESDAY;		
		String action;
		
		switch (day) {
		case SUNDAY:
			action = "휴식";
			break;
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURDAY:
			action = "열공";
			break;
		case SATURDAY:
			action = "주말";
			break;
		default:
			action = "난 누구지?";
			break;
		}
		
		System.out.println(day.name() + "에는 " + action);
		
	}
	
	
	
	
	
	
	}
	
	
	
	
	
	
	



