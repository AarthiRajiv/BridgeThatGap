package com.btg.work.model;

import java.sql.*;
import java.util.*;

import com.btg.work.ConnectionUtility;

public class ClientDAO {	//postgres dialect
	
	public List<Client> getAllClients() throws SQLException {
		Connection conn = ConnectionUtility.getConnection();		
		PreparedStatement ps = conn.prepareStatement("SELECT * from clients");
		ResultSet rs = ps.executeQuery();		
		
		List<Client> list = new ArrayList<Client>() ;
		while(rs.next()) {
			Client c = new Client (rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			list.add(c);				
		}
		ConnectionUtility.closeConnection();
		return list;		
	}
}