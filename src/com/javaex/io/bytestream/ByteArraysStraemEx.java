package com.javaex.io.bytestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ByteArraysStraemEx {

	public static void main(String[] args) {
		// 복사하고자 하는 입력 소스 선언 
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		// 출력 타겟 (inSrc을 복사할 곳)
		byte[] outSrc = null;
		
		System.out.println("입력 소스:"+Arrays.toString(inSrc));
		// 스트림 개방
		try (
				// Auto Closeable
				InputStream bis = new ByteArrayInputStream(inSrc);
				OutputStream bos = new ByteArrayOutputStream();
				) {
			int date = 0;		// 입력 스트립으로부터 넘어오는 데이터 저장 변수
			
			while ((date = bis.read()) != -1) {
				System.out.println("Read date" + Integer.toBinaryString(date));
				bos.write(date);
			}
			
					// 다운 캐스팅
			outSrc=((ByteArrayOutputStream)bos).toByteArray();
			// 다운 캐스팅 후 배열로 변환 작업 수행
			System.out.println(Arrays.toString(outSrc));
		} catch (IOException e) {
			e.printStackTrace();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
				
						

	}

}
