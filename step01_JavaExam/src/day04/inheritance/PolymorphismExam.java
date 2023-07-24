package day04.inheritance;
class CarCenter{
	// polymorphism을 사용하지 않으면 Car cd, EfSonata, Carnival 등의 변수로 오버로딩을 해주어야함.
	// 그럼 더 복잡해짐.
	public void engineer(Car cd){
		System.out.println("cd주소 = " + cd);
		
		//ObjectDownCasting 필요 => Car cd를 변수로 받는데 Excel은 Car의 자식임.
		//=> 자식의 변수를 사용할 수 없음.
		// 때문에 ObjectDownCasting을 사용해서 Excel의 값으로 가져와줌.
		// 형변환과 같은 느낌.
		
		// 하지만 engineer 매서드는 Car을 변수로 받기 때문에 Excel이 아닌 다른 클래스가 들어오면
		// 에러가 발생함
		if (cd instanceof Excel) { // cd가 excel 타입일 때만 실행
			Excel e = (Excel) cd;
			System.out.println("e의 주소 = " + e);
			System.out.println("색상 = " + e.color);			
		}
		
		System.out.print(cd.carname+" 수리완료!\t");
		System.out.println("청구비용"+cd.cost+" 원");
		
	}
}

public class PolymorphismExam{
	public static void main(String[] args) {
		
		CarCenter cc=new CarCenter();
		
		EfSonata ef=new EfSonata();
		Carnival ca=new Carnival();
		Excel ex=new Excel();	
		Car c= new Car();
		
		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		
		System.out.println("ex 주소 = " + ex);
		System.out.println("ex.color = " + ex.color);

		cc.engineer(ex);
		
	
	}
}
