package com.ob.model;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private String accountid;
	private Integer dealpassword;
	private Integer amount;
	private Integer term;
	private Integer isloss;
	private Integer cdlimit;
	private Integer integrate;
	private Integer isactive;
	private Integer isopenob;
	private Integer clientid;
	private Integer sign;
	private String identityid;
	private String othername;
	private String searchpassword;
	private Integer dealwithoutpassword;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(String accountid, Integer dealpassword, Integer amount,
			Integer isloss, Integer cdlimit, Integer isopenob,
			Integer clientid, Integer sign, String identityid,
			Integer dealwithoutpassword) {
		this.accountid = accountid;
		this.dealpassword = dealpassword;
		this.amount = amount;
		this.isloss = isloss;
		this.cdlimit = cdlimit;
		this.isopenob = isopenob;
		this.clientid = clientid;
		this.sign = sign;
		this.identityid = identityid;
		this.dealwithoutpassword = dealwithoutpassword;
	}

	/** full constructor */
	public Account(String accountid, Integer dealpassword, Integer amount,
			Integer term, Integer isloss, Integer cdlimit, Integer integrate,
			Integer isactive, Integer isopenob, Integer clientid, Integer sign,
			String identityid, String othername, String searchpassword,
			Integer dealwithoutpassword) {
		this.accountid = accountid;
		this.dealpassword = dealpassword;
		this.amount = amount;
		this.term = term;
		this.isloss = isloss;
		this.cdlimit = cdlimit;
		this.integrate = integrate;
		this.isactive = isactive;
		this.isopenob = isopenob;
		this.clientid = clientid;
		this.sign = sign;
		this.identityid = identityid;
		this.othername = othername;
		this.searchpassword = searchpassword;
		this.dealwithoutpassword = dealwithoutpassword;
	}

	// Property accessors

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Integer getDealpassword() {
		return this.dealpassword;
	}

	public void setDealpassword(Integer dealpassword) {
		this.dealpassword = dealpassword;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Integer getIsloss() {
		return this.isloss;
	}

	public void setIsloss(Integer isloss) {
		this.isloss = isloss;
	}

	public Integer getCdlimit() {
		return this.cdlimit;
	}

	public void setCdlimit(Integer cdlimit) {
		this.cdlimit = cdlimit;
	}

	public Integer getIntegrate() {
		return this.integrate;
	}

	public void setIntegrate(Integer integrate) {
		this.integrate = integrate;
	}

	public Integer getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public Integer getIsopenob() {
		return this.isopenob;
	}

	public void setIsopenob(Integer isopenob) {
		this.isopenob = isopenob;
	}

	public Integer getClientid() {
		return this.clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}

	public Integer getSign() {
		return this.sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public String getIdentityid() {
		return this.identityid;
	}

	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	public String getOthername() {
		return this.othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getSearchpassword() {
		return this.searchpassword;
	}

	public void setSearchpassword(String searchpassword) {
		this.searchpassword = searchpassword;
	}

	public Integer getDealwithoutpassword() {
		return this.dealwithoutpassword;
	}

	public void setDealwithoutpassword(Integer dealwithoutpassword) {
		this.dealwithoutpassword = dealwithoutpassword;
	}

}