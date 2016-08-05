package System.Par.rate;

/**
 * MAu entity. @author MyEclipse Persistence Tools
 */
public class MAu extends AbstractMAu implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MAu() {
	}

	/** full constructor */
	public MAu(String auName, String auPath, Integer parentauId, String state) {
		super(auName, auPath, parentauId, state);
	}

}
