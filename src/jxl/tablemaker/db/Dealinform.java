package jxl.tablemaker.db;

import java.util.Date;

/**
 * Dealinform entity. @author MyEclipse Persistence Tools
 */
public class Dealinform extends AbstractDealinform implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Dealinform() {
	}

	/** full constructor */
	public Dealinform(String dealid, String accountid, Date dealtime,
			String dealinform, Integer dealtype, String dealDesti,
			Integer dealstate, Integer deaamountl) {
		super(dealid, accountid, dealtime, dealinform, dealtype, dealDesti,
				dealstate, deaamountl);
	}

}
