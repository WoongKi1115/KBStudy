package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUseKeyboardExam {

	public static void main(String[] args) throws IOException{
//		// 키보드 입력
//		InputStream is = System.in;
//		System.out.print("입력 : ");
//		int i = is.read(); // 1byte 읽기
//		// 단순 is.read() 만 사용하면 예외처리하라는 에러 발생 => throw IOExceiption 적어줘야함.
//		System.out.println("i = " + i + ", " + (char) i);
//		// 여기까지만 하면 그대로 나오지 않음. byte 단위가 매우 불편
		
//		때문에 아래처럼 키보드 입력함
		// InputStreeam => Reader로 변환
//		InputStreamReader ir = new InputStreamReader(System.in);
//		int i = ir.read(); // 한 문자 읽기
//		System.out.println("i = " + i + ", " + (char) i);
		// 여기까지 하면 단어를 써도 앞에 한 글자만 나옴
		// 한 줄씩 읽기 위해 Bufferd 활용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		System.out.println("data = " + data);
	}

}
