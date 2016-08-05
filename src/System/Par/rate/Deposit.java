package System.Par.rate;

/**
 * Deposit entity. @author MyEclipse Persistence Tools
 */
public class Deposit extends AbstractDeposit implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Deposit() {
	}

	/** minimal constructor */
	public Deposit(Integer depositkey) {
		super(depositkey);
	}

	/** full constructor */
	public Deposit(Integer depositkey, Float rate, Float interest, Integer time,
			Integer sign) {
		super(depositkey, rate, interest, time, sign);
	}

}
