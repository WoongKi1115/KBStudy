package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class B1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String [] str = reader.readLine().split(" ");
		StringBuilder result = new StringBuilder();
		result.append("<");
		Queue<Integer> que = new ArrayDeque<>();
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		for (int i = 1; i<=n; i++) {
			que.add(i);
		}
		
		while (que.size()!=1) {
			for (int i = 0; i<k-1; i++) {
				que.add(que.poll());
			}
			int target = que.poll();
			
			result.append(Integer.toString(target)+", ");
		}
		result.append(Integer.toString(que.poll())+">");
		System.out.println(result);
		
	}

}
