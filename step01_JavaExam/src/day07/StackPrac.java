package day07;

import java.util.Stack;

public class StackPrac {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		System.out.println("stack : " + stack);
		
		int top = stack.pop();
		System.out.println("top : " + top);
		System.out.println("stack : " + stack);
		System.out.println("stack의 맨 윗 값 : " + stack.peek());
		while (!stack.isEmpty()) {
			stack.pop();
			System.out.println("stack : " + stack);
		}

	}

}
