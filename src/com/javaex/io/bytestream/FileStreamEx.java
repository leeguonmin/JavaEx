package com.javaex.io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamEx {
	
	static final String rootPath=System.getProperty("user.dir") + "\\files\\";
	// 프로젝트 내부에 있는 files 디렉터리 위치를 잡아줌

	static final String source = rootPath + "img.jpg";
	static final String target = rootPath + "img_copy.jpg";
	
	public static void main(String[] args) {
//		InputStream is = null;
//		OutputStream os = null;
		
		try (
				InputStream is = new FileInputStream(source);		// 위 아래 주석 달고 
				OutputStream os = new FileOutputStream(target);		// 이케 합쳐줌			// 이렇게 해주면 밑에 트라이 주석해도됨(어차피 오류나)
				) {
//			is = new FileInputStream(source);
//			os = new FileOutputStream(target);
			
			int date = 0;
			while ((date = is.read()) != -1) {
				os.write(date);
			}
			
			System.out.println("파일을 복사했어요");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없어요");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			 try {
//				 if (is != null)is.close();
//				 if (os != null)os.close();
//			 } catch (Exception e) {
//				 e.printStackTrace();
//			 }
		}

	}

}
