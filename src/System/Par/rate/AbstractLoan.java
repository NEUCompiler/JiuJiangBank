package System.Par.rate;

/**
 * AbstractLoan entity provides the base persistence definition of the Loan
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLoan implements java.io.Serializable {

	// Fields

	private String loankey;
	public String getLoankey() {
		return loankey;
	}

	public void setLoankey(String loankey) {
		this.loankey = loankey;
	}

	private String type;
	private Integer time;
	private Float rate;

	// Constructors

	/** default constructor */
	public AbstractLoan() {
	}

	/** minimal constructor */
	public AbstractLoan(String loankey) {
		this.loankey = loankey;
	}

	/** full constructor */
	public AbstractLoan(String key, String type, Integer time, Float rate) {
		this.loankey = loankey;
		this.type = type;
		this.time = time;
		this.rate = rate;
	}

	// Property accessors



	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

}