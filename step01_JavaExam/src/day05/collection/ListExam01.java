package day05.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam01 {
	// 앞을 List로 하게되면 이후 모든 유지보수를 할 때 
	// 더 편하게 바꿀 수 있음. 만약 ArrayList로 둘 다 하게 되면
	// 이후 ArrayList에서 LinkedList로 바꾸게 되면 다 바꾸는 상황이 오게 됨..
	List<Integer> list = new ArrayList<>(5); //5공간
	// Integer 대신 int를 사용할 수 없음. <> 안에는 객체밖에 올 수 없음.
	public ListExam01() {
		// 기능
		// 숫자를 넣었지만 객체로 바꾸어서 넣어진 것임. -> 오토박싱.
		list.add(5);
		list.add(45);
		list.add(35);
		list.add(25);
		list.add(15);
		list.add(12);
		
		System.out.println(list.toString()); // list.toString이 호출될 것임.
		
		for (int i = 0; i<list.size(); i++) {
			int data = list.get(i);  // 객체로 있는 요소를 int로 바꾸어줌 -> 언박싱
			System.out.println(data);
		}
		list.remove(0);
		System.out.println("저장된 개수 = " + list.size());
		for (int i = 0; i<list.size(); i++) {
			int data = list.get(i);  // 객체로 있는 요소를 int로 바꾸어줌 -> 언박싱
			System.out.println(data);
		}
		
		Collections.sort(list);
		System.out.println(list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListExam01();
	}

}
