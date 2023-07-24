package day10;

public class CombinationTest {
	static char [] arr;
	static int N; // 문자열 개수
	static int R; // 선택 개수
	
	static int [] select; // 선택 저장 변수
	static boolean [] isSelected; // 마킹 배열
	
	
	public static void combination(int idx, int size) {
		
		// 종료 조건
		if (size == R) {
			for (int i = 0; i<R; i++) {
				System.out.print(arr[select[i]]);
			}
			System.out.println();
			return;
		}
		
		// 재귀 확장
		for (int i = idx; i<N; i++) {
			if (isSelected[i]) continue;

			isSelected[i] = true;
			select[size] = i;
			combination(i, size+1);
			
			isSelected[i] = false;
		}
	}
	
	
	
	public static void main(String[] args) {
		
		// 초기화 //
		arr = new char [] {'A', 'B', 'C', 'D'};
		N = arr.length;
		R = 2;
		
		select = new int [R];
		isSelected = new boolean [N];
		
		// 조합 실행 //
		combination(0, 0);
		
	}
}
