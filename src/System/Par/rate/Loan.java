package System.Par.rate;

/**
 * Loan entity. @author MyEclipse Persistence Tools
 */
public class Loan extends AbstractLoan implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Loan() {
	}

	/** minimal constructor */
	public Loan(String loankey) {
		super(loankey);
	}

	/** full constructor */
	public Loan(String loankey, String type, Integer time, Float rate) {
		super(loankey, type, time, rate);
	}

}
