package day02;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// 키보드 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		// 2. 
		sc.nextLine();
		
		System.out.print("이름은?");
		// 1. nextLine은 개행을 읽음(엔터) 
		String name = sc.nextLine();
//		String name = sc.next();	
		System.out.println("입력 점수 : " + kor + ", " + eng + " , " + name);
		sc.nextInt();
		
	}

}

/**
* 모니터 출력 - System.out
* 키보드 입력 - System.in
*/