package com.btg.work;

import java.sql.SQLException;
import java.util.*;
import com.btg.work.model.*;

public class Main {
	
	public static void main(String args[]) throws SQLException {		
		EmployeeDAO eDAO = new EmployeeDAOImpl();
		List<Employee> employeeList = eDAO.getAllEmployees();
		for(Employee e : employeeList) {
			System.out.println("## "+e.getName());
		}
		
		ConsultationDAO consultationDAO = new ConsultationDAOImpl();
		List<Consultation> consultationList = consultationDAO.getAllConsultations();
		System.out.println("Just before Consults for loop");
		for(Consultation c : consultationList) {								
			System.out.println("Consultation ID : " + c.getConsultationId());
		}		
			
	}
}
