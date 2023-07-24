package day05.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExam03 {
	
	List<Student> list = new ArrayList<>();
	public ListExam03() {
		list.add(new Student(200, "웅기", 15, "광주"));
		list.add(new Student(400, "채은", 12, "대구"));
		list.add(new Student(300, "형운", 13, "서울"));
		list.add(new Student(500, "민혁", 18, "울산"));
		list.add(new Student(100, "영수", 11, "부산"));
		
		print(list);
		// 학번 기준 정렬 - Comparable 활용(직접 객체가 구현해서 사용함)
		List<Student> sortList = new ArrayList<>(list); // => 얕은 복사(정렬시킬 배열을 만들기 위함)
		Collections.sort(sortList);// => 이렇게 하면 원본을 회손함.
		System.out.println("**** 학번으로 정렬된 버전 ****");
		print(sortList);
		System.out.println("**** 원본 버전 ****");
		print(list);
		
		/**
		 * 나이정렬 Comparator 활용
		 */
		sortList = new ArrayList<>(list);
		Collections.sort(sortList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getAge() - o2.getAge();
			}
		});
		System.out.println("**** 나이로 정렬된 버전 ****");
		print(sortList);
		
		}
	
	public void print(List<Student> list) {
		System.out.println("***** 출력하기 *****");
		for (Student s : list) {
			System.out.println(s); //s.toString
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListExam03();
		
	}

}
