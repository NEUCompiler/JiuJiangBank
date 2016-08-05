package com.neu.appointment;

import java.sql.Timestamp;

/**
 * AbstractAppointment entity provides the base persistence definition of the
 * Appointment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAppointment implements java.io.Serializable {

	// Fields

	private Integer clintid;
	private String amount;
	private Timestamp date;
	private String websiteid;

	// Constructors

	/** default constructor */
	public AbstractAppointment() {
	}

	/** minimal constructor */
	public AbstractAppointment(Integer clintid) {
		this.clintid = clintid;
	}

	/** full constructor */
	public AbstractAppointment(Integer clintid, String amount, Timestamp date,
			String websiteid) {
		this.clintid = clintid;
		this.amount = amount;
		this.date = date;
		this.websiteid = websiteid;
	}

	// Property accessors

	public Integer getClintid() {
		return this.clintid;
	}

	public void setClintid(Integer clintid) {
		this.clintid = clintid;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getWebsiteid() {
		return this.websiteid;
	}

	public void setWebsiteid(String websiteid) {
		this.websiteid = websiteid;
	}

}