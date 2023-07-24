package day06;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start1 , end1 ;
		start1 = System.currentTimeMillis();     // 시작 시간
		int N = 50000;
		int result = 0;
		// 반복문 (여러 시간복잡도와 N 을 설정해서 테스트 해보세요) //
		for (int i = 0; i<N; i++) {
				result += i;

		}
		end1 = System.currentTimeMillis();        // 종료 시간
		System.out.println("반복문 실행시간(ms) : " + (end1 - start1));
		
		start1 = System.currentTimeMillis();     // 시작 시간
		int result1 = 0;
		// 반복문 (여러 시간복잡도와 N 을 설정해서 테스트 해보세요) //
		for (int i = 0; i<N; i++) {
			for (int j = 0; j <N; j++) {
				
				result1 += i;
			}
		}
		end1 = System.currentTimeMillis();        // 종료 시간
		System.out.println("반복문 실행시간(ms) : " + (end1 - start1));
	}

}
