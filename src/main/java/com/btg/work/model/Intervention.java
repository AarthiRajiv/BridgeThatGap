package com.btg.work.model;
import java.io.Serializable;

public class Intervention implements Serializable {
	private Integer interventionId;
	private String option;

	public Intervention(Integer interventionId) {
		super();
		this.interventionId = interventionId;
	}
	public Intervention (Integer interventionId, String option) {
		super();
		this.interventionId = interventionId;
		this.option = option;
	}
	
	public Integer getInterventionId() {
		return interventionId;
	}
	public void setInterventionId(Integer interventionId) {
		this.interventionId = interventionId;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
}
