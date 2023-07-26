package test.exam;

public class Tv extends Elec implements ElecFunction{
	private int chnnel;
	
	public Tv() {
		
	};
	
	public Tv(int chnnel) {
		
	};
	
	public Tv(String code, int cost, int chnnel) {
		setCode(code);
		setCost(cost);
		this.chnnel = chnnel;
		
	}

	@Override
	public void start() {
		System.out.println(getCode() + "제품 " + getClass().getSimpleName() + "를 " + chnnel + "을 본다.");
//		System.out.println(toString());
	}

	@Override
	public void stop() {
		
		
	}

	@Override
	public void display() {
		
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		// getSimpleName : 현재 클래스의 이름.
		builder.append(super.getClass().getSimpleName());
		builder.append("[");
		super.toString();
		builder.append(chnnel);
		builder.append("]");
		return builder.toString();
	}
}
