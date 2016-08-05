package com.manager;

/**
 * ManagerOperater entity. @author MyEclipse Persistence Tools
 */

public class ManagerOperater implements java.io.Serializable {

	// Fields

	private Integer managerId;
	private String managerPassW;
	private String managerName;
	private String managerType;
	private String managerSex;

	// Constructors

	/** default constructor */
	public ManagerOperater() {
	}

	/** full constructor */
	public ManagerOperater(String managerPassW, String managerName,
			String managerType, String managerSex) {
		this.managerPassW = managerPassW;
		this.managerName = managerName;
		this.managerType = managerType;
		this.managerSex = managerSex;
	}

	// Property accessors

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerPassW() {
		return this.managerPassW;
	}

	public void setManagerPassW(String managerPassW) {
		this.managerPassW = managerPassW;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerType() {
		return this.managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}

	public String getManagerSex() {
		return this.managerSex;
	}

	public void setManagerSex(String managerSex) {
		this.managerSex = managerSex;
	}

}