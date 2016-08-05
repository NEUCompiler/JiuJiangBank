package com.neu.deposit;

/**
 * AbstractDeposit entity provides the base persistence definition of the
 * Deposit entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDeposit implements java.io.Serializable {

	// Fields

	private Integer key;
	private Float rate;
	private Float interest;
	private Integer time;
	private Integer sign;

	// Constructors

	/** default constructor */
	public AbstractDeposit() {
	}

	/** minimal constructor */
	public AbstractDeposit(Integer key) {
		this.key = key;
	}

	/** full constructor */
	public AbstractDeposit(Integer key, Float rate, Float interest,
			Integer time, Integer sign) {
		this.key = key;
		this.rate = rate;
		this.interest = interest;
		this.time = time;
		this.sign = sign;
	}

	// Property accessors

	public Integer getKey() {
		return this.key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getInterest() {
		return this.interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getSign() {
		return this.sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

}