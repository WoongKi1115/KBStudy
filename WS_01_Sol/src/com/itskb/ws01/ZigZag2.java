package com.itskb.ws01;

public class ZigZag2 {

	public static void main(String[] args) {
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;
		
		// #2 
		// | ^ | ^
		// | | | |
		// | | | |
		// V | V |
		
		int col = intArray[0].length; //열의 길이 5
		int row = intArray.length; //행의길이 4
		double nansu = Math.random();
		
		for (int i = 0; i < col; i++) {//
			if( i % 2 == 0 ) {//첫번째(0), 세번째(2), 행
				for (int j = 0; j < row ; j++) { // 0 1 2 3
					System.out.printf( "%3d", intArray[j][i]); // j 가 row i 가 col
				}
			}else {
				for (int j = row-1; j >= 0; j--) {//3 2 1 0
					System.out.printf( "%3d", intArray[j][i]);
				}
			}
			System.out.println();
		}	
	}

}
