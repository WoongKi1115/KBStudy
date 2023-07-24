package sample02;

public class PartTime extends Employee{
	private int timePay;
	
	public PartTime() {
		
	}
	
	public PartTime(int empNo, String eName, String job,
			int mgr, String hireDate, String deptName, int timePay) {
		super(empNo, eName, job, mgr, hireDate, deptName);

		setTimePay(timePay);
//		System.out.println(toString());
	}


	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	@Override
	public String toString() {
		return super.toString() +  " | " + timePay;
	}
	
	@Override
	public void message() {
		System.out.println(geteName() + "은 비정규직입니다.");
	}
}
