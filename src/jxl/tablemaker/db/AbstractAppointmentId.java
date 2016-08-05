package jxl.tablemaker.db;

import java.sql.Timestamp;

/**
 * AbstractAppointmentId entity provides the base persistence definition of the
 * AppointmentId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAppointmentId implements java.io.Serializable {

	// Fields

	private String appointid;
	private String clientid;
	private String amount;
	private Timestamp date;
	private String websiteid;

	// Constructors

	/** default constructor */
	public AbstractAppointmentId() {
	}

	/** minimal constructor */
	public AbstractAppointmentId(String appointid) {
		this.appointid = appointid;
	}

	/** full constructor */
	public AbstractAppointmentId(String appointid, String clientid,
			String amount, Timestamp date, String websiteid) {
		this.appointid = appointid;
		this.clientid = clientid;
		this.amount = amount;
		this.date = date;
		this.websiteid = websiteid;
	}

	// Property accessors

	public String getAppointid() {
		return this.appointid;
	}

	public void setAppointid(String appointid) {
		this.appointid = appointid;
	}

	public String getClientid() {
		return this.clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractAppointmentId))
			return false;
		AbstractAppointmentId castOther = (AbstractAppointmentId) other;

		return ((this.getAppointid() == castOther.getAppointid()) || (this
				.getAppointid() != null && castOther.getAppointid() != null && this
				.getAppointid().equals(castOther.getAppointid())))
				&& ((this.getClientid() == castOther.getClientid()) || (this
						.getClientid() != null
						&& castOther.getClientid() != null && this
						.getClientid().equals(castOther.getClientid())))
				&& ((this.getAmount() == castOther.getAmount()) || (this
						.getAmount() != null && castOther.getAmount() != null && this
						.getAmount().equals(castOther.getAmount())))
				&& ((this.getDate() == castOther.getDate()) || (this.getDate() != null
						&& castOther.getDate() != null && this.getDate()
						.equals(castOther.getDate())))
				&& ((this.getWebsiteid() == castOther.getWebsiteid()) || (this
						.getWebsiteid() != null
						&& castOther.getWebsiteid() != null && this
						.getWebsiteid().equals(castOther.getWebsiteid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAppointid() == null ? 0 : this.getAppointid().hashCode());
		result = 37 * result
				+ (getClientid() == null ? 0 : this.getClientid().hashCode());
		result = 37 * result
				+ (getAmount() == null ? 0 : this.getAmount().hashCode());
		result = 37 * result
				+ (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result
				+ (getWebsiteid() == null ? 0 : this.getWebsiteid().hashCode());
		return result;
	}

}