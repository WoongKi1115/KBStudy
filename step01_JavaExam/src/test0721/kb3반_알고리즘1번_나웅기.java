package test0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb3반_알고리즘1번_나웅기 {
	
	static int n; // 마을 사람 수
	static int e; // 관계 수
	static int [] arr; // 친구
	static int result; // 친구 수
	
	// union find로 구함
	static int find(int x) {
		if (x == arr[x]) return x;
		return arr[x] = find(arr[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			if (x < y) {
				arr[y] = x;
			} else {
				arr[x] = y;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		e = Integer.parseInt(reader.readLine());
		
		arr = new int [n+1];
		Arrays.setAll(arr, (i) -> i);
		
		StringTokenizer st;
		for (int i = 0; i<e; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		// 철수는 제외하므로 -1부터 시작
		result = -1;
		for (int i : arr) {
			if (find(i) == 1) {
				result++;
			}
		}
		System.out.println(result);
	}
}
