package com.btg.work.model;

public class Employee {
	private Integer empId;
	private String name;
	private String role;
	private String specialization;
	private String email;
	private String password; // keep??
	
	public Employee (Integer empId, String name, String role, String specialization, String email) {
		super();
		this.empId = empId;
		this.name = name;
		this.role = role;
		this.specialization = specialization;
		this.email = email;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	/*public void setPassword(String password) {
		this.password = password;
	}*/
}