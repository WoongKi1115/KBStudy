package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2493 {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String [] arr = reader.readLine().split(" ");
		Stack<Integer> stack = new Stack<>();
		for (String i : arr) {
			stack.add(Integer.parseInt(i));
		}
		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()) {
			int x = stack.pop();
			String result = "0 ";
			for (int i = stack.size()-1; i>=0; i--) {
				System.out.println(stack.get(i));
				if (stack.get(i)>=x) {
					result = Integer.toString(i+1) + " ";
					System.out.println("result" + result);
					break;
				}				
			}
			sb.append(result);
		}
		sb.reverse();
		System.out.println(sb);
	}

}
