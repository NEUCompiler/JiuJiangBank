package jxl.tablemaker.db;

import java.sql.Timestamp;

/**
 * AppointmentId entity. @author MyEclipse Persistence Tools
 */
public class AppointmentId extends AbstractAppointmentId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AppointmentId() {
	}

	/** minimal constructor */
	public AppointmentId(String appointid) {
		super(appointid);
	}

	/** full constructor */
	public AppointmentId(String appointid, String clientid, String amount,
			Timestamp date, String websiteid) {
		super(appointid, clientid, amount, date, websiteid);
	}

}
