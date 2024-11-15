package JavaTest;

import java.util.Scanner;

public class 문자열반복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();     
        int n = sc.nextInt();  
        
        int i = 0;
        for(i=0; i<n; ++i) {
            System.out.print(str);
        }
    }
        
}
        
//        String[] string = new String;
//        int i = 0;
//        for(i=0; i<n.length(); ++i) {
//            string[n] = str;
//        System.out.println(str);
//        }
//        }
//        
//    }