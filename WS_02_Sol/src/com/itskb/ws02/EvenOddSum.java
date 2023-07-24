package com.itskb.ws02;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenOddSum {

	//상이나 좌 같은 경우는 배열 범위가 0보다 커야하고, 하 나 우 같은 경우는 배열 범위가 N 보다 작아야 한다.
		// 상하좌우의 합이 짝수이면 해당 좌표의 값을 sum 에 더한다.
		// 상,하,좌,우 중 경계를 벗어나는 경우는 제외하고 주변의 합을 계산한다.
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/EvenOddSumInput.txt"));//키보드 입력 대신 해당 경로에 있는 파일을 이용하여 바이트 파일을 읽어옴
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //6
		int[][] input = new int[N][N];
		
		for (int i = 0; i < N; i++) {//행
			for (int j = 0; j < N; j++) { //열
				input[i][j] = sc.nextInt();
				
			}
		
		}

		int sum = 0;
		
		for (int i = 0; i < N; i++) {//행
			for (int j = 0; j < N; j++) {//열
				
				int top = 0;
				int bottom = 0;
				int left = 0;
				int right = 0;
				
				
				if( i-1 >=0 ) top = input[i-1][j]; //상
				if( i+1 < N ) bottom = input[i+1][j];//하
				
				if( j-1 >=0 ) left = input[i][j-1];//좌
				if( j+1 < N ) right = input[i][j+1];//우
				
				//System.out.println( left+ " , " + right +", "+top+", " + bottom +" , " );
				
				if( (top + bottom + left + right) % 2 == 0 ) {
					sum += input[i][j];
					//System.out.println(i + " " + j + " " + input[i][j] +"\n");
				}
			}
			//System.out.println("----------------------------");
		}
		
		System.out.println(sum);
		sc.close();
	}

}
