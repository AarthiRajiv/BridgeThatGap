package com.btg.work;

import java.sql.*;
import java.util.*;

public class InterventionDAO {
	
	public List<Intervention> getAllInterventions() throws SQLException {
		Connection conn = ConnectionUtility.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM interventions");
		
		List<Intervention> list = new ArrayList<Intervention>() ;
		while(rs.next()) {
			Intervention i = new Intervention (rs.getInt(1),rs.getString(2));
			list.add(i);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}	
} 