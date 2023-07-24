package day04.encapsulation;

/**
 * 학생의 정보 = 속성을 관리하는 객체
 * : VO(Value Object), DTO (Date Transfer Object), Domain
 * 
 * : 맴버필드를 외부에서 직접 접근할 수 없도록 private 선언
 *   setter, getter을 제공하여, 메소드를 이용하여 접근하도록 함.
 */


public class Student {
	private String name;
	private int age;
	private String addr;
	
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


	/**
	 * setter, getter 추가
	 * 단축키가 제공되어 있음.
	 */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		if (age > 18)
			this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
