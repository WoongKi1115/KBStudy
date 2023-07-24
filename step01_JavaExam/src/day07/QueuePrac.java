package day07;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueuePrac {

	public static void main(String[] args) {
		Queue<Integer> que = new ArrayDeque<>();
		que.add(100);
		que.offer(200);
		que.offer(300);
		que.add(400);
		que.add(500);
		System.out.println("que : " + que);
		
		int front = que.poll();
		System.out.println("front : " + front);
		System.out.println("que : " + que);
		System.out.println("맨 앞의 값 : " + que.peek());
		
		while (!que.isEmpty()) {
			que.poll();
			System.out.println("que : " + que);
		}

	}

}
