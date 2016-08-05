package Operater.db;

import java.util.Date;

/**
 * Operater entity. @author MyEclipse Persistence Tools
 */
public class Operater extends AbstractOperater implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Operater() {
	}

	/** minimal constructor */
	public Operater(String operaterName, String operaterPassW) {
		super(operaterName, operaterPassW);
	}

	/** full constructor */
	public Operater(String operaterName, String operaterPassW,
			String operaterType, String operaterSex,Date operaterBirthday) {
		super(operaterName, operaterPassW, operaterType, operaterSex,operaterBirthday);
	}

}
