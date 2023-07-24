package com.itskb.ws02;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenOddSumDelta {
     //https://yeomss.tistory.com/330 참고
	//상이나 좌 같은 경우는 배열 범위가 0보다 커야하고, 하 나 우 같은 경우는 배열 범위가 N 보다 작아야 한다.
	// 상하좌우의 합이 짝수이면 해당 좌표의 값을 sum 에 더한다.
	// 상,하,좌,우 중 경계를 벗어나는 경우는 제외하고 주변의 합을 계산한다.
	
	/*
	 * 4방,8방 탐색할때 현재 위치 기준으로 4방,8방 탐색 위치가 현위치 기준으로 
	 * 일정값만큼 더해지거나 감소하는  규칙이 있는데 더해지거나 감소하는 일정값을 델타값이라고 부름
	 * */
 
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/EvenOddSumInput.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] input = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		int sum = 0;
		int[] dy = { -1, 1,  0, 0 }; //i  상, 하 좌 우
		int[] dx = {  0, 0, -1, 1 }; //j  상하 좌 우
		
		for (int i = 0; i < N; i++) {//
			for (int j = 0; j < N; j++) {
				int all = 0;
				 
				for (int d = 0 ; d < 4; d++) { //상 하 좌 우  0 1 2 3
					int ny = i + dy[d]; //상 or 하
					int nx = j + dx[d];// 죄 or 우 
					
					if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue; //상 좌 하 우
					
					all += input[ny][nx]; //상하좌우 합 구하기 
					System.out.print(input[ny][nx]+"  ");
				}
				
				System.out.println();
				if( all % 2 == 0 ) {
					sum += input[i][j];
//					System.out.println(y + " " + x + " " + input[y][x]);
				}
			}
		}
		
		System.out.println(sum);
		sc.close();
	}

}
