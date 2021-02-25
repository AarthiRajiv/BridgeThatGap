package com.btg.work.model;

import java.sql.SQLException;
import java.util.List;

public interface InterventionDAO {
	public List<Intervention> getAllInterventions() throws SQLException;
}
