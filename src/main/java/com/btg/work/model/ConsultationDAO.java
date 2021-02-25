package com.btg.work.model;

import java.sql.SQLException;
import java.util.List;

public interface ConsultationDAO {
	public List<Consultation> getAllConsultations() throws SQLException;
}
