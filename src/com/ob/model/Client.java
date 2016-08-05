package com.ob.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Client entity. @author MyEclipse Persistence Tools
 */

public class Client implements java.io.Serializable {

	// Fields

	private Integer clientId;
	private String identityId;
	private String trueName;
	private Integer sex;
	private String phone;
	private String mail;
	private String accountType;
	private String userName;
	private String userPassword;
	private Set clientaccounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Client() {
	}

	/** minimal constructor */
	public Client(String identityId, String trueName, Integer sex, String mail,
			String accountType, String userName, String userPassword) {
		this.identityId = identityId;
		this.trueName = trueName;
		this.sex = sex;
		this.mail = mail;
		this.accountType = accountType;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public Client(String identityId, String trueName, Integer sex,
			String phone, String mail, String accountType, String userName,
			String userPassword, Set clientaccounts) {
		this.identityId = identityId;
		this.trueName = trueName;
		this.sex = sex;
		this.phone = phone;
		this.mail = mail;
		this.accountType = accountType;
		this.userName = userName;
		this.userPassword = userPassword;
		this.clientaccounts = clientaccounts;
	}

	// Property accessors

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set getClientaccounts() {
		return this.clientaccounts;
	}

	public void setClientaccounts(Set clientaccounts) {
		this.clientaccounts = clientaccounts;
	}

}