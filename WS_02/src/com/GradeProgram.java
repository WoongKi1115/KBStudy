package com;

import java.util.Scanner;

class CalculateGrade {
	
	// 이름
	String name;
	// 총점 구하기
	private int totalScore(int x, int y, int z) {
		return x + y + z;
	}
	
	// 평균 구하기
	private double scoreAverage(int total) {
		return total / 3.0;
	}
	
	// 등급 구하기
	private char getGrade(double average) {
		char grade = average >= 80 ? 'A' : 'F';
		return grade;
	}
	
	// 이름, 국어, 영어, 수학 출력 
	public void detailGrade(String name, int kor, int eng, int math) {
		this.name = name;
		int total =  this.totalScore(kor, eng, math);
		double avg = this.scoreAverage(total);
		char grade = this.getGrade(avg);
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println("등급 : " + grade);
	}	
}


public class GradeProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1. 성적표구하기 2. 종료 ");
			int pick = sc.nextInt();
			if (pick == 1) {
				sc.nextLine();
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("국어 : ");
				int kor = sc.nextInt();
				System.out.print("영어 : ");
				int eng = sc.nextInt();
				System.out.print("수학 : ");
				int math = sc.nextInt();
				CalculateGrade cg = new CalculateGrade();
				cg.detailGrade(name, kor, eng, math);
			} else {
				System.exit(0); //프로그램 강제 종료
			}
		}
	}

}
