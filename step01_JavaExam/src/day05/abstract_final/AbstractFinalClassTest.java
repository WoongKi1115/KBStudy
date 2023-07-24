package day05.abstract_final;
//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{//상속 불가, 생성 가능
 final int i = -999999;  // 값을 변경 x => 명시적 초기화, 생성자를 이용.
//  final int i;
 // 이렇게만 쓰면 사용 불가능. final 변수는 무조건 초기화를 시켜주어야 함. 값을 저장해주어야 함.
 // 만약 final int i; 를 쓰려면 아래의 함수도 추가해주어야함.
// FinalClassExam(int i) {
//	 this.i = i;
// }
}


abstract class AbstractClassExam{ // 상속 가능, 생성 불가
    abstract String abstractMethodExam(int i,String s);   // 기능이 없음. abstract 매서드가 있다면 class에도 abstract 붙여줌  
    final int finalMethodExam(int i, int j){ // final이므로 재정의 불가
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
//	int finalMethodExam(int i, int j){ // final이므로 재정의 불가
//		return i*j;
//	}
	
}

//class Sample02 extends FinalClassExam{  } // final 클래스는 상속 불가


 
abstract class Sample03 extends AbstractClassExam{
	String abstractMethodExam(int i,String s) {
		return s;
	};    

	abstract String abstractMethodExam(String s, int i); //abstract 매서드가 있으므로 class에 abstract 넣어줌
	
	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
//		AbstractClassExam ace = new AbstractClassExam(); abstract 클래스는 생성 불가
		FinalClassExam fce = new FinalClassExam();
//		fce.i=100000; // final 필드는 값 변경 불가.
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
