package sample02;
class Hi{
	public void hi() {
		System.out.println("안녕");
	}
	
	public Hi() {
		this.hi();
	}
}


public class Test {
	public static void main(String[] args) {
		Hi h = new Hi();
		h.hi();
	}
	
}
