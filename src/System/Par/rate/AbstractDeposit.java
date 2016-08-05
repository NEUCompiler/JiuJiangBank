package System.Par.rate;

/**
 * AbstractDeposit entity provides the base persistence definition of the
 * Deposit entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDeposit implements java.io.Serializable {

	// Fields

	private Integer depositkey;
	private Float rate;
	private Float interest;
	private Integer time;
	private Integer sign;

	// Constructors

	/** default constructor */
	public AbstractDeposit() {
	}

	/** minimal constructor */
	public AbstractDeposit(Integer depositkey) {
		this.depositkey = depositkey;
	}

	/** full constructor */
	public AbstractDeposit(Integer depositkey, Float rate, Float interest,
			Integer time, Integer sign) {
		this.depositkey = depositkey;
		this.rate = rate;
		this.interest = interest;
		this.time = time;
		this.sign = sign;
	}

	// Property accessors

	public Integer getDepositkey() {
		return depositkey;
	}

	public void setDepositkey(Integer depositkey) {
		this.depositkey = depositkey;
	}



	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getInterest() {
		return this.interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getSign() {
		return this.sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

}