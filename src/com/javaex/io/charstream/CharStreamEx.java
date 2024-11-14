package com.javaex.io.charstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamEx {
	
	static final String rootPath=System.getProperty("user.dir") + "\\files\\";
	// 프로젝트 내부에 있는 files 디렉터리 위치를 잡아줌
	

	static final String filename = rootPath + "char.txt";
	
	
	
	public static void main(String[] args) {
//		writerTest();
		readerTest();

	}
	
	
	private static void writerTest() {
		try (
			Writer writer = new FileWriter(filename);
		) {
			writer.write("Himedia Academy\r\n");
			writer.write("Java IO programming\r\n");
			writer.write("2024.11");
			
			// 버퍼 비우기
			writer.flush();
			
			System.out.println("문서를 작성했습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readerTest() {
		try (
			Reader reader = new FileReader(filename)
		) {
			int date=0;
			while ((date = reader.read()) != -1) {
				System.out.print((char)date); // 이렇게 char로 다운 캐스팅 안하고 그냥 date만 쓰면 데이터가 정수형으로 떠
			}
			
			System.out.println();	// 개행 
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열 수 없습니다.");
		} catch (IOException e) {		// 이거해줘야 위에 reader에 오류 사라져 
			e.printStackTrace();
		} 
		
	}

	
	
	
	
	
	
	
	
	
	
}
