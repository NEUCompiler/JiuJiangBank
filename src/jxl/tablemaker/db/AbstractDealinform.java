package jxl.tablemaker.db;

import java.util.Date;

/**
 * AbstractDealinform entity provides the base persistence definition of the
 * Dealinform entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDealinform implements java.io.Serializable {

	// Fields

	private String dealid;
	private String accountid;
	private Date dealtime;
	private String dealinform;
	private Integer dealtype;
	private String dealDesti;
	private Integer dealstate;
	private Integer deaamountl;

	// Constructors

	/** default constructor */
	public AbstractDealinform() {
	}

	/** full constructor */
	public AbstractDealinform(String dealid, String accountid, Date dealtime,
			String dealinform, Integer dealtype, String dealDesti,
			Integer dealstate, Integer deaamountl) {
		this.dealid = dealid;
		this.accountid = accountid;
		this.dealtime = dealtime;
		this.dealinform = dealinform;
		this.dealtype = dealtype;
		this.dealDesti = dealDesti;
		this.dealstate = dealstate;
		this.deaamountl = deaamountl;
	}

	// Property accessors

	public String getDealid() {
		return this.dealid;
	}

	public void setDealid(String dealid) {
		this.dealid = dealid;
	}

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Date getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	public String getDealinform() {
		return this.dealinform;
	}

	public void setDealinform(String dealinform) {
		this.dealinform = dealinform;
	}

	public Integer getDealtype() {
		return this.dealtype;
	}

	public void setDealtype(Integer dealtype) {
		this.dealtype = dealtype;
	}

	public String getDealDesti() {
		return this.dealDesti;
	}

	public void setDealDesti(String dealDesti) {
		this.dealDesti = dealDesti;
	}

	public Integer getDealstate() {
		return this.dealstate;
	}

	public void setDealstate(Integer dealstate) {
		this.dealstate = dealstate;
	}

	public Integer getDeaamountl() {
		return this.deaamountl;
	}

	public void setDeaamountl(Integer deaamountl) {
		this.deaamountl = deaamountl;
	}

}