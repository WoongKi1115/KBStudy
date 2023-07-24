package day02;

class Test {
	int a = 10; // non-static 변수 (인스턴스 변수) 객체를 생성해야 사용할 수 있는 변수
	static int b = 5;
	
	public void aa() {
		
	}
	// 인스턴스 매서드(객체를 생성해야 사용가능한 메서드)는 Test class를 생성해야 사용 가능하므로
	// this이든 static 매서드이든 전부 사용할 수 있음.(Test class 안에 다 담겨있으므로)
	
	// 하지만 static 매서드는 객체를 생성하지 않고 사용함. 즉 이미 static 영역에 담겨있음.
	// 때문에 static끼리는 같은 영역에 있으므로 사용할 수 있음.
	public void bb() {
		System.out.println(a);
		System.out.println(this.a);
		
		System.out.println(b);
		// static 변수라서 class.변수명 으로 가져오는게 맞지만
		// this.변수명도 가능은 함.
		// 하지만 static method 내에서는 this 사용 불가능.
		System.out.println(this.b);
		System.out.println(Test.b);
		
		aa();
		this.aa();
		
		cc();
		this.cc();
		Test.cc();
		
	}
	
	public static void cc() {
		
	}
	
	// static 메섣4ㅡ 안에서 static만 접근 가능. this 사용 불가
	public static void dd() {
		// static 메서드에선 static만 사용 가능.
//		System.out.println(a);
		// this 사용 불가.
//		System.out.println(this.a);
		
		System.out.println(b);
//		System.out.println(this.b);
		System.out.println(Test.b);
		
//		aa();
//		this.aa();
		
		cc();
//		this.cc();
		Test.cc();
	}
}

public class StaticExam {

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		// t1~t3까지의 주소는 다 다름
		// t1~t3의 non static 변수의 주소는 다 다름
		// 하지만 static b는 static 영역을 참조하고 있으므로 주소 값이 동일함
		// static은 공유 필드로 보면 됨.
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		System.out.println("---------------------------");
		System.out.println("t1.a = " + t1.a);
		System.out.println("t2.a = " + t2.a);
		System.out.println("t3.a = " + t3.a);
		System.out.println("---------------------------");
		// 값 변경
		t2.a = 50;
		System.out.println("t1.a = " + t1.a);
		System.out.println("t2.a = " + t2.a);
		System.out.println("t3.a = " + t3.a);
		System.out.println("---------------------------");
		
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		System.out.println("Test.b = " + Test.b);
		System.out.println("---------------------------");
		t2.b = 200;
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		System.out.println("Test.b = " + Test.b);
		System.out.println("---------------------------");
	}

}
