package com.btg.work.model;

import java.sql.*;
import java.util.*;

import com.btg.work.ConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	//@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from employees");
		
		List<Employee> list = new ArrayList<Employee>() ;
		while(rs.next()) {
			Employee e= new Employee(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(e);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}	
	
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
}