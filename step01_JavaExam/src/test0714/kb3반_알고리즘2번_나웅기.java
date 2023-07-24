package test0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kb3반_알고리즘2번_나웅기 {
	
	static int N;    // 사용 가능 숫자
	static int M;    // 최대 숫자 합
	static int [] arr;
	static int maxSum;
	static void subSet(int x, int cnt, int sum) {
		
		// 3개의 수를 골랐고, 그 합이 M보다 작을 때 최대값을 구함.
		// 넘지 않아야 하므로 <=
		if (cnt == 3 && sum <= M && sum>maxSum) {
			maxSum = sum;
			return;
		}
		
		if (x==N) return;
		
		// 선택 o
		subSet(x+1, cnt+1, sum+arr[x]);
		
		// 선택 x
		subSet(x+1, cnt, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		str = reader.readLine().split(" ");
		arr = new int [N];
		
		for (int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		subSet(0, 0, 0);
		System.out.println(maxSum);
		
	}
}
