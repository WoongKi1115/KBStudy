package day07;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		// 값 추가
		//push 메소드 -- O(1)
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		
		//add 메소드   -- O(N)
		stack.add(4);
		stack.add(0, 12);
		System.out.println(stack);

		// 값 삭제
		// pop 메소드 리턴 후 삭제. -- O(1)
		int pop_value = stack.pop();
		System.out.println("pop : " + pop_value);
		System.out.println(stack);
		
		// remove 메소드 인덱스 값을 삭제 -- O(N)
		stack.remove(2);
		System.out.println(stack);
		
		// peek 메소드 가장 오른쪽 인덱스 값 반환. pop 했을 때 삭제될 값.
		System.out.println(stack.peek());
		
		// isEmpty 스택이 비어있는지 확인하는 메서드
		System.out.println(stack.isEmpty());
		
		// clear 메소드 스택을 초기화 (비어있는 상태로 만듬)
		stack.clear();
		System.out.println(stack);
		System.out.println(stack.isEmpty());
	}

}
