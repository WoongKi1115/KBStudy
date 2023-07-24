package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class B9663 {
	static int n;
	static int [] queen;
	static boolean [] visited;
	static int result;
	
	// (x, y) 좌표에 퀸을 놓은 경우에 대각선 충돌이 일어나는지
	static boolean checkValid(int x, int y) {
		// 다른 퀸들과 비교
		for (int queen_x = 0; queen_x<n; queen_x++) {
			
			// 퀸이 아직 선택되지 않은 경우
			if (x == queen_x || queen[queen_x] == -1) continue;
			
			// 대각선인 경우
			if (Math.abs(x - queen_x) == Math.abs(y - queen[queen_x])) {
				return false;
			}
		}
		
		return true;
	}
	
	// 순열 경우의 수 탐색
	static void dfs(int x) {
		// 종료 조건
		if (x >= n) {
			result++;
			return;
		}
		
		// 다음 선택
		for (int i = 0; i<n; i++) {
			if (visited[i]) continue;
			// 대각선 조건 확인
			if (!checkValid(x, i)) continue;
			
			visited[i] = true;
			queen[x] = i;
			
			dfs(x+1);
			
			visited[i] = false;
			queen[x] = -1;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		queen = new int [n];
		
		Arrays.fill(queen, -1);
		
		visited = new boolean [n];
		
		dfs(0);
		System.out.println(result);
	}

}
