package JavaTest;

import java.util.ArrayList;

import com.javaex.oop.shape.v2.Drawable;

public class UserApp {

	public static void main(String[] args) {
		System.out.println("-------------회원+운영자 전체리스트-------------");
//		User[] u = { new Staff ("master", "m7799", "운영자", 3500000),
//				new Customer ("jung-ws", "j1357913579", "정우성", 1000),
//				new Customer ("LeeHR", "a123!", "이효리", 2500),
//				new Customer ("ms-park", "y2345", "박명수", 1200)
//		};
			
		ArrayList<User> u = new ArrayList<>();
		u.add(new Customer ("master", "m7799", "운영자", 3500000));
		u.add(new Customer ("jung-ws", "j1357913579", "정우성", 1000));
		u.add(new Customer ("LeeHR", "a123!", "이효리", 2500));
		u.add(new Customer ("ms-park", "y2345", "박명수", 1200));
		

		
		int c= 1;		// 카운트
		for (int i =0; i<u.size(); ++i) {
			++c;u[i].showInfo();
		}
		System.out.println();
		
		
		
//		int e = Staff.salary;
//		System.out.println("운영자의 연봉은 "+ e*12 +"입니다");

	}
	
}

