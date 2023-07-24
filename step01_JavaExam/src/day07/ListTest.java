package day07;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {

	public static void main(String[] args) {
		
		// int, float, bool, char => primitive 자료형(기본 자료형) <-> reference(object)
		// Integer, boolean  => reference 타입.
		
		// ArrayList => 배열 기반 리스트 => 사이즈를 가변적으로 조정할 수 있는 리스트
		ArrayList<Integer> arrList = new ArrayList<>();
		
		// LinkedList => 연결 리스트 => 노드 포인터를 이용해 만든 리스트
		LinkedList<Integer> linkList = new LinkedList<>();
		
		// ArrayList와 LinkedList의 시간복잡도가 다름.
		
		// 크기 확인 => size()
//		System.out.println(arrList.size());
		
		// 값 추가 => add(), 위치를 정해서 추가 => add(위치, 값)
//		arrList.add(100);
//		arrList.add(200);
//		arrList.add(300);
//		arrList.add(1, 1000);
//		// arrList는 출력시 Arrays.toString을 안써도 됨.
//		System.out.println(arrList);
		
		// 시간 복잡도 확인 array vs linked (add)
		long start, end;
		// ArrayList - add 시간 복잡도
		int N = 50000;
		start = System.currentTimeMillis();		
		for (int i = 0; i<N; i++) {
			arrList.add(arrList.size()/2 ,10);
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList add 메소드 실행시간 (ms) : " + (end - start));
		
		// LinkedList - add 시간 복잡도
		start = System.currentTimeMillis();		
		for (int i = 0; i<N; i++) {
			linkList.add(linkList.size()/2, 10);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList add 메소드 실행시간 (ms) : " + (end - start));
		
		// ArrayList - get 시간 복잡도
		start = System.currentTimeMillis();		
		for (int i = 0; i<N; i++) {
			arrList.get(arrList.size()/2);
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList get 메소드 실행시간 (ms) : " + (end - start));
		
		// LinkedList - get 시간 복잡도
		start = System.currentTimeMillis();		
		for (int i = 0; i<N; i++) {
			linkList.get(linkList.size()/2);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList get 메소드 실행시간 (ms) : " + (end - start));
		
		// arrList.remove(인덱스), arrList.remove(<objectType> 10) => 10의 값을 삭제

		// ArrayList - remove 시간 복잡도
		start = System.currentTimeMillis();		
		for (int i = 0; i<N; i++) {
			arrList.remove(arrList.size()/2);
		}
		end = System.currentTimeMillis();
		System.out.println("ArrayList remove 메소드 실행시간 (ms) : " + (end - start));
		
		// LinkedList - remove 시간 복잡도
		start = System.currentTimeMillis();		
		for (int i = 0; i<N; i++) {
			linkList.remove(linkList.size()/2);
		}
		end = System.currentTimeMillis();
		System.out.println("LinkedList remove 메소드 실행시간 (ms) : " + (end - start));
		
		System.out.println("arrayList가 더 빠른데");
	}

}
