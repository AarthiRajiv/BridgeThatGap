package com.btg.work.model;

import java.sql.*;
import java.util.*;

import com.btg.work.ConnectionUtility;

public class ConsultationDAO { //postgres dialect
	
	public List<Consultation> getAllConsultations() throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select e.emp_id, e.name, e.role, e.specialization, e.email, "
				+ "cl.client_id, cl.client_name, cl.contact_name, cl.contact_phone, cl.contact_email, "
				+ "i.interv_id, i.option, c.consult_id, c.goal, c.start_date, c.end_date, c.status, c.comment "
				+ "from employees e, clients cl, interventions i, consultations c "
				+ "where e.emp_id = c.emp_id AND cl.client_id = c.client_id AND i.interv_id = c.interv_id");
		
		List<Consultation> list = new ArrayList<Consultation>() ;
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			Client client = new Client(rs.getInt(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			Intervention interv = new Intervention(rs.getInt(11), rs.getString(12));	
			Consultation c = new Consultation(rs.getInt(13), client, interv, emp, rs.getString(14), rs.getDate(15), 
					rs.getDate(16), rs.getString(17), rs.getString(18));
			list.add(c);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}	
	
	public List<Consultation> addConsultation(Consultation c) throws SQLException {		
		Connection conn = ConnectionUtility.getConnection();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO consultations (client_id, emp_id, interv_id, start_date, goal, status, comment) "
				+ "VALUES(?,?,?,?,?,?,?)");		
		ps.setInt(1, c.getClient().getClientId());
		ps.setInt(2, c.getEmployee().getEmpId());
		ps.setInt(3, c.getIntervention().getInterventionId());		
		ps.setDate(4, c.getStartDate());
		ps.setString(5, c.getGoal());
		ps.setString(6, c.getStatus());
		ps.setString(7, c.getComment());
		ps.executeUpdate();
		
		return (getAllConsultations()); // send new list from db
	}	
}