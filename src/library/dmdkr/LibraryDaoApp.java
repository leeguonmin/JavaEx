package library.dmdkr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryDaoApp  {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		ListBooks(sc);

	//	Welcome(sc);

//		CustomerIdInput(sc);

//		ManagerIdInput(sc);		//관리자로그인
		ManagerPage(sc);		//관리자화면
		ManagerListBooks();		//전체도서리스트
		BookAdd(sc);			//도서추가
		BookDelete(sc); 		//도서삭제
		getCustomerList();		//전체회원리스트
//		UserUpdate(sc);			//회원정보변경 (그냥해본거- 삭제해도 됨!)
		UserDelete(sc);			//회원삭제
		
		
//		JoinCustomer(sc);

//		RentOrReturn(sc);

//		SearchBook(sc);

//		BookReturn(sc);

//		BookRentPossible(sc);

//		RentalFee();

		sc.close();
	}

/*
	private static void ListBooks() {
		UserDao dao = new UserDaoImpl();

		List<UserVo> list = dao.getList();
		Iterator<UserVo> iter = list.iterator();

		System.out.println("===================");

		while (iter.hasNext()) {
			UserVo vo = iter.next();
			System.out.println(vo);
		}

		System.out.println("===================");
	}
*/
	
	public static void Welcome(Scanner sc) {

		System.out.println("도서관에 오신걸 환영합니다 ^^ \n회원이시면? 1 \t 회원이 아니시면? 2 \t 관리자 이시면? 3 \n입력해주세요^^");
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
				} else {
					System.out.println("1 또는 2 또는 3의 숫자값만 입력해주세요.");
					continue;
				}
			} catch (NumberFormatException n) {
				System.out.println("1 또는 2 또는 3의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("1 또는 2 또는 3의 숫자값만 입력해주세요.");
				sc.next();
				continue;
			}
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

	//관리자 로그인
	public static void ManagerIdInput(Scanner sc) {

		System.out.println("관리자 아이디와 비밀번호를 입력해주세요.");
		System.out.print("관리자 아이디: ");
		String managerId = sc.next();
		System.out.print("관리자 비밀번호: ");
		String managerPassword = sc.next();
		
		ManagerDao vo = new ManagerDaoImpl();
//		List<ManagerVo> list = vo.search(manager_nameid, manager_password);

		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");

		System.out.println("관리자로 확인되었습니다. 관리자 화면으로 전환하겠습니다.");
		ManagerPage(sc);

	}
	
	//관리자 화면
	public static void ManagerPage(Scanner sc) {
		
	    while (true) {
	        System.out.println("----".repeat(10));
	        System.out.println("< 관리자 화면 >");
	        System.out.println("원하시는 메뉴 번호를 입력하세요.");
	        System.out.println("----".repeat(10));
	        System.out.println("1. 전체 도서목록 확인\n2. 신규 도서 추가\n3. 도서 삭제\n4. 전체 회원목록 확인\n5. 회원 삭제\n6. 관리자화면 종료");
	        System.out.print("\n메뉴 번호 : ");
	        int manager = 0;

	        try {
	            manager = sc.nextInt();
	            sc.nextLine();

	            switch (manager) {
	                case 1:
	                    System.out.println("1. 전체 도서목록 확인");
	                    ManagerListBooks(); //도서 목록 확인
	                    break;

	                case 2:
	                    System.out.println("2. 신규 도서 추가");
	                    BookAdd(sc); 	//신규 도서 추가
	                    break;

	                case 3:
	                    System.out.println("3. 도서 삭제");
	                    BookDelete(sc); //도서 삭제
	                    break;
	                    
	                case 4:
	                    System.out.println("4. 전체 회원 목록");
	                    getCustomerList(); //회원 목록 확인
	                    break;

	                case 5:
	                    System.out.println("5. 회원 삭제");
	                    UserDelete(sc); //회원 삭제
	                    break;

	                case 6:
	                    System.out.println("6. 관리자화면 종료\n\n");
	                    Welcome(sc);	//기본 화면
	                default:
	                    System.out.println("없는 메뉴입니다. 숫자를 다시 입력해주세요.");
	                    break;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("유효하지 않은 입력입니다. 숫자를 입력해주세요.");
	            sc.nextLine();
	        }
	    }
	}
	
	//전체 도서 목록
	public static void ManagerListBooks() {
		
	    ManagerDao dao = new ManagerDaoImpl();
	    List<ManagerVo> list = dao.getList();
	    Iterator<ManagerVo> iter = list.iterator();

	    String header = String.format("| %-4s | %-25s | %-20s | %-10s | %-20s | %-12s | %-12s | %-12s | %-15s | %-20s | %-5s | %-5s | %-8s |", 
                "ID", "제목", "저자", "장르", "출판사", "출판일", "대여일", "반납일", "대여자 이름", "대여자 아이디", "평점", "재고", "위치 ID");
		String separator = "----".repeat(55);
		
		System.out.println(separator);
		System.out.println(header);
		System.out.println(separator);
		
		// 도서 목록 출력
		while (iter.hasNext()) {
		ManagerVo vo = iter.next();
		// 각 도서 정보를 테이블 형식으로 출력
		System.out.printf("| %-4d | %-25s | %-20s | %-10s | %-20s | %-12s | %-12s | %-12s | %-15s | %-20s | %-5d | %-5d | %-8d |%n",
		        vo.getBookId(), vo.getTitle(), vo.getAuthorName(), vo.getTypeName(), vo.getPublisherName(),
		        vo.getPubDate(), vo.getRentalDate(), vo.getReturnDate(), vo.getName(), vo.getNameId(),
		        vo.getRate(), vo.getStock(), vo.getLocationsId());
		}
		
		System.out.println(separator);
	}
	
	//신규 도서 추가
	public static void BookAdd(Scanner sc) {

		System.out.println("추가할 도서의 정보를 입력해주세요.");

	    System.out.print("도서명: ");
	    String title = sc.nextLine();

	    System.out.print("작가 이름: ");
	    String authorName = sc.nextLine();
	    
	    System.out.print("작가 이메일: ");
	    String authorEmail = sc.nextLine().trim(); // 공백 제거
	    
	    if (authorEmail == null || authorEmail.isEmpty()) {
	        System.out.println("작가 이메일은 필수 입력 항목입니다.");
	        return;
	    }

	    System.out.print("장르ID: ");
	    int typeId = sc.nextInt();

	    System.out.print("출판일 (YYYY-MM-DD): ");
	    String pubDate = sc.next();

	    System.out.print("출판사 이름: ");
	    sc.nextLine(); // 남은 개행 문자 제거
	    String publisherName = sc.nextLine().trim();
	    
	    System.out.print("출판사 이메일: ");
	    String publisherEmail = sc.nextLine().trim(); // 공백 제거
	    
	    System.out.print("출판사 전화번호: ");
	    String publishernumber = sc.nextLine().trim();
	    
	    System.out.print("별점 (정수로 입력): ");
	    int rate = sc.nextInt();
	    
	    System.out.print("위치ID: ");
	    int locationsId = sc.nextInt();
	    

	 // ManagerVo 객체 생성 (authorEmail을 제대로 넘겨줌)
	    ManagerVo book = new ManagerVo(title, authorName, authorEmail, publisherName,publisherEmail,publishernumber,pubDate,typeId,rate,locationsId);

	    System.out.println("DEBUG: 입력된 authorEmail: " + authorEmail);
	    System.out.println("DEBUG: ManagerVo 생성 후 authorEmail: " + book.getAuthorEmail());
	    
	    
	    // ManagerDaoImpl 호출
	    ManagerDaoImpl dao = new ManagerDaoImpl();
	    boolean success = dao.insert(book);

	    if (success) {
	        System.out.println("도서가 성공적으로 추가되었습니다.");
	    } else {
	        System.out.println("도서 추가에 실패했습니다.");
	    } 
	    sc.nextLine();    
	}
	
	//도서 삭제
	public static void BookDelete(Scanner sc) {
		
	    while (true) {
	        System.out.println("삭제할 도서의 ID를 입력해주세요.");
	        System.out.print("도서ID: ");
	        int id = sc.nextInt();

	        ManagerDaoImpl dao = new ManagerDaoImpl();

	        //도서 존재 여부 확인
	        if (!dao.isBookExists(id)) {
	            System.out.println("도서가 없습니다. 도서ID를 다시 입력해주세요.\n");
	            continue;
	        }

	        //도서 삭제
	        ManagerVo book = new ManagerVo(id);
	        boolean success = dao.deleteBook(book);

	        if (success) {
	            System.out.println("도서가 삭제되었습니다.");
	        } else {
	            System.out.println("도서 삭제에 실패했습니다.");
	        }

	        break;
	    }

	    sc.nextLine();
	}
	
//	public static void UserUpdate(Scanner sc) {
//		
//		System.out.println("변경할 회원의 ID를 입력해수제요.");
//		System.out.print("회원ID: ");
//		
//		int id = sc.nextInt();
//		
//		ManagerVo user = new ManagerVo(id);
//		
//		
//	}

	//전체 회원 목록
	public static void getCustomerList() {
		
	    ManagerDao dao = new ManagerDaoImpl();
	    List<ManagerVo> list = dao.getCustomerList();
	    Iterator<ManagerVo> iter = list.iterator();
		
		//회원 목록 출력
		while (iter.hasNext()) {
		ManagerVo vo = iter.next();
		// 각 도서 정보를 테이블 형식으로 출력
		System.out.printf("%d, %s, %s, %s, %s, %s, %s%n",
		        vo.getCustomerId(), vo.getCustomerName(), vo.getEmail(), vo.getPhoneNumber(), vo.getBirthDate(),
		        vo.getCustomerNameId(), vo.getCustomerpassword());
		}
		
	}
	
	//회원 삭제
	public static void UserDelete(Scanner sc) {
		while (true) {
			System.out.println("삭제할 회원의 ID를 입력해주세요.");
			System.out.print("회원ID: ");
			int id = sc.nextInt();

		    ManagerDaoImpl dao = new ManagerDaoImpl();
		    
		    //회원 존재 여부 확인
		    if (!dao.isCustomerExists(id)) {
		    	System.out.println("회원이 없습니다. 회원ID를 다시 입력해주세요.\n");
		    	continue;
		    }
		    
		    ManagerVo user = new ManagerVo(id);
		    boolean success = dao.deleteCustomer(user);
		    
		    //회원 삭제
		    if (success) {
		        System.out.println("회원이 삭제되었습니다.");
		    } else {
		        System.out.println("회원 삭제에 실패했습니다.");
		    }
		    break;
		}
	    sc.nextLine();
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
				searchNumber = sc.nextInt();
				if (searchNumber == 1) {
					System.out.println("1번 누르셨습니다. 작가로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 작가명을 입력하세요.");
					String author_name = sc.next();

					UserDao dao = new UserDaoImpl();
					List<UserVo> list = dao.search2(author_name);

					if (list.isEmpty()) {
						System.out.println("해당 작가는 존재하지 않습니다.\n");

					} else {

						Iterator<UserVo> iter = list.iterator();

						System.out.println("===================");

						while (iter.hasNext()) {
							UserVo vo = iter.next();
							System.out.println(vo);
						}

						System.out.println("===================");
						break;
					}

				} else if (searchNumber == 2) {
					System.out.println("2번 누르셨습니다. 책 제목으로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 제목을 입력하세요.");
					String title = sc.next();

					UserDao dao = new UserDaoImpl();
					List<UserVo> list = dao.search3(title);

					if (list.isEmpty()) {
						System.out.println("해당 도서는 존재하지 않습니다.\n");

					} else {

						Iterator<UserVo> iter = list.iterator();

						System.out.println("===================");

						while (iter.hasNext()) {
							UserVo vo = iter.next();
							System.out.println(vo);
						}

						System.out.println("===================");

						break;
					}

				} else if (searchNumber == 3) {
					System.out.println("3번 누르셨습니다. 출판사로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 출판사를 입력하세요.");
					String publisher = sc.next();

					UserDao dao = new UserDaoImpl();
					List<UserVo> list = dao.search4(publisher);

					if (list.isEmpty()) {
						System.out.println("해당 도서는 존재하지 않습니다.\n");

					} else {

						Iterator<UserVo> iter = list.iterator();

						System.out.println("===================");

						while (iter.hasNext()) {
							UserVo vo = iter.next();
							System.out.println(vo);
						}

						System.out.println("===================");
						break;
					}

				} else if (searchNumber == 4) {
					System.out.println("4번 누르셨습니다. 장르로 검색하겠습니다.");
					System.out.println("찾고자 하는 도서의 장르를 입력하세요.");
					String type = sc.next();

					UserDao dao = new UserDaoImpl();
					List<UserVo> list = dao.search5(type);

					if (list.isEmpty()) {
						System.out.println("해당 도서는 존재하지 않습니다.\n");

					} else {

						Iterator<UserVo> iter = list.iterator();

						System.out.println("===================");

						while (iter.hasNext()) {
							UserVo vo = iter.next();
							System.out.println(vo);
						}

						System.out.println("===================");

						break;
					}
				} else {
					System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.\n");
					continue;
				}
			} catch (NumberFormatException n) {
				System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.\n");
				sc.next();
				continue;
			} catch (InputMismatchException i) {
				System.out.println("1 또는 2 또는 3또는 4의 숫자값만 입력해주세요.\n");
				sc.next();
				continue;
			}
		}

		BookRentPossible(sc);
	}

	public static void BookRentPossible(Scanner sc) {

		while (true) {
			try {
				System.out.println("해당하는 도서 목록을 출력하였습니다. 대출을 원하시는 도서의 번호를 입력해주세요.");

				int book_id = sc.nextInt();

				UserDao dao = new UserDaoImpl();
				List<UserVo> list = dao.searchRentalBook(book_id);

				if (list.isEmpty()) {
					System.out.println("해당 도서는 대여중으로 대출 불가능합니다./n");
				} else {
					System.out.println("해당 도서가 대출되었습니다. 대여기간은 9일 입니다. 기한 내 반납 미완료시 1일마다 연체료 1000원씩 부과됩니다.");

					// 반납일 계산하는 부분 추가 (건민)

					UserVo vo = new UserVo(book_id);

					UserDao pao = new UserDaoImpl();
					pao.stockUpdate(vo);

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
			/*
			 * Date today = new Date();
			 * 
			 * SimpleDateFormat now = new SimpleDateFormat("yyyy년 MM월 dd일");
			 * System.out.println("오늘은 " + now.format(today) + " 입니다. 대여 기간은 9일 입니다.");
			 */
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
					System.out.println("반납 대상 도서가 아닙니다. 도서 번호 다시 입력해주세요./n");

				} else {
					System.out.println("해당 도서 반납 완료 되었습니다.");

					UserVo vo = new UserVo(book_id);
					UserDao pao = new UserDaoImpl();
					pao.stockUpdate2(vo);

					// if 문 이용해서, 반납일 > 반납예정일 -> 연체료 부과화면으로 전환. 해당 안되면 그냥 보내기
					// rentalFee();

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