package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
	// [5, 2, 3, 4, 1]
	public static int partition(int [] arr, int left, int right) {
		int pivot = left;
		int l = left+1;
		int r = right; 
		int temp = 0;
		while (l<=r) {
			while (l <= r && arr[l]<=arr[pivot]) l++;
			while (l <= r && arr[pivot]<arr[r]) r--;

			if (l < r) {				
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		temp = arr[pivot];
		arr[pivot] = arr[r];
		arr[r] = temp;
		return r;
	}
	
	public static void Quick(int [] arr ,int left, int right) {
		if (left >= right) return;
		int pivot = partition(arr, left, right);
		Quick(arr ,left, pivot-1);
		Quick(arr, pivot+1, right);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int [] arr = new int [n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
				
		Quick(arr, 0, n-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
