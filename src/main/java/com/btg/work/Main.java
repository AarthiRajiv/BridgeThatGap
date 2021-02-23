package com.btg.work;

import java.sql.SQLException;
import java.util.*;

import com.btg.work.model.Consultation;
import com.btg.work.model.ConsultationDAO;
import com.btg.work.model.Employee;
import com.btg.work.model.EmployeeDAO;

public class Main {
	
	public static void main(String args[]) throws SQLException {		
		EmployeeDAO eDAO = new EmployeeDAO();
		List<Employee> employeeList = eDAO.getAllEmployees();
		for(Employee e : employeeList) {
			System.out.println("## "+e.getName());
		}
		//
		ConsultationDAO consultationDAO = new ConsultationDAO();
		List<Consultation> consultationList = consultationDAO.getAllConsultations();
		System.out.println("Just before Consults for loop");
		for(Consultation c : consultationList) {								
			System.out.println("Consultation ID : " + c.getConsultationId());
		}		
			
	}
}
