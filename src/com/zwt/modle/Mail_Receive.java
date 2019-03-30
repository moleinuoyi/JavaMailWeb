package com.zwt.modle;

import java.sql.Date;

public class Mail_Receive {
	private Integer id;
	private String mailTitle;
	private String mailContent;
	private String nature;
	private Integer isStar;
	private int status;
	private int local;
	private String sendPeople;
	private String receivePeople;
	private Date dateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Integer getIsStar() {
		return isStar;
	}

	public void setIsStar(Integer isStar) {
		this.isStar = isStar;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	public String getSendPeople() {
		return sendPeople;
	}

	public void setSendPeople(String sendPeople) {
		this.sendPeople = sendPeople;
	}

	public String getReceivePeople() {
		return receivePeople;
	}

	public void setReceivePeople(String receivePeople) {
		this.receivePeople = receivePeople;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
