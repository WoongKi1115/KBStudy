package day05.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam02 extends ArrayList<Integer>{
	// 앞을 List로 하게되면 이후 모든 유지보수를 할 때 
	// 더 편하게 바꿀 수 있음. 만약 ArrayList로 둘 다 하게 되면
	// 이후 ArrayList에서 LinkedList로 바꾸게 되면 다 바꾸는 상황이 오게 됨..
	List<Integer> list = new ArrayList<>(5); //5공간
	// Integer 대신 int를 사용할 수 없음. <> 안에는 객체밖에 올 수 없음.
	public ListExam02() {
		
		super(5);// => 5개 공간의 arrayList 생성. => ArrayList를 상속받고 그 생성자를 실행. 
		// 기능
		// 숫자를 넣었지만 객체로 바꾸어서 넣어진 것임. -> 오토박싱.
		super.add(5);
		this.add(45);
		add(35);
		super.add(25);
		this.add(15);
		add(12);
		
		System.out.println(this); // list.toString이 호출될 것임.
		
		for (int i = 0; i<super.size(); i++) {
			int data = this.get(i);  // 객체로 있는 요소를 int로 바꾸어줌 -> 언박싱
			System.out.println(data);
		}
		this.remove(0);
		System.out.println("저장된 개수 = " + super.size());
		for (int i = 0; i<this.size(); i++) {
			int data = this.get(i);  // 객체로 있는 요소를 int로 바꾸어줌 -> 언박싱
			System.out.println(data);
		}
		
		Collections.sort(this);
		System.out.println(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListExam02();
	}

}
