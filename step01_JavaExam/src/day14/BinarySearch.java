package day14;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int [] arr = {5, 1, 7, 6, 8};
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int find = Arrays.binarySearch(arr, 5);
		System.out.println(find);
		
		int find2 = Arrays.binarySearch(arr, 100000);
		System.out.println(find2);
	}
}
