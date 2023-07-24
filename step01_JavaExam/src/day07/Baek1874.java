package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Baek1874 {

	public static void main(String[] args) throws IOException{
		
		Stack<Integer> stack = new Stack<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int [] arr = new int [n];
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		StringBuilder result = new StringBuilder();
		int idx = 0;

		for (int i = 1; i<n+1; i++) {
			stack.add(i);
			result.append("+\n");
			while (!stack.isEmpty() && arr[idx]==stack.peek()) {
				stack.pop();
				result.append("-\n");
				if (idx<n-1) idx++;

			}
		}
		if (stack.isEmpty()) {
			System.out.println(result.toString());
		} else {
			System.out.println("NO");
		}
		


	}

}
