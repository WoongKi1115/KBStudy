package day03;

class Test {
	public void aa(Object ... i) { // ...을 사용하면 배열로 봄
		System.out.println("i = " + i);
		System.out.println("i.length = " + i.length);
		for (Object a : i) {
			System.out.printf("%s, ", a);
		}
		System.out.println();
		System.out.println("-------------------");
	}
	
	public void bb(String s, int ...i) {
		
	}
}

public class VariableArgsExam {
	public static void main(String[] args) {
		Test t = new Test();
		t.aa(0);
		t.aa();
		t.aa(2,3);
		t.aa(1,3,4,5,6);
		t.aa(1, 3, "ab", 2);
	}

}
