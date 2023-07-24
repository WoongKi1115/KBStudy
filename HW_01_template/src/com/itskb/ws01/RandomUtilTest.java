package com.itskb.ws01;

public class RandomUtilTest {

	public static void main(String[] args) {
		RandomUtil ru = new RandomUtil();
		
		int from = 20;
		int to = 60;
		
		System.out.println("\n1. Math.random() 활용------------------------");
		for (int i = 0; i < 100; i++) {
			int nansu = ru.getRandomInt1(from, to);
			System.out.printf( "%4d", nansu );
		}
		
		
		
		System.out.println("\n1. Random객체 활용------------------------");
		for (int i = 0; i < 100; i++) {
			System.out.printf( "%4d", ru.getRandomInt2(from, to) );
		}
		
	}

}
