package day02;

class Methodinvoke01{
	//다음과 같이 메소드를 작성하세요.
	
	/*method 이름 : method01
	어디서나 누구나 접근가능
	정수 리턴
	인수로 정수2개 받음
	인수로 들어온 정수 2개를 곱해서 출력하고 리턴*/
	public int method01(int x, int y) {
		
		return x * y;
	}
		
	
}

class Methodinvoke02{
	
	//method 이름 : method02
	//어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능
	//정수 리턴
	//인수로 정수2개 받음
	
	//인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴
	public static int method02(int x, int y) {
		return x + y;
	}
		
	

	
}

class MethodInvokeExam{
	public static void main(String []args){
		
		//MethodInvoke01의 method01 호출
		Methodinvoke01 a = new Methodinvoke01();
		int x = a.method01(3, 7);
		System.out.println("결과 : " + x);
		//MethodInvoke02의 method02 호출
		int result = Methodinvoke02.method02(4, 5);
		System.out.println("결과 : " + result);
	}
}

