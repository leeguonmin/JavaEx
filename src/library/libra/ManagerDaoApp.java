package library.libra;

import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

public class ManagerDaoApp {

	public static void main(String[] args) {
		ManagerIdInput();

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
		}
		

		sc.close();

	}

}
