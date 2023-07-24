package day09;

// 순열
public class PermutationTest {
	
	// 전역으로 사용할 static 변수 만듬.
	static char [] arr;
	static int N;
	static int R;
	static int [] select;
	static boolean [] isSelected;
	
	public static void permutation(int r) {
		if (r==R) {
			return;
		}
		
		for (int i = 0; i<arr.length; i++) {
			// 선택이 된거면 skip
			if (isSelected[i] == true) continue;
			
			// 선택
			select[r] = i;
			isSelected[r] = true;
			permutation(r+1);
			isSelected[r] = false;
			
		}
	}
	
	// 중복 순열 = 중복 혀용
	// r 은 지금까지 선택한 개수
	public static void dup_permutation(int r) {
		// 종료 조건
		if (r == R) {
			for (int i = 0; i < select.length; i++) {
				System.out.print(arr[select[i]]);
				}
			System.out.println();
			return;
		}
		// 재귀 확장
		for (int i = 0; i < arr.length; i++) {
			select[r] = i;
			dup_permutation(r+1);
		}
	}
	
	public static void main(String[] args) {
		arr = new char [] {'A', 'B', 'C', 'D'};
		N = 4;
		R = 2;
		select = new int [R];
		isSelected = new boolean [R];
		// 중복 순열
		dup_permutation(0);
	}
}
