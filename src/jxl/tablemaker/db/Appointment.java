package jxl.tablemaker.db;

/**
 * Appointment entity. @author MyEclipse Persistence Tools
 */
public class Appointment extends AbstractAppointment implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Appointment() {
	}

	/** full constructor */
	public Appointment(AppointmentId id) {
		super(id);
	}

}
