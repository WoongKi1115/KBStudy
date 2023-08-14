package test.exam;

public class Audio extends Elec implements ElecFunction{
	private int volumn;
	
	public Audio() {
		
	};
	
	public Audio(int volumn) {
		
	};
	
	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn = volumn;
	}

	@Override
	public void start() {
		System.out.println(getCode() + "제품 " + getClass().getSimpleName() + "를 " + volumn + "을 본다.");

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
		builder.append(volumn);
		builder.append("]");
		return builder.toString();
	}

	
}
