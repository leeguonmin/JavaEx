package user;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
// import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryDaoApp {
	private static UserVo currentUser;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		ListBooks(sc);

		Welcome(sc);

//		CustomerIdInput(sc);

//		ManagerIdInput(sc);
//		ManagerBookAdd(sc);

		
//		JoinCustomer(sc);

//		RentOrReturn(sc);

//		SearchBook(sc);

		// BookReturn(sc);

//		BookRentPossible(sc);

//		NewBook(sc);

//		RentalFee();

		// displayBooks();

		sc.close();
	}

	// 리스트 전체 뽑으려 했던 것 (호정님)
	/*
	 * private static void ListBooks() { UserDao dao = new UserDaoImpl();
	 * 
	 * List<UserVo> list = dao.getList(); Iterator<UserVo> iter = list.iterator();
	 * 
	 * System.out.println("===================");
	 * 
	 * while (iter.hasNext()) { UserVo vo = iter.next(); System.out.println(vo); }
	 * 
	 * System.out.println("==================="); }
	 */

	public static void Welcome(Scanner sc) {

		System.out.println("도서관에 오신걸 환영합니다 ^^ \n회원이시면? 1 \t 회원이 아니시면? 2 \t 관리자 이시면? 3 \t 신규도서 추천은? 4 \n입력해주세요^^");
		int customer = 0;

		while (true) {
			try {
				customer = sc.nextInt();
				if (customer == 1) {
					System.out.println("1. 회원이십니다.");
					CustomerIdInput(sc);

					break;
				} else if (customer == 2) {
					System.out.println("2. 회원이 아닙니다. 회원가입을 진행하겠습니다.");
					JoinCustomer(sc);

					break;
				} else if (customer == 3) {
					System.out.println("3. 관리자 이십니다. 관리자 로그인 해주세요.");
					ManagerIdInput(sc);

					break;
				} else if (customer == 4) {
					System.out.println("4. 최근 들어온 신규도서 목록 보여드리겠습니다.");
					NewBook();

					break;
				} else {
					System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.");
					continue;
				}
			} catch (NumberFormatException n) {
				System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			}
		}
	}

	public static void NewBook() {
		UserDao dao = new UserDaoImpl();
		List<UserVo> list = dao.getNewBooks();

		System.out.println("따끈따끈 신규 도서:");
		for (UserVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void CustomerIdInput(Scanner sc) {
		while (true) {
			System.out.println("회원 아이디와 비밀번호를 입력해주세요.");
			System.out.print("회원 아이디: ");
			String customersId = sc.next();
			System.out.print("회원 비밀번호: ");
			String customersPassword = sc.next();

//			SearchCustomer();
			UserDao dao = new UserDaoImpl();
			List<UserVo> list = dao.search(customersId, customersPassword);

			if (list.isEmpty()) {
				System.out.println("회원정보가 없습니다.\n");
			} else {

				currentUser = list.get(0); // list의 첫줄을 가져온다 (=첫번째 요소 가져온다)
				System.out.println("도서대여 화면으로 이동합니다.\n");

				RentOrReturn(sc);
				break;
			}
		}
	}

	public static void RentOrReturn(Scanner sc) {
		System.out.println("어떤 작업을 하시겠어요?  1. 도서검색 및 대여 \t 2. 도서 반납");

		while (true) {
			try {
				int rent = sc.nextInt();

				if (rent == 1) {
					System.out.println("1. 도서 검색을 먼저 시작하겠습니다.\n");
					SearchBook(sc);

					break;
				} else if (rent == 2) {
					System.out.println("2. 도서 반납을 선택하셨습니다.\n");
					BookReturn(sc);

					break;
				} else {
					System.out.println("잘못된 입력입니다. 1 또는 2의 숫자값만 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;

			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;

			} catch (NoSuchElementException e) {
				System.out.println("잘못된 입력입니다. 1 또는 2의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			}
		}
	}

	public static void ManagerIdInput(Scanner sc) {

		System.out.println("관리자 아이디와 비밀번호를 입력해주세요.");
		System.out.print("관리자 아이디: ");
		String managerId = sc.next();
		System.out.print("관리자 비밀번호: ");
		String managerPassword = sc.next();

		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

		System.out.println("관리자로 확인되었습니다. 관리자 화면으로 전환하겠습니다.");
		ManagerBookAdd(sc);

	}

	public static void ManagerBookAdd(Scanner sc) {

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

	}

	public static void JoinCustomer(Scanner sc) {

		System.out.println("회원 등록을 위해 아래 정보를 입력해주세요.");

		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("메일주소: ");
		String email = sc.next();
		System.out.print("전화번호(ex.010-0000-0000): ");
		String phone_number = sc.next();
		System.out.print("생년월일(ex.1994-07-25): ");
		String birth_date = sc.next();
		System.out.print("회원 아이디: ");
		String name_id = sc.next();
		System.out.print("회원 비밀번호: ");
		String password = sc.next();

		UserVo vo = new UserVo(name, email, phone_number, birth_date, name_id, password);

		UserDao dao = new UserDaoImpl();
		boolean success = dao.insert(vo);

		System.out.println("회원등록 " + (success ? "성공 !" : "실패 !"));

		System.out.println("회원으로 등록되었습니다. 첫화면으로 돌아가서 다시 진행해주세요.");
	}

	public static void SearchBook(Scanner sc) {
		int searchNumber = 0;

		while (true) {
			System.out.println("검색하실 방법의 숫자를 입력해 주세요.");
			System.out.println("1. 작가로 검색 \t 2.책 제목으로 검색 \t 3.출판사로 검색 \t 4.장르로 검색");

			try {
				// 숫자 입력 받기
				searchNumber = sc.nextInt();
				sc.nextLine(); // 버퍼 비우기

				UserDao dao = new UserDaoImpl(); // DAO 객체 생성

				if (searchNumber == 1) {
					System.out.println("1번 누르셨습니다. 작가로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 작가명을 입력하세요.");
					String author_name = sc.nextLine(); // 입력 받기

					List<UserVo> list = dao.search2(author_name); // 작가명으로 검색

					if (list.isEmpty()) {
						System.out.println("해당 작가는 존재하지 않습니다.\n");
					} else {
						displayBooks(list); // 검색 결과 출력
						break; // 검색 성공 시 반복 종료
					}

				} else if (searchNumber == 2) {
					System.out.println("2번 누르셨습니다. 책 제목으로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 제목을 입력하세요.");
					String title = sc.nextLine();

					List<UserVo> list = dao.search3(title);

					if (list.isEmpty()) {
						System.out.println("해당 도서는 존재하지 않습니다.\n");
					} else {
						displayBooks(list);
						break;
					}

				} else if (searchNumber == 3) {
					System.out.println("3번 누르셨습니다. 출판사로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 출판사를 입력하세요.");
					String publisher = sc.nextLine();

					List<UserVo> list = dao.search4(publisher);

					if (list.isEmpty()) {
						System.out.println("해당 도서는 존재하지 않습니다.\n");
					} else {
						displayBooks(list);
						break;
					}

				} else if (searchNumber == 4) {
					System.out.println("4번 누르셨습니다. 장르로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 장르를 입력하세요.");
					String type = sc.nextLine();

					List<UserVo> list = dao.search5(type);

					if (list.isEmpty()) {
						System.out.println("해당 도서는 존재하지 않습니다.\n");
					} else {
						displayBooks(list);
						break;
					}

				} else {
					System.out.println("1 또는 2 또는 3 또는 4의 숫자값만 입력해주세요.\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("유효한 숫자를 입력해주세요.\n");
				sc.next(); // 잘못된 입력을 버퍼에서 제거
			}
		}

		BookRentPossible(sc); // 검색 완료 후 대여 단계로 이동
	}

	// 도서 목록 출력 함수
	public static void displayBooks(List<UserVo> list) {
		System.out.println("===================");
		for (UserVo vo : list) {
			System.out.println(vo);
		}
		System.out.println("===================");
	}

	public static void BookRentPossible(Scanner sc) {

		while (true) {
			try {
				System.out.println("해당하는 도서 목록을 출력하였습니다. 대출을 원하시는 도서의 번호를 입력해주세요.");
				int book_id = sc.nextInt();

				UserDao dao = new UserDaoImpl();
				List<UserVo> list = dao.searchRentalBook(book_id);

				if (list.isEmpty()) {
					System.out.println("해당 도서는 대여중으로 대출 불가능합니다.\n");
				} else {

					List<UserVo> list2 = dao.getList(book_id);

					for (UserVo vo : list2) {
						System.out.println("===================");
						System.out.println(vo);
						System.out.println("===================");
					}
					System.out.println("해당 도서가 대출되었습니다.\n");
				}

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
				System.out
						.println("대여기간은 9일로, 책 반납일은 " + formattedDate + " 입니다.\n기한 내 반납 미완료시 1일마다 연체료 10000원씩 부과됩니다.");

				UserVo vo = new UserVo(book_id);
				dao.stockUpdate(vo); // stock을 0으로 update

				List<UserVo> list3 = dao.findCustomerUserId(currentUser.getTitle());
				int customer_Id = list3.get(0).getId(); // customer_Id에 책 대여한 사람의 id(정수값) 저장

				// 현재 날짜
				java.util.Date todayUtilDate = new java.util.Date();
				java.sql.Date today2 = new java.sql.Date(todayUtilDate.getTime());

				// 반납 예정일 계산 (9일 후)
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(todayUtilDate);
				cal2.add(Calendar.DATE, 9);
				java.sql.Date returnDate2 = new java.sql.Date(cal2.getTimeInMillis());

				UserVo bo = new UserVo(book_id, customer_Id, today2, returnDate2);

				dao.insertRental(bo);

				break;
			} catch (NumberFormatException n) {
				System.out.println("정수 숫자를 입력해주세요.");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("정수 숫자를 입력해주세요.");
				sc.next();
				continue;
			}
		}
	}

	public static void BookReturn(Scanner sc) {
		while (true) {
			try {
				System.out.println("반납할 도서의 도서 번호를 입력해주세요.");
				int book_id = sc.nextInt();

				UserDao dao = new UserDaoImpl();
				List<UserVo> list = dao.searchReturnBook(book_id);

				if (list.isEmpty()) {
					System.out.println("반납 대상 도서가 아닙니다. 도서 번호 다시 입력해주세요.\n");

				} else {
					System.out.println("해당 도서 반납 완료 되었습니다.");
					dao.returnBook(book_id);

					UserVo vo = new UserVo(book_id);
					dao.stockUpdate2(vo);

					int overdueDays = dao.OverDays(book_id); // 반납 초과일 변수
//					System.out.println("Overdue Days: " + overdueDays); // 디버깅용 로그 추가

					if (overdueDays > 0) {
						int lateFee = overdueDays * 10000; // 연체료 계산
						System.out.println("반납 예정일을 " + overdueDays + "일 초과하였습니다. 연체료는 " + lateFee + "원 입니다.");

					} else {
						System.out.println("반납이 정상적으로 완료되었습니다.");
					}

					break;
				}

			} catch (NumberFormatException n) {
				System.out.println("정수 숫자를 입력해주세요.");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("정수 숫자를 입력해주세요.");
				sc.next();
				continue;
			}
		}
	}

	public static void rentalFee() {

	}
}