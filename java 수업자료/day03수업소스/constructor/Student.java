package day03.constructor;

/**
 * 학생의정보=속성를 관리하는 객체 
 *   : VO(Value Object) , DTO(Data Transfer Object ) , Domain 
 * */
public class Student {
   String name;
   int age;
   String addr;
   
   public Student() {}
   
   //생성자
   public Student(String name, int age, String addr) {
	   //Constructor call must be the first statement in a constructor
	   this(name, age);//인수2개받는 생성자호출
	   this.addr=addr;
   }
   
   public Student(String name, int age) {
	   this.name=name;
	   this.age=age;
   }
}






