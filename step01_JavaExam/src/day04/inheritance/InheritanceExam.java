package day04.inheritance;

class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당

// 같은 부모를 상속 받았다는 것이 부모를 공유하는 것이 아닌 각각으로 생성되는 것.
// 부모의 변수 가져올 때 super, this, 생략 모두 가능
class EfSonata extends Car {
	
	public EfSonata() {
		this.carname = "efsonata";
		cost = 20_000_000;
	}
}

class Excel extends Car {
	String color = "blue";
	public Excel() {
		super.carname ="excel";
		this.cost = 30_000_000;
	}
}

class Carnival extends Car {
	
	public Carnival() {
		this.carname = "carnival";
		this.cost = 45_000_000;
	}
}

	

public class InheritanceExam{
	//메인메소드에서 
		//Car, EfSonata, Excel, Canival 네개의 객체를 생성
		// 각 클래스에서 Car class에있는 printAttributes()메소드를 호출할수있다.
	public static void main(String[] args) {
		EfSonata sonata = new EfSonata();
		Excel excel = new Excel();
		Carnival carnival = new Carnival();
		Car car = new Car();
		System.out.println("-----------------------");
		
		System.out.println("car = " + car);
		System.out.println("sonata = " + sonata);
		System.out.println("excel = " + excel);
		System.out.println("carnival = " + carnival);
		System.out.println("===========================");
		sonata.printAttributes();
		excel.printAttributes();
		carnival.printAttributes();
		car.printAttributes();
	}
}

