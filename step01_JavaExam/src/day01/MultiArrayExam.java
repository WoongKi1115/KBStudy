package day01;

public class MultiArrayExam {

	public static void main(String[] args) {
		// 3행 5열
//		int [][] arr = new int [3][5];
		
		int [][] arr = new int [][] {
			{1 ,3, 5, 7},
			{2, 4, 6},
			{11, 13, 15, 17},
			{12, 14, 16, 18}
		};
		System.out.println("arr = " + arr);
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[0][0] = " + arr[0][0]);
		
		
		int len1 = arr.length;
		for (int i = 0; i < len1; i++) {
			int len2 = arr[i].length;
			for (int j = 0; j < len2; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("--------");
		
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}

}
