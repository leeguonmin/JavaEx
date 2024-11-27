package libra;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RentalApp {

	public static void main(String[] args) {
//		listRental();
		BookReturn();

	}

	
	private static void listRental() {
		RentalDao aov = new RentalDaoImpl();
		
		List<RentalVo> list = aov.getList();
		
		Iterator<RentalVo> iter = list.iterator();
		
		
		System.out.println("=======================================");
		while (iter.hasNext()) {
			RentalVo voo = iter.next();
			System.out.println(voo);
		}
		
		System.out.println("=======================================");
		
	}
	
	
	
	
	
	public static void BookReturn() {
		 Scanner scanner = new Scanner(System.in);
	        System.out.print("반납할 도서 번호를 입력하세요: ");
	        int bookId = scanner.nextInt();

	        // 2. 데이터베이스에서 도서 대여 정보 조회
	        RentalDao rentalDao = new RentalDaoImpl();
	        RentalVo rentals = (RentalVo) rentalDao.getbookid(bookId);

	        // 3. 조회 결과 확인 및 반납 처리
	        if (rentals != null && !rentals.isEmpty()) {
	            RentalVo rental = rentals.get(0);

	            // 데이터베이스에 반납 정보 업데이트
	            boolean isUpdated = RentalDao.update(bookId, new Date());
	            if (isUpdated) {
	                System.out.println("반납이 완료되었습니다.");

	                // 4. 연체료 계산
	                Date returnDate = rental.getReturnDate(); // 예정 반납일 가져오기
	                Date realReturnDate = new Date(); // 실제 반납일
	                long diffInMillies = realReturnDate.getTime() - returnDate.getTime();
	                long diffDays = diffInMillies / (24 * 60 * 60 * 1000); // 일수로 변환

	                if (diffDays > 0) {
	                    int overdueFee = (int) diffDays * 1000; // 하루당 연체료 1000원으로 가정
	                    System.out.println("연체료는 " + overdueFee + "원 입니다.");
	                } else {
	                    System.out.println("연체된 기간이 없습니다.");
	                }
	            } else {
	                System.out.println("반납 처리 중 오류가 발생했습니다.");
	            }
	        } else {
	            System.out.println("해당 도서는 존재하지 않습니다.");
	        }
	    }
	}

//		Scanner scanner = new Scanner(System.in);
//        System.out.print("반납할 도서 번호를 입력하세요: ");
//        int bookId = scanner.nextInt();
//
//        RentalDao ao = new RentalDaoImpl(); 
//        List<RentalVo> rentList = ao.getbookid(bookId);
//
//        if (rentList != null && !rentList.isEmpty()) {
//            RentalVo rent = rentList.get(0); // 첫 번째 요소 가져오기
//            boolean isUpdated = RentalDao.update(bookId, new Date());
//            if (isUpdated) {
//                // 반납 성공 메시지 출력 및 연체료 계산
//                System.out.println("반납이 완료되었습니다.");
//
//                // 연체료 계산 및 출력
//                Date returnDate = rent.update(bookId, new Date()); // RentalVo에서 반납 기한 가져오기  getReturnDate
//                Date realReturnDate = new Date(); // 실제 반납일
//                long diffInMillies = realReturnDate.getTime() - returnDate.getTime();
//                long diffDays = diffInMillies / (24 * 60 * 60 * 1000);
//
//                if (diffDays > 0) {
//                    int overdueFee = (int) diffDays * 1000;
//                    System.out.println("연체료는 " + overdueFee + "원 입니다.");
//                }
//            } 
//        } else {
//            System.out.println("해당 도서는 존재하지 않습니다.");
//        }
//	}
