package System.Par.bigdeal;

/**
 * Bigdeal entity. @author MyEclipse Persistence Tools
 */
public class Bigdeal extends AbstractBigdeal implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Bigdeal() {
	}

	/** full constructor */
	public Bigdeal(Integer amount, Integer aheadtime) {
		super(amount, aheadtime);
	}

}
