package shoppingMall;

public class Test {
	public static void main(String[] args) {
		Mall m = new Mall();
		int result = 0;
		for (int i = 0; i<10; i++) {
			int ran = (int) (Math.random() * 55) + 1;
			try {
				m.getAge(ran);			
			} catch(Exception e) {
				System.out.println(e.getMessage());
				result++;
			}
		}
		System.out.println(result);
	}
}
