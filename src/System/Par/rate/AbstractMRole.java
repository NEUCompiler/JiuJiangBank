package System.Par.rate;

/**
 * AbstractMRole entity provides the base persistence definition of the MRole
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String auId;
	private String roleExpl;

	// Constructors

	/** default constructor */
	public AbstractMRole() {
	}

	/** full constructor */
	public AbstractMRole(String roleName, String auId, String roleExpl) {
		this.roleName = roleName;
		this.auId = auId;
		this.roleExpl = roleExpl;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAuId() {
		return this.auId;
	}

	public void setAuId(String auId) {
		this.auId = auId;
	}

	public String getRoleExpl() {
		return this.roleExpl;
	}

	public void setRoleExpl(String roleExpl) {
		this.roleExpl = roleExpl;
	}

}