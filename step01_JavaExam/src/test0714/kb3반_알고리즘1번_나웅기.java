package test0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kb3반_알고리즘1번_나웅기 {
	
	static void selectSort() {
		
	}
	
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(reader.readLine());
	int [] arr = new int [n];
	for (int i = 0; i<n; i++) {
		arr[i] = Integer.parseInt(reader.readLine());
	}
	
	for (int i = 0; i<n-1; i++) {
		int maxIdx = i;
		int maxNum = arr[i];
		for (int j = i; j<n; j++) {
			if (arr[j] > maxNum) {
				maxIdx = j;
				maxNum = arr[j];
			}
		}
		int temp = 0;
		if (i != maxIdx) {
			temp = arr[i];
			arr[i] = maxNum;
			arr[maxIdx] = temp;
		}
	}
	for (int i : arr) {
		System.out.println(i);
	}
	
	
}
}
