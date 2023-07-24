package day01;

public class ArrayExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {1,3,5,7,9,10};
		System.out.println("arr =  " + arr);
		
		// 배열 방 값 출력
		int len = arr.length;
		System.out.println("배열의 길이 = " + len);
		for(int i = 0; i < len; i++) {
			System.out.println("arr["+i+"]=" +arr[i]);
		}
		
		// 개선된 for 문 (Array, Collection)
		for (int a : arr) {
			System.out.println(a);
		}
		
		// 배열 방 값 변경
		arr[2] = 100;
		arr[0] = 50;
		arr[1] = arr[1] * 10;
		// 개선된 for 문 (Array, Collection)
		for (int a : arr) {
			System.out.println(a);
		}
				
	}

}
