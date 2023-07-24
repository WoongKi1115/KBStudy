package sample02;

public class FullTime extends Employee{
	private int salary;
	private int bonus;
	
	public FullTime() {
		
	}
	
	public FullTime(int empNo, String eName, String job, int mgr, String hireDate,
			String deptName, int salary, int bonus) {
		super(empNo, eName, job, mgr, hireDate, deptName);
		setSalary(salary);
		setBonus(bonus);
//		System.out.println(toString());
	}

	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + salary + " | " + bonus;
	}
	
	@Override
	public void message() {
		System.out.println(geteName() + "은 정규직입니다.");
	}
}
