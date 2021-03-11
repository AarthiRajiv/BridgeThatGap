package com.btg.work.model;

import java.sql.*;
import java.util.*;

import com.btg.work.ConnectionUtility;

public class EmployeeDAO {	//postgres dialect
		
	public List<Employee> getAllEmployees() throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT emp_id, name, role, specialization, email from employees");
		ResultSet rs = ps.executeQuery();
		
		List<Employee> list = new ArrayList<Employee>() ;
		while(rs.next()) {
			Employee e= new Employee(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(e);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}	
	
	// verify login by email and password 
	public Employee verifyLogin(String email, String pwd) throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM employees WHERE email=? AND password=?");
		ps.setString(1, email);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
			
		Employee e = null;
		if (rs.next()) { //on valid login, return Employee with all fields except password column
			e = new Employee(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} 			
		return e;		
	}
	
	
	// delete Employee and return updated Employee List
	public List<Employee> deleteEmployee(Employee e) throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM employees WHERE emp_id=?");
		ps.setInt(1, e.getEmpId());		
		ps.executeUpdate();
		
		return (getAllEmployees()); // send new list from db
	}
	
	
	// update Employee and return updated Employee List
	public List<Employee> updateEmployee(Employee e) throws SQLException {
		Connection conn = ConnectionUtility.getConnection();				
		PreparedStatement ps = conn.prepareStatement("UPDATE employees SET (name, role, specialization, email, password) = (?,?,?,?,?) "
				+ "WHERE emp_id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getRole());
		ps.setString(3, e.getSpecialization());
		ps.setString(4, e.getEmail());
		ps.setString(5, "password");  //default pwd upon any change to Employee
		ps.setInt(6, e.getEmpId());	
		
		ps.executeUpdate();
		
		return (getAllEmployees()); // send new list from  db
	}		
	
	public List<Employee> addEmployee(Employee e) throws SQLException {		
		//Boolean added = false;
		Connection conn = ConnectionUtility.getConnection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO employees (name, role, specialization, email, password) "
				+ "VALUES(?,?,?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getRole());
		ps.setString(3, e.getSpecialization());
		ps.setString(4, e.getEmail());
		ps.setString(5, "password");
		ps.executeUpdate();
		
		return (getAllEmployees()); // send new list from  db
	}	
}