//package com;
//
//public class FullTime {
//	private int empNo;
//	private String eName;
//	private String job;
//	private int mgr;
//	private String hireDate;
//	private String deptName;
//	private int salary;
//	private int bonus;
//	
//	public FullTime() {
//		
//	}
//	
//	public FullTime(int empNo, String eName, String job, int mgr, String hireDate, String deptName, int salary, int bonus) {
//		setEmpNo(empNo);
//		seteName(eName);
//		setJob(job);
//		setMgr(mgr);
//		setHireDate(hireDate);
//		setDeptName(deptName);
//		setSalary(salary);
//		setBonus(bonus);
//		System.out.println(toString());
//	}
//
//	public int getEmpNo() {
//		return empNo;
//	}
//
//	public void setEmpNo(int empNo) {
//		this.empNo = empNo;
//	}
//
//	public String geteName() {
//		return eName;
//	}
//
//	public void seteName(String eName) {
//		this.eName = eName;
//	}
//
//	public String getJob() {
//		return job;
//	}
//
//	public void setJob(String job) {
//		this.job = job;
//	}
//
//	public int getMgr() {
//		return mgr;
//	}
//
//	public void setMgr(int mgr) {
//		this.mgr = mgr;
//	}
//
//	public String getHireDate() {
//		return hireDate;
//	}
//
//	public void setHireDate(String hireDate) {
//		this.hireDate = hireDate;
//	}
//
//	public String getDeptName() {
//		return deptName;
//	}
//
//	public void setDeptName(String depName) {
//		this.deptName = depName;
//	}
//
//	public int getSalary() {
//		return salary;
//	}
//
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//
//	public int getBonus() {
//		return bonus;
//	}
//
//	public void setBonus(int bonus) {
//		this.bonus = bonus;
//	}
//	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("FullTime [empNo=");
//		builder.append(empNo);
//		builder.append(", eName=");
//		builder.append(eName);
//		builder.append(", job=");
//		builder.append(job);
//		builder.append(", mgr=");
//		builder.append(mgr);
//		builder.append(", hireDate=");
//		builder.append(hireDate);
//		builder.append(", deptName=");
//		builder.append(deptName);
//		builder.append(", salary=");
//		builder.append(salary);
//		builder.append(", bonus=");
//		builder.append(bonus);
//		builder.append("]");
//		return builder.toString();
//	}
//}
