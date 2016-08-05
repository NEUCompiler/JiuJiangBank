package com.ob.model;

/**
 * Companyclient entity. @author MyEclipse Persistence Tools
 */

public class Companyclient implements java.io.Serializable {

	// Fields

	private Integer clientid;
	private String username;
	private String userpassword;
	private String adddealpassword;
	private String phone;

	// Constructors

	/** default constructor */
	public Companyclient() {
	}

	/** minimal constructor */
	public Companyclient(Integer clientid, String username,
			String userpassword, String adddealpassword) {
		this.clientid = clientid;
		this.username = username;
		this.userpassword = userpassword;
		this.adddealpassword = adddealpassword;
	}

	/** full constructor */
	public Companyclient(Integer clientid, String username,
			String userpassword, String adddealpassword, String phone) {
		this.clientid = clientid;
		this.username = username;
		this.userpassword = userpassword;
		this.adddealpassword = adddealpassword;
		this.phone = phone;
	}

	// Property accessors

	public Integer getClientid() {
		return this.clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getAdddealpassword() {
		return this.adddealpassword;
	}

	public void setAdddealpassword(String adddealpassword) {
		this.adddealpassword = adddealpassword;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Companyclient [clientid=" + clientid + ", username=" + username
				+ ", userpassword=" + userpassword + ", adddealpassword="
				+ adddealpassword + ", phone=" + phone + "]";
	}

	
	
}