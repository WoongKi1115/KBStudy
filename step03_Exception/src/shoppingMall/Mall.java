package shoppingMall;

import java.io.IOException;

public class Mall {
	int age;
	
	public void getAge(int age) throws ChildException{
		try {
			if (age < 18) {
				ChildException e = new ChildException("애들은 가라");
				throw e;
			}
			System.out.println(age);
			System.out.println("입장하신걸 환영합니다.");
		} finally {
			
		}
	}
}
