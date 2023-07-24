package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Baek10807 {
	// Buffered Reader, Scanner
	// Buffered가 시간은 훨씬 빠르지만, Scanner는 더 편리.
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		// 한줄씩 읽고 하나의 String으로 받음.
//		int N = Integer.parseInt(reader.readLine());
//		System.out.println(N);
//		String str = reader.readLine();
//		// split을 활용하면 split() 안에 들어가는 변수를 기준으로 나누어 배열로 만들어줌.
//	
//		String [] strs = str.split(" ");
//		int [] arr = new int[N];
//		for (int i = 0; i<N; i++) {
//			arr[i] = Integer.parseInt(strs[i]);
//		}
//		System.out.println(Arrays.toString(arr));
//		str = reader.readLine();
//		int v = Integer.parseInt(str);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0;
		int v = sc.nextInt();
		for (int i : arr) {
			if (v == i) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
		}

}
