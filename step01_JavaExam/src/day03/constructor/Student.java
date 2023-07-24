package day03.constructor;

/**
 * 학생의 정보 = 속성을 관리하는 객체
 * : VO(Value Object), DTO (Date Transfer Object), Domain
 */


public class Student {
	String name;
	int age;
	String addr;
	
	// 생성자
	public Student() {};
	
	
	public Student(String name, int age, String addr) {
		// 아래의 생성자를 불러와서 사용.
		this(name, age);
		this.addr = addr;
	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " | " + age + " | " + addr;
	}
}
