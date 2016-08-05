package jxl.tablemaker.db;

import java.sql.Timestamp;

/**
 * AbstractAppointment entity provides the base persistence definition of the
 * Appointment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAppointment implements java.io.Serializable {

	// Fields

	private AppointmentId id;
	private String appointid;
	public String getAppointid() {
		return appointid;
	}

	public void setAppointid(String appointid) {
		this.appointid = appointid;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getWebsiteid() {
		return websiteid;
	}

	public void setWebsiteid(String websiteid) {
		this.websiteid = websiteid;
	}

	private String clientid;
	private String amount;
	private Timestamp date;
	private String websiteid;

	// Constructors

	/** default constructor */
	public AbstractAppointment() {
	}

	/** full constructor */
	public AbstractAppointment(AppointmentId id) {
		this.id = id;
	}

	// Property accessors

	public AppointmentId getId() {
		return this.id;
	}

	public void setId(AppointmentId id) {
		this.id = id;
	}

}