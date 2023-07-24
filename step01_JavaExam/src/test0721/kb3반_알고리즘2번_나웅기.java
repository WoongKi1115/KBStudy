package test0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// i는 행, j는 열, day는 퇴소한 날짜
class Dot{
	int i;
	int j;
	int day;
	public Dot(int i, int j, int day) {
		this.i = i;
		this.j = j;
		this.day = day;
	}
}

public class kb3반_알고리즘2번_나웅기 {

	static int n; // 행
	static int m; // 열
	static int day; // 퇴소한 날짜
	static int [][] arr; // 강의실
	static boolean [][] visited; // 방문 여부
	static Queue<Dot> que; // bfs에 사용할 큐
	// 델타
	static int [] di = {-1, 0, 1, 0}; 
	static int [] dj = {0, 1, 0, -1};
	
	// 걸린 학생 수
	static int result;
	// x = 행 y = 열
	static void bfs(int x, int y) {
		// 걸린 학생 큐에 추가, 방문 처리
		que.add(new Dot(x, y, day));
		visited[x][y] = true;
		
		while (!que.isEmpty()) {
			Dot dot = que.poll();
			// 큐에서 나왔다면 걸린 학생이므로 result+1
			result++;
			for (int i = 0; i<4; i++) {
				int a = dot.i + di[i];
				int b = dot.j + dj[i];
				// 4방 탐색 시 범위 내에 있고, 학생이 있고, 방문하지 않은 곳일 때 수행.
				if ((0<=a && a<m) && (0 <= b && b< n) && arr[a][b] == 1 &&  visited[a][b] == false) {
					visited[a][b] = true;
					que.add(new Dot(a, b, dot.day+1));

					
				}
			
		    }	
			// 마지막 큐가 나올 때의 시간이 가장 오래된 시간이므로 저장
			day = dot.day;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] st = reader.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		m = Integer.parseInt(st[1]);
		
		arr = new int [m][n];
		visited = new boolean [m][n];
		que = new ArrayDeque<>();
		int cnt = 0;
		for (int i = 0; i<m; i++) {
			st = reader.readLine().split("");
			for (int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
				// 안걸린 학생 세기 위해 전체 학생 세기
				if (Integer.parseInt(st[j]) == 1) {
					cnt++;
				}
			}
		}
		st = reader.readLine().split(" ");
		
		// 3일 후퇴소이므로 3일부터 탐색 시작
		day = 3;
		result = 0;
		// 행 열
		bfs(Integer.parseInt(st[1]), Integer.parseInt(st[0]));
		
		System.out.println(day);
		// 전체에서 걸린사람 빼기
		System.out.println(cnt-result);
	}
}
