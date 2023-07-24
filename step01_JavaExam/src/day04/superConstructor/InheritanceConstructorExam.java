package day04.superConstructor;

class Parent {
//	Parent() {
//		System.out.println(1);
//	}
	
	Parent(int i) {
		System.out.println(2);
	}
	
	Parent(String s) {
		System.out.println(3);
	}
}

class Child extends Parent { // Child is Parent
	Child() {
		this(3);
		System.out.println(4);
	}
	
	Child(int i) {
		super("2");
		System.out.println(5);
	}
	
	Child(boolean b) {
		super(2);
		System.out.println(6);
	}
}

public class InheritanceConstructorExam {
	public static void main(String[] args) {
		new Child(); //1, 4
		new Child(10); // 1, 5
		
		// 결론 : 자식이 생성될 때 무조건 부모의 기본 생성자가 호출됨.
		// => 자식 생성자 구현부 첫번째 줄에 super()가 생략되어 있음.
		
		// 만약 부모쪽에 생성자를 한개도 작성하지 않았다면
		// 아무 문제 없이 실행됨. => 생성자가 없어도 기본생성자가 있는 것으로 판단하므로.
		
		// 만약 부모에 기본 생성자 없이 인수가 있는 생성자를 추가한다면
		// 에러가 발생 => 생성자를 하나라도 추가하면 기본 생성자가 추가가 안되므로 해당 기본 생성자가 없는 것으로 보고
		// 에러가 발생하게 됨. => 때문에 기본생성자를 만들고 생성자를 만드는 것을 권장.
		
		// 만약 부모쪽에 기본생성자 없이 인수가 있는 생성자를 추가한다면
		// :모든 자식생성자 구현부 첫줄에 다른 생성자를 호출해야함.
	}
}
