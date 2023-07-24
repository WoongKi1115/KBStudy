package day06;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		int arr [] = new int[4];

		System.out.println(arr);

		System.out.println(Arrays.toString(arr));

		// 배열의 모든 값을 채워줌. fill(배열, 값)
		Arrays.fill(arr,100);

		System.out.println(Arrays.toString(arr));

		// 배열을 원하는 값으로 초기화
		// new는 메모리를 다시 할당해주는 것.
		// 위에서 int [4]로 4칸을 줬지만 새로운 메모리를 할당해 5개로 새로 만듬.
		arr = new int [] {5, 4, 3, 2, 1};
		System.out.println(Arrays.toString(arr));

		// 정렬 => Arrays.sort(배열) => 오름차순
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// Arrays.copyofRange(배열, 시작인덱스, 끝 인덱스); => 원하는 인덱스 값을 가져옴
		// 파이썬의 arr[1:3]과 동일
		int [] copyArr = Arrays.copyOfRange(arr, 1, 3);
		System.out.println(Arrays.toString(copyArr));

		int [][] arr2d = {{1,2}, {3,4}, {5,6}};
		System.out.println(Arrays.toString(arr2d));

		// 2차원 배열 출력 방법 1
		for (int i = 0; i < arr2d.length; i++) {
			System.out.println(Arrays.toString(arr2d[i]));
		}

		System.out.println(Arrays.deepToString(arr2d));

		// ctrl + d = 코드 한줄 삭제
		// ctrl + i = 소스 indent 정리
		// ctrl + shift + o = import 추가해줌
		
	}
}
