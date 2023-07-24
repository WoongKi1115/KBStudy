package day04.overriding;

class ObjectExam{
	String x;
	public ObjectExam(){   }
	public ObjectExam(String str){ 
		x = str;
	}
	
	@Override
	public String toString() {
		// 주소값을 보고 싶을 때는 super로 부모의 함수를 가져와서 사용하면 됨.
		
		return super.toString() + x;
	}
}
class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			ObjectExam oe1=new ObjectExam();
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//
			System.out.println(s01);//
			System.out.println(s02);//
			System.out.println(s03);//
			System.out.println(oe1.toString());
			System.out.println(oe2);//
			
			// Object에 정의되어있는 toString method는 주소값만을 호출해서 문자열로 보내줌
			// String은 Object의 toString을 overriding해서 실제 값을 보여주는 것.
			// 때문에 oe2.toString()을 해도 주소값을 보여주는 것임.
	}
}
