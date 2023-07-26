package ex0725;

import java.util.HashSet;
import java.util.Iterator;

public class SetExam extends HashSet<String>{
	public SetExam(String [] args) {
		super();
		
		// 추가
		for (String s : args) {
			boolean result = super.add(s);
			System.out.println(s+ "추가 결과 : " + result);
		}
		// 상속으로 hashset을 가져와서 super로 지정해주어야 함.
		System.out.println("저장된 개수 : " + super.size());
		System.out.println(this);
		
		System.out.println("***요소를 하나씩 출력 ***");
		/**
		 * Iterator interface는 collection에 있는 모든 자료 구조 안에 있는 요소를 거내는 전용 interface
		 * list, set, map 모두 iterator을 이용하여 요소를 하나씩 꺼낼 수 있음.
		 */
		Iterator<String> it = super.iterator();
		while (it.hasNext()) {// 요소가 존재한다면
			String name = it.next(); // 존재하면 next로 꺼냄.
			System.out.println(name);
			
		}
		System.out.println("-------- vs --------");
		// Iterator과 결과는 똑같음. 그냥 아래로 쓰자
		for (String name : this) {
			System.out.println(name);
		}
		
		// 제거  => boolean형태로 반환
		boolean re = super.remove("웅기");
		if (re) {
			System.out.println("제거 성공 : " + this);
		} else {
			System.out.println("제거 실패 : " + this);
		}
	}
	
	public static void main(String[] args) {
		new SetExam(args);
	}
}
