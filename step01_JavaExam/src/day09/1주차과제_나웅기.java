package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
		str = reader.readLine().split(" ");
		long [] arr = new long [N + 1];
		long [] cnt = new long [M];
		long result = 0;
		
		for (int i = 1; i<N + 1;i++) {
			arr[i] = (arr[i-1] + Integer.parseInt(str[i-1]))%M;
			if (arr[i] == 0) result++;
			
			cnt[(int) arr[i]]++;
		}
		
		for (int i = 0; i<M; i++) {
			if (cnt[i] > 1) {
				result += (cnt[i]*(cnt[i]-1)/2);
			}
		}
		
		System.out.println(result);
	}
}
