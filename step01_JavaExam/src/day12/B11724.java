package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class B11724 {
	static int n;
	static int m;
	static ArrayList<Integer> []arr;
	static int cnt;
	static boolean [] visited;
	static Stack<Integer> stack;
	
	public static void checkComponent(int x) {
		if (visited[x]== false) {
			visited[x]=true;
			stack.add(x);
		} else {
			return;
		}
		
		int num = stack.pop();
		for (int i = 0; i<arr[num].size();i++) {
			checkComponent(arr[num].get(i));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new ArrayList[n+1];
		for (int i = 1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		
		
		for (int i = 0; i<m; i++) {
			str = reader.readLine().split(" ");
			int x =Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			arr[x].add(y);
			arr[y].add(x);
		}
		
		visited = new boolean [n+1];
		cnt = 0;
		for (int i = 1; i<=n; i++) {
			if (visited[i] == false) {
				stack = new Stack<>();
				checkComponent(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
