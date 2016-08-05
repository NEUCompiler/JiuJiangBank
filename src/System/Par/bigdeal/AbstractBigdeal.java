package System.Par.bigdeal;

/**
 * AbstractBigdeal entity provides the base persistence definition of the
 * Bigdeal entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBigdeal implements java.io.Serializable {

	// Fields

	private Integer bigdealId;
	private Integer amount;
	private Integer aheadtime;

	// Constructors

	/** default constructor */
	public AbstractBigdeal() {
	}

	/** full constructor */
	public AbstractBigdeal(Integer amount, Integer aheadtime) {
		this.amount = amount;
		this.aheadtime = aheadtime;
	}

	// Property accessors

	public Integer getBigdealId() {
		return this.bigdealId;
	}

	public void setBigdealId(Integer bigdealId) {
		this.bigdealId = bigdealId;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getAheadtime() {
		return this.aheadtime;
	}

	public void setAheadtime(Integer aheadtime) {
		this.aheadtime = aheadtime;
	}

}