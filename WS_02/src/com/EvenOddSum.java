package com;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSum {
	public static void main(String[] args) throws Exception {
		// 단순 system.in은 읽을 것을 찾음
		// 때문에 미리 setin을 해주면서 읽을 거리를 제공해줌
		System.setIn(new FileInputStream("src/com/EvenOddSumInput.txt"));
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int array [][] = new int [row][row];

		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		for (int [] a : array) {
			System.out.println(Arrays.toString(a));			
		}
	}

}
