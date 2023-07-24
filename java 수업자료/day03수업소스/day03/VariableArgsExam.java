package day03;

class Test{
	public void aa(Object ... i ) {//배열
		System.out.println("i "  + i) ;
		System.out.println("i.length= "  + i.length) ;
		for(Object a : i) {
			System.out.printf("%s , ", a);
		}
		
		System.out.println("\n-------------------");
	}
	//The variable argument type String of the method bb must be the last parameter
	public void bb(String  s , int ... i) {
		
	}
}
////////////////////////////////////////////////
public class VariableArgsExam {
	public static void main(String[] args) {
		Test t = new Test();
		t.aa(2);
	
		t.aa();
		t.aa(2,3);
		t.aa(1,3,5,7,9);
		
		t.aa("dd");
		t.aa(2,3,"dd",true);

	}

}
