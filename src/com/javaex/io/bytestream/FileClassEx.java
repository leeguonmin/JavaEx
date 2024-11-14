package com.javaex.io.bytestream;

import java.io.File;
import java.io.IOException;

// 파일 폴더 끌어서 추가한 후
// 파일 디렉토리를 찾을건가봐유 (저 파일이 어디에 있는가)
public class FileClassEx {

	
	static final String rootPath=System.getProperty("user.dir") + "\\files\\";			// 실제 프로젝트 위치를 말해주는? 건가? 연결시켜주는? 
	// 프로젝트 내부에 있는 files 디렉터리 위치를 잡아줌
	
	public static void main(String[] args) {
		// 파일 객체 생성
		File root = new File(rootPath);
		// 이 파일은 실제로 존재하는가?
		System.out.println(rootPath + ":" + root.exists());		
		
		
		if (! root.exists()) {		// 존재하지 않으면
			root.mkdir();			// 디렉토리 생성		(이미 있으면 생성되지 않음? 생성하면 안됨? 하여튼 그래)
			System.out.println(rootPath + "를 생성했습니다.");
		} else {
			System.out.println(rootPath + "는 이미 있는 디렉터리입니다.");
		}
		
		File subdir = new File(rootPath + "subdir");		// 서브 디렉터리를 만들어보자
		if (! subdir.exists()) {		// 존재 하나 안하나 확인하고, 존재하지 않으면 
			if (subdir.mkdir()) {		// subsir 생성
			System.out.println(subdir + "을 생성했습니다.");
			} else {
				System.out.println(subdir + "을 생성하지 못했슴니다.");
			}
			
		}
		// rootPath 내부에 새파일 생성
		// 우선 파일 정보를 줘야지 
		File file = new File(rootPath + "myfile.txt");
		// 만들기 전에, 마이파일이 있는지 없는지 확인 
		if (! file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("파일을 만들지 못했어요 ");
			}			// 생성된거 확인됨 
		}
		
		// 파일 지우기 
		file.delete();
		
		
		System.out.println();
		printInfo(root);

	}
	
	private static void printInfo(File f) {
		System.out.println("-----------");
		
		if(f.isDirectory()) {
			// 디렉터리면
			System.out.println("Directory:" + f.getName());
			File[] files = f.listFiles(); 	// 파일이니까, 루프  돌수있겠죠
			for (File file: files) {		// 돌려 루프~
				printInfo(file);
			}
		} else {
			// 파일											// <파일의 기본적인 정보 3가지>
			System.out.println(f.canRead() ? "r" : "."); 	// 읽기 전용이냐? 읽을 수 있는 파일이냐?
			System.out.println(f.canWrite() ? "w": ".");	// 쓸수 있는 파일이냐?
			System.out.println(f.canExecute() ? "s" : ".");	// 실행 할 수 있는 파일이냐?
			
			System.out.println(f.getName() + "\t");
			System.out.println(f.length());		// f.에 file 적으면 오류나 (주의)
		}			// 출력되는 것들 중 마지막은 바이트수(예. 8540962) 
	}
	

}
