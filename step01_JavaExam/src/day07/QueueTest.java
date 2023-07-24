package day07;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		// Queue = 인터페이스 객체. ArrayDeque, LinkedList로 구현.
		Queue<Integer> que1= new ArrayDeque<>();
		Queue<Integer> que2 = new LinkedList<>();
		
		// add/offer 메서드 => 값 추가
		que1.add(1);
		que1.add(2);
		que1.offer(4);
		que1.add(4);
		System.out.println(que1);
		
		//poll, remove 메서드 => 값 삭제
		int value = que1.poll();
		System.out.println(value);
		System.out.println(que1);
		
		// peek 메서드 => que 가장 앞에 값 확인
		System.out.println(que1.peek());
		
		// isempty 메서드
		System.out.println(que1.isEmpty());
	}

}
