package Operater.db;

import java.util.Date;

/**
 * AbstractOperater entity provides the base persistence definition of the
 * Operater entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOperater implements java.io.Serializable {

	// Fields

	private Integer operaterId;
	private String operaterName;
	private String operaterPassW;
	private String operaterType;
	private String operaterSex;
	private Date operaterBirthday;

	// Constructors

	/** default constructor */
	public AbstractOperater() {
	}

	/** minimal constructor */
	public AbstractOperater(String operaterName, String operaterPassW) {
		this.operaterName = operaterName;
		this.operaterPassW = operaterPassW;
	}

	/** full constructor */
	public AbstractOperater(String operaterName, String operaterPassW,
			String operaterType, String operaterSex, Date operaterBirthday) {
		this.operaterName = operaterName;
		this.operaterPassW = operaterPassW;
		this.operaterType = operaterType;
		this.operaterSex = operaterSex;
		this.operaterBirthday = operaterBirthday;
	}

	// Property accessors

	public Integer getOperaterId() {
		return this.operaterId;
	}

	public void setOperaterId(Integer operaterId) {
		this.operaterId = operaterId;
	}

	public String getOperaterName() {
		return this.operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public String getOperaterPassW() {
		return this.operaterPassW;
	}

	public void setOperaterPassW(String operaterPassW) {
		this.operaterPassW = operaterPassW;
	}

	public String getOperaterType() {
		return this.operaterType;
	}

	public void setOperaterType(String operaterType) {
		this.operaterType = operaterType;
	}

	public String getOperaterSex() {
		return this.operaterSex;
	}

	public void setOperaterSex(String operaterSex) {
		this.operaterSex = operaterSex;
	}

	public Date getOperaterBirthday() {
		return this.operaterBirthday;
	}

	public void setOperaterBirthday(Date operaterBirthday) {
		this.operaterBirthday = operaterBirthday;
	}

}