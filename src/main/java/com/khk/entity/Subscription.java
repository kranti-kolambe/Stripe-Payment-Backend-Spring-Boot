package com.khk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer sid;
	private String splan;
	private String status;
	public Subscription() {
		super();
	}
	
//	public Subscription(Integer sid, String splan, String status) {
//		super();
//		this.sid=sid;
//		this.splan = splan;
//		this.status = status;
//	}
	

	public Subscription(String splan, String status) {
		super();
		this.splan = splan;
		this.status = status;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSplan() {
		return splan;
	}
	public void setSplan(String splan) {
	
		this.splan = splan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		
		if(status!=null)
			this.status = status;
		else
			this.status="Not Sbscribed";
	}

	@Override
	public String toString() {
		return "Subscription [sid=" + sid + ", splan=" + splan + ", status=" + status + "]";
	}
	
	
}
