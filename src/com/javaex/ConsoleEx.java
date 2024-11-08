package com.javaex;

import java.util.Scanner;

//import java.util.Scanner;
// 자바의 util에 있는 스캐너 기능을 쓰겠습니다. > 해줘야 기능을 불러올수있대 
// 근데 쓸때마다 인폴드 뭐, 인폴트 뭐- 쓰려면 힘들잖아 > 그럴때 팁

// tip : ctrl + shift + O : organize   > 누르면 알아서 불러와줌
// TIP2 : Ctrl + space : 코드 자동 완성 



// console
// 표준 입력 :  stdin -> System.in
// 표준 출력 : stdout -> System.out
// 표준 에러 : stderr -> System.err
public class ConsoleEx {

	
	// 밑에 만든 ConsoleOutput () 방은, 여기 메인 방에 추가해줘야만 실행이 됨. 찾아줘야만 존재할 수 있는 방인거임
	public static void main(String[] args) {
//		ConsoleOutput ();
		consoleInput ();
		
	}
	

	// 콘솔 입력 예제
	public static void consoleInput () {
		// 표준 입력 : stdin -> System.in
		// 데이터 소스로부터 입력을 받는 Scanner 클래스를 사용
		
		// java.lang 이외의 기능을 불러 올 때는 import 필요. 해줘야한다 (위에 패키지 밑에 써둔거 > 근데 팁 추가하면서 주석달았음)
		Scanner scanner = new Scanner(System.in);
		// 이건 지금 설계도. 여기서 만들어주세요~는 new. / new 뒤에 있는게 재료임 > 이 뒤에 있는 걸로 만들어주세요, 불러주세요
		// 자표형 , 이름표 = 뉴 , 설계도
			// 여기서 팁2 적용하려면, 스캐너에 커서 눌러놓고 컨트롤+스페이스 누르면 > 스캐너,자바,인틸 떠 (자동완성이라는 듯)
		
		System.out.println("콘솔 입력 예제");
		
		// 이름과 나이를 물어봐서 출력하는 프로그램 (예시)
		System.out.print("너 누구야? ");    // 이름이니까 데이터 타입은 '문자열'
		String name = scanner.next();
		System.out.print("나이는 몇 살이야? ");  // 나이를 물어봤으니, 정수로 받아야함
		int age = scanner.nextInt();
		// 여기까지, 정보 다 줬음
		// 자동 완성 가능 > 컨트롤 + 스페이스 누르면 자동 완성 떠 밑에
		
		System.out.println("Welcome, " + name);
		System.out.println("당신의 나이는 " + age + "세 입니다." );
		
		// 시스템 자원은 다 썼으면 돌려줘야 한다 (규칙임) / 시스템 자원을 쓰는 클래스는 전부 해당됨 > 자바는 알아서 해제해주지만, 그것도 즉시 해제는 아님. 관리자가 감시하고 있다가, 안쓰네? 싶으면 해제함
		// 그니까 이렇게 클로즈로 즉시즉시 해제해준느게 맞음
		scanner.close();
		
	}
	
	
	
	// 콘솔 출력 예제
	public static void ConsoleOutput () {
		// print : 개행 안 함
		// println :개행 함
		// printf : 형식 지정 문자열 출력 -> String
		
		System.out.println();
		System.out.println("콘솔 출력 예제");
		System.out.print("Hello ");  // 개행 안 함
		System.out.println("jAVA!"); // 개행 함
		
		
		// 이스케이프 문자 
		System.out.println();
		System.out.println("Hello\nJava");	// 	\n : 개행
		System.out.println("Hello\tJava");	// \t : 탭
		System.out.println("Hello, \"Java\"");	// \"(문자)\" : 문장 안의 문자다!
		System.out.println("Hello, \"Java\" 여기까지도 써진다");
		
		System.out.println("\\: 역슬래시");	// 	// -> /
	}
}





//dfkekljrwklr



// 프라이빗은 비밀. 프라이빗으로 방을 만들면, 프라이빗 방이 만들어진 폴더에서만 열수 있고
// 퍼블릭으로 방을 만들면, 그 퍼블릭이 있는 방은 물론, 다른 폴더에서도 그 퍼블릭을 열수 있대

//System.out.println