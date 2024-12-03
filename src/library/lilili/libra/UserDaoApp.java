package library.libra;


import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserDaoApp {


	public static void main(String[] args) {

		
//		Welcome();
		

//		CustomerIdInput();

//		ManagerIdInput();
//		ManagerBookAdd();

//		JoinCustomer();

//		RentOrReturn();
//		SearchBook();
//		BookReturn();

//		BookRentPossible();
//		BookRentImpossible();
		
		BookRentDate();
		

	}


	private static void BookRentDate() {
		Scanner scanner = new Scanner(System.in);
	    RentalDaoImpl dao = new RentalDaoImpl();

	    try (Connection conn = dao.getConnection1()) {
	        System.out.println("데이터베이스 연결 성공");

	        System.out.print("대여할 책의 아이디를 입력하세요: ");
	        int bookId = scanner.nextInt();

	        // 책 정보 확인
	        RentalVo rental = dao.getRentalByBookId(bookId, conn);

	        if (rental != null) { // 대여 기록이 있는 경우
	            System.out.println("대여할 책의 ID: " + rental.getBook_id());
	            System.out.println("현재 상태: " + rental.getStatus());

	            if ("대여 중".equals(rental.getStatus())) { 
	                System.out.println("이 책은 현재 대여 중입니다.");
	            } else { 
	                System.out.println("보유 중인 책입니다. 대여하시겠습니까? (Y/N): ");
	                String response = scanner.next().toUpperCase();

	                if ("Y".equals(response)) {
	                    boolean isUpdated = dao.updateRentalStatus(rental.getRental_id(), "대여 중", conn);
	                    if (isUpdated) {
	                        Date returnDate = dao.calculateReturnDate();
	                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	                        System.out.println("대여 완료되었습니다. 반납 날짜는 " + sdf.format(returnDate) + " 입니다.");
	                    } else {
	                        System.out.println("대여 상태 업데이트에 실패했습니다.");
	                    }
	                } else {
	                    System.out.println("대여를 취소했습니다.");
	                }
	            }
	        } else { // 대여 기록이 없는 경우
	            System.out.println("해당 책에 대한 대여 기록이 없습니다.");
	            System.out.println("책 상태를 확인 중...");

	            // 추가로 책 상태를 DB에서 확인
	            boolean isAvailable = dao.checkBookAvailability(bookId, conn);

	            if (isAvailable) {
	                System.out.println("보유 중인 책입니다. 대여하시겠습니까? (Y/N): ");
	                String response = scanner.next().toUpperCase();

	                if ("Y".equals(response)) {
	                    boolean isUpdated = dao.createRentalRecord(bookId, conn);
	                    if (isUpdated) {
	                        Date returnDate = dao.calculateReturnDate();
	                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	                        System.out.println("대여 완료되었습니다. 반납 날짜는 " + sdf.format(returnDate) + " 입니다.");
	                    } else {
	                        System.out.println("대여 기록 생성에 실패했습니다.");
	                    }
	                } else {
	                    System.out.println("대여를 취소했습니다.");
	                }
	            } else {
	                System.out.println("해당 책은 대여할 수 없는 상태입니다.");
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("데이터베이스 작업 중 오류 발생!");
	        e.printStackTrace();
	    } finally {
	        scanner.close();
	    }
	}
	
	
//	private static void listuser() {
//		// 작가의 모든 정보를 출력
//		UserDao vvo = (UserDao) new UserDaoImpl();
//
//
//		List<UserVo> list = vvo.getList();
//
//		Iterator<UserVo> iter = list.iterator();
//
//
//
//
//		System.out.println("=======================================");
//
//
//		while (iter.hasNext()) {
//			UserVo vo = iter.next();
//	
//			System.out.println(vo);
//		}
//
//		System.out.println("=======================================");
//
//	}
	
	
	public static void Welcome() {
		Scanner sc = new Scanner(System.in);

		System.out.println("도서관에 오신걸 환영합니다 ^^ \n회원이시면? 1 \t 회원이 아니시면? 2 \t 관리자 이시면? 3 \n입력해주세요^^");
		int customer = 0;

		while (true) {
			try {
				customer = sc.nextInt();
				if (customer == 1) {
					System.out.println("1. 회원이십니다.");
					CustomerIdInput();

					BookRentPossible();
					BookRentImpossible();

					break;
				} else if (customer == 2) {
					System.out.println("2. 회원이 아닙니다. 회원가입을 진행하겠습니다.");
					JoinCustomer();

					break;
				} else if (customer == 3) {
					System.out.println("3. 관리자 이십니다. 관리자 로그인 해주세요.");
					ManagerIdInput();

					break;
				} else {
					System.out.println("1 또는 2 또는 3의 숫자값만 입력해주세요.");
					continue;

				}
			}

			catch (NumberFormatException n) {
				System.out.println("1 또는 2 또는 3의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("1 또는 2 또는 3의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			}

		}
		sc.close();
	}

	public static void CustomerIdInput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("회원 아이디와 비밀번호를 입력해주세요.");
		System.out.print("회원 아이디: ");
		String customersId = sc.next();
		System.out.print("회원 비밀번호: ");
		String customersPassword = sc.next();

//		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		UserDao ao = new UserDaoImpl();
//	    UserVo user = ao.UserDaoImpl(customersName_id, customersPassword);
		List<UserVo> list = ao.getList();
		Iterator<UserVo> iter = list.iterator();

		while (iter.hasNext()) {
	    if (ao != null) {
	        System.out.println("로그인 성공!");
	        // 로그인 성공 시 처리할 로직 (예: RentOrReturn() 메소드 호출)
	        RentOrReturn();
	    } else {
	        System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
	    }
		}


		RentOrReturn();

		sc.close();
	}

	public static void RentOrReturn() {
		Scanner sc = new Scanner(System.in);

		System.out.println("회원으로 로그인 되었습니다. 어떤 작업을 하시겠어요?");
		System.out.println("1. 도서검색 및 대여 \t 2. 도서 반납");
		int rent;

		while (true) {

			try {
				rent = sc.nextInt();

				if (rent == 1) {
					System.out.println("1. 도서 검색을 먼저 시작하겠습니다.");
					SearchBook();

					break;

				} else if (rent == 2) {
					System.out.println("2. 도서 반납을 선택하셨습니다.");
					BookReturn();

					break;

				} else {
					System.out.println("1 또는 2의 숫자값만 입력해주세요.");

				}
			}

			catch (NumberFormatException n) {
				System.out.println("1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;

			} catch (InputMismatchException i) {
				System.out.println("1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;

			}
		}
		sc.close();
	}

	
	
	
	
	
	public static void ManagerIdInput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("관리자 아이디와 비밀번호를 입력해주세요.");
		System.out.print("관리자 아이디: ");
		String manager_nameid = sc.next();
		System.out.print("관리자 비밀번호: ");
		String manager_password = sc.next();
		
		ManagerDao vov = new ManagerDaoImpl();
		List<ManagerVo> list = vov.search2(manager_nameid, manager_password);
		
		if (list.isEmpty()) {
			System.out.println("관리자가 아닙니다.");
			
		} else {
			System.out.println("관리자로 확인되었습니다. 관리자 화면으로 전환하겠습니다");
			ManagerBookAdd();
		}
		

		sc.close();

	}


	
	
	
	public static void ManagerBookAdd() { 
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 도서의 정보를 입력해주세요.");

		System.out.print("도서명: ");
		String title = sc.next();

		System.out.print("출판일: ");
		String pub_date = sc.next();
		System.out.print("별점: ");
		String rate = sc.next();
		System.out.print("재고: ");
		String stock = sc.next();

		System.out.print("위치: ");
		String locations = sc.next();

		System.out.print("장르: ");
		String type_name = sc.next();
		System.out.print("작가: ");
		String author_name = sc.next();
		System.out.print("출판사: ");
		String publisher_name = sc.next();

		System.out.println("해당 도서가 도서목록에 저장되었습니다.");

		sc.close();
	}
	

	public static void JoinCustomer() {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름, 전화번호, 회원 아이디, 비밀번호를 입력해주세요.");

		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("전화번호: ");
		String phone_number = sc.next();
		System.out.print("회원 아이디: ");
		String customersId = sc.next();
		System.out.print("회원 비밀번호: ");
		String customersPassword = sc.next();
		
//		UserVo vo = new UserVo(name, phone_number, customersId, customersPassword);
		
		
		UserDao dao = new UserDaoImpl();
//		boolean success = dao.insert(vo);
		
//		System.out.println("Author INSERT " + (success ? "성공" : "실패"));

		System.out.println("회원으로 등록되었습니다. 첫화면으로 돌아가서 다시 진행해주세요.");
		sc.close();

	}

	public static void SearchBook() {
		Scanner sc = new Scanner(System.in);

		System.out.println("검색하실 방법의 숫자를 입력해 주세요.");
		System.out.println("1. 작가로 검색 \t 2.책 제목으로 검색 \t 3.출판사로 검색 \t 4.장르로 검색");

		int searchNumber = 0;

		while (true) {
			try {
				searchNumber = sc.nextInt();
				if (searchNumber == 1) {
					System.out.println("1번 누르셨습니다. 작가로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 작가명을 입력하세요.");
					String author_name = sc.next();

					break;
				} else if (searchNumber == 2) {
					System.out.println("2번 누르셨습니다. 책 제목으로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 제목을 입력하세요.");
					String title = sc.next();

					break;
				} else if (searchNumber == 3) {
					System.out.println("3번 누르셨습니다. 출판사로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 출판사를 입력하세요.");
					String publisher = sc.next();

					break;
				} else if (searchNumber == 4) {
					System.out.println("4번 누르셨습니다. 장르로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 장르를 입력하세요.");
					String type = sc.next();

					break;
				} else {
					System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.");
					continue;

				}
			}

			catch (NumberFormatException n) {
				System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			}

		}

		// (위에서) 도서목록 출력 하는 식 적어야 함

		System.out.println("해당하는 도서 목록을 출력하였습니다. 대출 혹은 예약을 원하시는 도서의 번호를 입력해주세요.");

		// 대출 가능한지 아닌지 도서목록의 대출여부와 비교 (if문)
		BookRentPossible();
		BookRentImpossible();

		sc.close();
	}

	public static void BookReturn() {
		Scanner sc = new Scanner(System.in);

        System.out.println("반납할 도서의 도서 번호를 입력해주세요.");
        int bookId = sc.nextInt(); // book_id를 정수형으로 받음

//
//                if (bookId == null) {
//                    System.out.println("아직 반납되지 않았습니다.");
//                } else if (realReturnDate.after(returnDate)) {
//                    // 연체료 계산 (예시)
//                    long diffInMillies = realReturnDate.getTime() - returnDate.getTime();
//                    long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
//                    System.out.println("반납기한이 지났습니다. 연체료를 지불해주세요. 연체료는 연체일x1000원 으로 책정됩니다.");
//                    System.out.println("연체일수: " + diffInDays + "일, 연체료: " + (diffInDays * 1000) + "원");
//                } else {
//                    System.out.println("기한 내 반납이 완료되었습니다. 안녕히가세요.");
//                }
//            } else {
//                System.out.println("해당 도서는 존재하지 않습니다. 다시 입력해주세요.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        sc.close();
    }

//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("반납할 도서의 도서 번호를 입력해주세요.");
//		String book_id = sc.next();
//
//		// if문. book_id가 해당 db에 없는경우
//		if (book_id != ) {
//		System.out.println("해당 도서는 존재하지 않습니다. 다시 입력해주세요."); }
//
//		// 반납기한이 지난경우
//		System.out.println("반납기한이 지났습니다. 연체료를 지불해주세요. 연체료는 연체일x1000원 으로 책정됩니다.");
//
//		// 반납기한이 지나지 않은 경우
//		System.out.println("기한 내 반납이 완료되었습니다. 안녕히가세요.");
//
//		sc.close();
//	}

	public static void BookRentPossible() {

		System.out.println("해당 책은 대출 가능합니다.");

		Date today = new Date();

		SimpleDateFormat now = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println("오늘은 " + now.format(today) + " 입니다. 대여 기간은 9일 입니다.");
		System.out.println("기한 내 반납 미완료시 1일마다 연체료 1000원씩 부과됩니다");
	}

	
	
	public static void BookRentImpossible() {
		Scanner sc = new Scanner(System.in);

		System.out.println("해당 책은 대여중으로 대출 불가능합니다. 예약을 원하시면 1 \t 원하지 않으시면 2 눌러주세요");
		int reserve;

		while (true) {

			try {
				reserve = sc.nextInt();

				if (reserve == 1) {
					System.out.println("1. 도서 예약을 선택하셨습니다.");
					
					System.out.println("해당 도서의 반납 예정일은 000 입니다. 다시 연락드리겠습니다.");

					break;

				} else if (reserve == 2) {
					System.out.println("2. 예약하지 않겠습니다. 처음화면에서 다시 시작해주세요.");
					
					break;

				} else {
					System.out.println("1 또는 2의 숫자값만 입력해주세요.");

				}
			}

			catch (NumberFormatException n) {
				System.out.println("1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;

			} catch (InputMismatchException i) {
				System.out.println("1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;

			}
		}
		sc.close();

	}

	}

