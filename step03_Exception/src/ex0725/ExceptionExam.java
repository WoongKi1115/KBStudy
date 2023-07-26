package ex0725;

public class ExceptionExam {

	// main은 JVM이 호출해서 시작점으로 지정
	public static void main(String[] args) {
		System.out.println("**********메인 시작**********");
		System.out.println("args = " + args);
		System.out.println("args.length = " + args.length);
		try {
			
			String data = args[0];
			System.out.println("전달된 값 : " + data);
			
			int convertNo = Integer.parseInt(data); // 문자열 => 숫자로 변환
			System.out.println("변환 결과 : " + convertNo);
			
			int result = 100/convertNo;
			System.out.println("나눈 결과 = " + result);
			
//		} catch(ArrayIndexOutOfBoundsException e) {
//			// 예외 발생했을 때 해야할 일 작성
//			System.out.println("e = " + e); // e.toString() 호출
//		} catch(NumberFormatException e) {
//			System.out.println("숫자만 입력하세요" + e.getMessage());
//		// 다 일일이 예외를 정해주면 힘듦
//		// Exception은 모든 error의 조상 => Exception을 두면 모든 에러를 다 가져올 수 있음.
//		// 하지만 Exception으로 거르면 상황에 따른 대응을 처리하기 어려움.
		} catch (Exception e) {
			// 가장 많이 쓰는 메서드(오류가 디테일하게 나옴) 하지만 보안에 취약함.
			// 때문에 개발 모드에서는 사용하지만 배포 (운영)모드에서는 제거
			e.printStackTrace();
			System.out.println("예외 상관 없이 무조건 실행됨.");
		}
		System.out.println("**********메인 끝**********");
//		for (String s : args) {
//			System.out.println(s);
//		}
		
		
		
	}
}
///////////////////////////
/**
 * 실행
 * javaExceiption
 */

