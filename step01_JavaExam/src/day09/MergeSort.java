package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

	public static void Merge(int [] arr, int [] tmp, int left, int right) {
		if (left >= right) return;
		int center = (left + right) / 2;
		Merge(arr, tmp, left, center);
		Merge(arr, tmp, center+1, right);
		int lIdx = left;
		int rIdx = center+1;
		
		for (int i = left; i<=right; i++) {
			if ((arr[lIdx] > arr[rIdx] && right > rIdx) || lIdx > center) {
				tmp[i] = arr[rIdx];
				rIdx++;
			} else if ((arr[lIdx] <= arr[rIdx] && lIdx <= center) || rIdx > right)  {
				tmp[i] = arr[lIdx];
				lIdx++;
			}
		}
		
		for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int [] arr = new int [n];
		int [] tmp = new int [n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		Merge(arr, tmp, 0, n-1);
		System.out.println(Arrays.toString(tmp));
	}

}
