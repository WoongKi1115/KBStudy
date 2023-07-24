package test0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb3반_알고리즘3번_나웅기 {

	static int n; // 직선 구간 길이
	static int m; // 제한 시간
	static int [] arr; // 직선 구간
	static int res; // 결과 값
	
	// 조합으로 찾기
	static void cowBug(int idx, int time, int result) {
		// 종료 조건(인덱스를 넘거나, 시간 초과시 비교 후 종료)
		// 음수 값이 없으므로 인덱스나 시간을 최대로 다 쓰고 종료시킴
		if (idx >= n || time >= m) {
			if (res < result) {
				res = result;
			}
			return;
		}
		// 1칸 이동한 경우
		cowBug(idx+1, time+1, result + arr[idx+1]);
		// 2칸 이동한 경우
		cowBug(idx+2, time+1, result/2 + arr[idx+2]);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n+1];
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 최대 값을 찾아야 하므로 초기 값을 음수로.
		res = -1;
		cowBug(0, 0, 0);
		
		System.out.println(res);
	}
}
