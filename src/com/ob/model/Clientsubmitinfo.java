package com.ob.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Clientsubmitinfo entity. @author MyEclipse Persistence Tools
 */

public class Clientsubmitinfo implements java.io.Serializable {

	// Fields

	private String infoId;
	private Integer infoType;
	private String infoContent;
	private Integer clientId;
	private String submitTime;

	// Constructors

	/** default constructor */
	public Clientsubmitinfo() {
	}

	/** full constructor */
	public Clientsubmitinfo(Integer infoType, String infoContent,
			Integer clientId, String submitTime) {
		this.infoType = infoType;
		this.infoContent = infoContent;
		this.clientId = clientId;
		this.submitTime = submitTime;
	}

	// Property accessors

	public String getInfoId() {
		return this.infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public Integer getInfoType() {
		return this.infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	public String getInfoContent() {
		return this.infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getSubmitTime() {
		//System.out.println(" ±º‰ «£∫"+this.submitTime.toLocalDateTime().toString());
		return this.submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

}