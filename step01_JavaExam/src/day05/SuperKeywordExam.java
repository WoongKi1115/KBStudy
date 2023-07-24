package day05;

class Parent {
	int a = 10;
	int b = 5;
	
	public void aa() {
		System.out.println("super aa()");
	}
	
	public void bb() {
		System.out.println("super bb()");
	}
}


class Child extends Parent {//Child is a Parent 성립
	int a = 50;
	int c = 30;
	
	@Override
	public void aa() {
		System.out.println("sub aa()");
		}
	
	public void cc() {
		System.out.println("sub cc()");
	}
	
	public void dd() {
		System.out.println(a); // 50
		System.out.println(this.a);  // 50
		System.out.println(super.a); // 10
		
		System.out.println("------------");
		System.out.println(b);//5
		System.out.println(this.b);//5
		System.out.println(super.b);//5
		
		System.out.println("---------------");
		System.out.println(c);//30
		System.out.println(this.c);//30
//		System.out.println(super.c);
		
		System.out.println("---메소드 호출----");
		aa();
		this.aa();
		super.aa();
		
		System.out.println("---------------");
		bb();
		this.bb();
		super.bb();
		
		System.out.println("--------------");
		cc();
		this.cc();
//		super.cc();
		
	}
}

public class SuperKeywordExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Child ch = new Child();
//		System.out.println("ch = " + ch);
//		System.out.println(ch.a);
//		System.out.println(ch.b);
//		System.out.println(ch.c);
//		
//		ch.aa();
//		ch.bb();
//		ch.cc();
		////////////////////////////
		Parent p = new Child();
		System.out.println("p = " + p);
		System.out.println(p.a);
		System.out.println(p.b);
		//부모 타입으로 자식 부분에는 접근이 불가능 => ObjectDownCasting이 필요
//		System.out.println(p.c);
		
		p.aa(); // => sub이 출력. : 재정의된 메소드는 부모타입이라도 재정의된 메소드로 됨.
		p.bb(); // => Super
//		p.cc(); // => 부모 타입으로 자식 부분에 접근 불가능
		if (p instanceof Child) {			
			Child ch = (Child) p; // 부모 타입 => 자식 타입으로.
			System.out.println("Ch = " + ch); //=> 위의 p와 ch의 주소값은 동일
			System.out.println(ch.c);
			ch.cc();
		}

		
	}

}
