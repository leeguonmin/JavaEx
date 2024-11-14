package com.javaex.io.charstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class StringTokenizerEx {
	
	static final String rootPath=System.getProperty("user.dir") + "\\files\\";
	// 프로젝트 내부에 있는 files 디렉터리 위치를 잡아줌
	
	static final String filename = rootPath + "thieves.txt";
	

	public static void main(String[] args) {
		try (
			Reader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
				) {
			String thief;
			
			while ((thief = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(thief, " ");
//				System.out.println(thief);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					System.out.print(token + " ");
				}
				System.out.println();
			}
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
