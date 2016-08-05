package com.ob.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Clientsubmitinfo entity. @author MyEclipse Persistence Tools
 */

public class ClientsubmitinfoDate implements java.io.Serializable {

	// Fields

	private String infoId;
	private Integer infoType;
	private String infoContent;
	private Integer clientId;
	private Date submitTime;

	// Constructors

	/** default constructor */
	public ClientsubmitinfoDate() {
	}

	/** full constructor */
	public ClientsubmitinfoDate(Integer infoType, String infoContent,
			Integer clientId, Date submitTime) {
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

	public Date getSubmitTime() {
		//System.out.println(" ±º‰ «£∫"+this.submitTime.toLocalDateTime().toString());
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

}