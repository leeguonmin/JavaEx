package JavaTest;

import java.util.Scanner;

public class 대소문자변환 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for (int i = 0; i<a.length(); ++i) {
        	if (Character.isLowerCase(a.charAt(i))) {
        		System.out.println(a.toLowerCase());
        	} else {
        		System.out.println(a.toUpperCase());
        	}
        }
        
    }
}


