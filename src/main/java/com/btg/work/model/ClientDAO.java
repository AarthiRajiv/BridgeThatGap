package com.btg.work.model;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
	public List<Client> getAllClients() throws SQLException;
}
