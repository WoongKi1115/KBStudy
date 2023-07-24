package test0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class kb3반_알고리즘3번_나웅기 {
	static int [][] arr;
	static boolean [][] visited;
	static int [][] answer; 
	static int winner = 0;
	static ArrayList<ArrayList<Integer>> result;
	// 상우하좌
	static int [] di = new int [] {-1, 0, 1, 0};
	static int [] dj = new int [] {0, 1, 0, -1};
	// 상우하좌 대각선
	static int [] dix = new int [] {-1, 1, 1, -1};
	static int [] djx = new int [] {1, 1, -1, -1};
	
	static void checkPlus(int color, int side, int cnt, int i, int j, ArrayList<ArrayList<Integer>> ar) {
		
		if (cnt == 5 && arr[i+di[side]][j+dj[side]] != color) {
			winner = color;
			result = ar;
			return;
		}
		
		if (cnt > 5) return;
		
		if (arr[i+di[side]][j+dj[side]] == color) {
			visited[i+di[side]][j+dj[side]] = true;
			ar.add(new ArrayList<Integer>());
			ar.get(cnt).add(i);
			ar.get(cnt).add(j);
			checkPlus(color, side, cnt+1, i+di[side], j+dj[side], ar);
		} else {
			return;
		}
	}
	
	
	static void checkX(int color, int side, int cnt, int i, int j, ArrayList<ArrayList<Integer>> ar) {

		if (cnt == 5 && arr[i+dix[side]][j+djx[side]] != color) {
			winner = color;
			result = ar;
			return;
		}
		
		if (cnt > 5) return;
		
		if (arr[i+dix[side]][j+djx[side]] == color) {
			visited[i+dix[side]][j+djx[side]] = true;
			ar.add(new ArrayList<Integer>());
			ar.get(cnt).add(i);
			ar.get(cnt).add(j);
			checkX(color, side, cnt+1, i+dix[side], j+djx[side], ar);
			
		} else {
			return;
		}
	}
	
	
	static void eightSide(int color, int i, int j) {
		ArrayList<ArrayList<Integer>> array = new ArrayList<>();
		array.add(new ArrayList<Integer>());
		array.get(0).add(i);
		array.get(0).add(j);

		for (int d = 0; d<4; d++) {
			int dy = i+di[d];
			int dx = j+dj[d];
			if ((dy>=0 && dy < 19 && dx>=0 && dx < 19) && arr[dy][dx] == color && visited[dy][dx] == false) {
				array.add(new ArrayList<Integer>());
				array.get(1).add(i);
				array.get(1).add(j);
				visited[dy][dx] = true;
				checkPlus(color, d, 2, dy, dx, array);
				
			}
			dy = i+dix[d];
			dx = j+djx[d];
			if ((dy>=0 && dy < 19 && dx>=0 && dx < 19) && arr[dy][dx] == color && visited[dy][dx] == false) {


				array.add(new ArrayList<Integer>());
				array.get(1).add(i);
				array.get(1).add(j);
				visited[dy][dx] = true;
				checkX(color, d, 2, dy, dx, array);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		arr = new int [19][19];
		visited = new boolean [19][19];
		for (int i = 0; i<19; i++) {
			String [] str = reader.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		
		for (int i = 0; i<19; i++) {
			for (int j = 0; j<19; j++) {
				if (arr[i][j] != 0) {
					eightSide(arr[i][j],i,j);
					visited[i][j] = true;
				}
			}
		}
		int resultA = 20;
		int resultB = 20;
		
		if (result != null) {
			
		for (ArrayList<Integer> a : result) {
			if (a.get(0) < resultA) {
				if (a.get(0) == resultA && a.get(1) < resultB) {					
					resultA = a.get(0);
					resultB = a.get(1);
				}
				resultA = a.get(0);
				resultB = a.get(1);
			}
		}
		}
		System.out.println(winner);
		if (resultA != 20) {			
		System.out.print(resultA+1 + " ");
		System.out.println(resultB+1);
		}
		
	}
	
}
