package sample02;

abstract class Employee {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hireDate;
	private String deptName;
	
	public Employee() {
		
	}
	
	public Employee(int empNo, String eName, String job, int mgr, String hireDate, String deptName) {
		setEmpNo(empNo);
		seteName(eName);
		setJob(job);
		setMgr(mgr);
		setHireDate(hireDate);
		setDeptName(deptName);
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return empNo + " | " + eName + " | " + job + " | " + mgr + " | " + hireDate + " | " + deptName;
	}
	
	public abstract void message();
	
}
