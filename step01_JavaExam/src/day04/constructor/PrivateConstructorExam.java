package day04.constructor;

/**
 * 싱글톤 클래스 작성방법
 * 1. private 생성자를 만듬
 * 2. 맴버필드로 static 자기자신 타입 선언
 * 3. public static을 제공하여 객체를 사용할 수 있도록 함.
 */
class Test {
	private static Test instance = new Test();
	// 외부에서 객체 생성 직접 못함
	private Test() {}
	
	/**
	 * 자기자신 객체를 직접 생성해서 리턴해주는 메소드를 제공
	 * static이 없으면 객체를 생성 못해서 이 메서드를 가져올 수 없음.
	 * 때문에 static을 붙여주어 메서드를 바로 쓸 수 있게 만듬.
	 */
	public static Test getInstance() {	
		return instance;
	}
	
}

/////////////////////////////////////////
public class PrivateConstructorExam {
	public static void main(String[] args) {
		// 이렇게 하면 객체를 3번 생성하므로 3개의 객체가 다른 주소값을 가짐.
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		Test t3 = Test.getInstance();
		
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		// 여기까지 
	}
}
