package ex0725;

import java.io.IOException;

public class ThrowsExam {
	// 4-1. aa에도 throw를 걸어줌.
	public void aa(int i) throws ArithmeticException, IOException{
		System.out.println("aa() 메소드 호출됨...");
		// 2. 그래서 여기서 try에 bb()를 넣어서 에러를 받을 수 있게 함.
		// 하지만 이러면 에러는 보여지지만 bb 메소드가 정상적으로 종료되지 않음
		
		// 4. 여기서 try 하기 싫다면 main에서 잡아주어도 됨.
		try {
			
//		try {
			this.bb(i);			
//		} catch (ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없음");
//		} 
			// 5. aa에 finally로 끝낼 수 있게 함
		} finally {
			System.out.println("aa() 메소드 끝...");
		}
		
	}
	// 1. 여기서 에러가 생기면 aa로 던짐 aa 안에 bb를 호출 하므로.
	public void bb(int i) throws ArithmeticException, IOException{
		System.out.println("bb() 메소드 호출됨...");
		try {
			// 일부러 에러를 발생시키는 처리.
			if (i<0) {
//				RuntimeException e = new RuntimeException(); // 비체크 예외 => 처리 해도 되고 안해도 되는 예외
				IOException e = new IOException();// 체크 예외 => 반드시 처리를 해주어야하는 에러. 안하면 컴파일이 안됨.
				throw e;
			}
			int result = 100/i; //AritmeticException 가능성			
			System.out.println("나눈 결과 : " + result);
			// 3. 그 때 finally에 종료할 때 실행할 것을 넣어주면 실행됨.
		} finally {
			System.out.println("bb() 메소드 끝...");			
		}
		
	}
	public static void main(String[] args) {
		System.out.println("****메인 시작하기****");
		ThrowsExam te = new ThrowsExam();
		// 4-2. main문에 try문 넣어줌.
		try {
			te.aa(0);			
			// ArithmeticException, IOException의 예외를 모두 잡음
		} catch (ArithmeticException | IOException e) {
			
			System.out.println("예외발생함~~" + e.getMessage());
		}
		System.out.println("****메인 끝****");
	}
}
