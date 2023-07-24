package day05.abstract_final;

/**
 * 상속의 이유 : 공통의 속성, 메소드를 부모쪽에 정의해두고 extends 키워드로 재사용, 확장에 좋게 만듬.
 *
 */
abstract class Animal{ // 상속해서 사용
	
	// 공통의 속성
	int legs;
	
	// 공통의 메소드
	public void eat() {
		System.out.println("고기를 좋아한다.");
	}
	public abstract void sound(); // 재정의를 위한 메소드
	
	public abstract void run(); // abstract 클래스를 상속받는 자식들은 반드시 abstract를 오버라이딩 해주어야 함.
}

////////////////////////////////
class Pig extends Animal{
	@Override
	public void sound() {
		System.out.println("꿀꿀....");
	}
	
	public void run() {
		System.out.println("잘 달림");
	}
}

class Cat extends Animal{
	@Override
	public void sound() {
		System.out.println("야옹~~");
	}

	@Override
	public void run() {
		System.out.println("잘 안달림");
	}
}
////////////////////////////////

public class AbstractSample {

	public static void main(String[] args) {
		Animal an = new Pig();
		System.out.println("----Pig----");
		test(new Pig());
		System.out.println("----Cat----");
		test(new Cat());
	}
	// Cat, Pig, Dog...
	public static void test(Animal an) { // 매개변수를 이용한 다형성
		an.eat();
		an.sound(); // 재정의가 되었기 때문에 재정의된 메소드를 콜함.
		an.run();
	}
}
