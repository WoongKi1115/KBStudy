package day01;

public class Grade {
	public static void main(String[] args) {
		String name = "나웅기";
		// 45~100
		int korean = (int)(Math.random() * 56) + 45;
		int english = (int)(Math.random() * 56) + 45;
		int math = (int)(Math.random() * 56) + 45;
		int total = korean + english + math;
		double average = total/3.0;
		char grade = average >= 70 ? 'A' : 'F';
		System.out.println("이름 : " + name);
		System.out.println("국어점수 : " + korean);
		System.out.println("영어점수 : " + english);
		System.out.println("수학점수 : " + math);
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		System.out.println("학점 : " + grade);
	}
}
