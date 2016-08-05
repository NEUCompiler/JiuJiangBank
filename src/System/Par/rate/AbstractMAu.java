package System.Par.rate;

/**
 * AbstractMAu entity provides the base persistence definition of the MAu
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMAu implements java.io.Serializable {

	// Fields

	private Integer auId;
	private String auName;
	private String auPath;
	private Integer parentauId;
	private String state;

	// Constructors

	/** default constructor */
	public AbstractMAu() {
	}

	/** full constructor */
	public AbstractMAu(String auName, String auPath, Integer parentauId,
			String state) {
		this.auName = auName;
		this.auPath = auPath;
		this.parentauId = parentauId;
		this.state = state;
	}

	// Property accessors

	public Integer getAuId() {
		return this.auId;
	}

	public void setAuId(Integer auId) {
		this.auId = auId;
	}

	public String getAuName() {
		return this.auName;
	}

	public void setAuName(String auName) {
		this.auName = auName;
	}

	public String getAuPath() {
		return this.auPath;
	}

	public void setAuPath(String auPath) {
		this.auPath = auPath;
	}

	public Integer getParentauId() {
		return this.parentauId;
	}

	public void setParentauId(Integer parentauId) {
		this.parentauId = parentauId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}