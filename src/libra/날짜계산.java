package libra;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 날짜계산 {

	public static void main(String[] args) {
			 // 오늘 날짜 구하기
		    Date today = new Date();

		    // Calendar 객체 생성 및 오늘 날짜 설정
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(today);

		    // 대여 기간 더하기 (9일)
		    cal.add(Calendar.DATE, 9);

		    // 결과 출력
		    Date returnDate = cal.getTime();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		    String formattedDate = sdf.format(returnDate);
		    System.out.println("책 반납일은 " + formattedDate + " 입니다.");
		}
		}
