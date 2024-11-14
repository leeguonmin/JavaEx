package com.javaex.io.charstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Thief {
	String name;
	float heigh;
	float wi;
	
	
	public Thief(String name, float heigh, float wi) {
		super();
		this.name = name;
		this.heigh = heigh;
		this.wi = wi;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getHeigh() {
		return heigh;
	}


	public void setHeigh(float heigh) {
		this.heigh = heigh;
	}


	public float getWi() {
		return wi;
	}


	public void setWi(float wi) {
		this.wi = wi;
	}


	@Override
	public String toString() {
		return "Thief [name=" + name + ", heigh=" + heigh + ", wi=" + wi + "]";
	}
	
	
// =======================================================================================================// 	
	
}


public class ScannerEx {
	
	static final String rootPath=System.getProperty("user.dir") + "\\files\\";
	// 프로젝트 내부에 있는 files 디렉터리 위치를 잡아줌
	
	static final String filename = rootPath + "thieves.txt";

	
	//thieves를 
	public static void main(String[] args) {
		File file = new File(filename);
		
		
		try (
			Scanner scanner = new Scanner(file);
		) {
			while (scanner.hasNextLine()) {
				String name= scanner.next();
				float heigh = scanner.nextFloat();
				float wi = scanner.nextFloat();
				
				Thief thief = new Thief(name,heigh, wi);
				System.out.println(thief);
				scanner.nextLine();		// thief 파일 열어보면 5번 빈줄까지 있음. 그래서 이거 추가해야 에러 안난다구..
			}
			System.out.println();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	
	
	
	
	
	
	
	
	
	
}
