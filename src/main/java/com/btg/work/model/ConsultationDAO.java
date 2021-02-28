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
				+ "i.interv_id, i.option, c.consult_id, c.start_date, c.end_date, c.status, c.comments "
				+ "from employees e, clients cl, interventions i, consultations c "
				+ "where e.emp_id = c.emp_id AND cl.client_id = c.client_id AND i.interv_id = c.interv_id");
		
		List<Consultation> list = new ArrayList<Consultation>() ;
		while(rs.next()) {
			Employee emp = new Employee(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			Client client = new Client(rs.getInt(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			Intervention interv = new Intervention(rs.getInt(11), rs.getString(12));	
			Consultation c = new Consultation(rs.getInt(13), client, interv, emp, rs.getDate(14), rs.getDate(15), rs.getString(16), rs.getString(17));
			list.add(c);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}	
}