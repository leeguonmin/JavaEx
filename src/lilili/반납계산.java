package lilili;



import java.util.Calendar;
import java.util.Date;

public class 반납계산 {

    public static void main(String[] args) {
        // 반납일 설정 (예시)
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 9, 30); // 2024년 10월 30일 (원하는 달에서 -1 해야함)
        Date returnDate = calendar.getTime();
        // getTime : Calendar 객체에 설정된 날짜 정보를 Date 객체로 변환하여 반환
        

        
        반납계산 calculator = new 반납계산();
        int overdueDays = calculator.calculateOverdueDays(returnDate);

        // 하루당 연체료 1000원으로 설정
        int dailyOverdueFee = 1000;
        int totalOverdueFee = overdueDays * dailyOverdueFee;

        System.out.println("연체된 일수: " + overdueDays + "일");
        System.out.println("총 연체료: " + totalOverdueFee + "원");
    }

    public int calculateOverdueDays(Date returnDate) {
        long diff = new Date().getTime() - returnDate.getTime(); // 밀리초 차이
        return (int) (diff / (1000 * 60 * 60 * 24)); // 일 단위로 변환
    }
}