package com.btg.work;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {
	
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
}