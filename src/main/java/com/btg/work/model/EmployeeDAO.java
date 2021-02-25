package com.btg.work.model;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	public List<Employee> getAllEmployees() throws SQLException;
	public Employee verifyLogin(String email, String pwd) throws SQLException;
}
