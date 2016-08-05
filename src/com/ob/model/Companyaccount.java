package com.ob.model;

/**
 * Companyaccount entity. @author MyEclipse Persistence Tools
 */

public class Companyaccount implements java.io.Serializable {

	// Fields

	private String accountid;
	private Double amount;
	private Integer alimit;
	private Integer isloss;
	private Integer isopenob;
	private String searchpassword;
	private Integer dealpassword;
	private Integer clientid;
	private Integer term;

	// Constructors

	/** default constructor */
	public Companyaccount() {
	}

	/** full constructor */
	public Companyaccount(String accountid, Double amount, Integer alimit,
			Integer isloss, Integer isopenob, String searchpassword,
			Integer dealpassword, Integer clientid, Integer term) {
		this.accountid = accountid;
		this.amount = amount;
		this.alimit = alimit;
		this.isloss = isloss;
		this.isopenob = isopenob;
		this.searchpassword = searchpassword;
		this.dealpassword = dealpassword;
		this.clientid = clientid;
		this.term = term;
	}

	// Property accessors

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getAlimit() {
		return this.alimit;
	}

	public void setAlimit(Integer alimit) {
		this.alimit = alimit;
	}

	public Integer getIsloss() {
		return this.isloss;
	}

	public void setIsloss(Integer isloss) {
		this.isloss = isloss;
	}

	public Integer getIsopenob() {
		return this.isopenob;
	}

	public void setIsopenob(Integer isopenob) {
		this.isopenob = isopenob;
	}

	public String getSearchpassword() {
		return this.searchpassword;
	}

	public void setSearchpassword(String searchpassword) {
		this.searchpassword = searchpassword;
	}

	public Integer getDealpassword() {
		return this.dealpassword;
	}

	public void setDealpassword(Integer dealpassword) {
		this.dealpassword = dealpassword;
	}

	public Integer getClientid() {
		return this.clientid;
	}

	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}

	public Integer getTerm() {
		return this.term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "Companyaccount [accountid=" + accountid + ", amount=" + amount
				+ ", alimit=" + alimit + ", isloss=" + isloss + ", isopenob="
				+ isopenob + ", searchpassword=" + searchpassword
				+ ", dealpassword=" + dealpassword + ", clientid=" + clientid
				+ ", term=" + term + "]";
	}

	
	
}