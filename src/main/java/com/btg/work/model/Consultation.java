package com.btg.work.model;
import java.io.Serializable;
import java.util.Date;

public class Consultation implements Serializable {
	private Integer consultationId;
	private Client client;	
	private Intervention intervention;
	private Employee employee;
	private Date startDate;
	private Date endDate;
	private String status;
	private String comment;
	
	public Consultation(Integer consultationId, Client client, Intervention intervention, Employee employee,
			Date startDate, Date endDate, String status, String comment) {
		super();
		this.consultationId = consultationId;
		this.client = client;
		this.intervention = intervention;
		this.employee = employee;		
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.comment = comment;
	}
	
	public Integer getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(Integer consultationId) {
		this.consultationId = consultationId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Intervention getIntervention() {
		return intervention;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}	
}
