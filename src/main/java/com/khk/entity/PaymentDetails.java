package com.khk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column
	private String productName;
	@Column(nullable = false,unique=true)
	private String customerEmailId;
	@Column
	private long paidAmount;
	@Column
	private long quantity;
	@Column
	private String paymentStatus;
	@Column
	private Date paymentDate;

	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PaymentDetails(Integer pid, String productName, String customerEmailId, long paidAmount, long quantity,
			String paymentStatus, Date paymentDate) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.customerEmailId = customerEmailId;
		this.paidAmount = paidAmount;
		this.quantity = quantity;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
	}


	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer string) {
		this.pid = string;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String string) {
		this.productName = string;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public long getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long l) {
		this.quantity = l;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "PaymentDetails [pid=" + pid + ", productName=" + productName + ", customerEmailId=" + customerEmailId
				+ ", paidAmount=" + paidAmount + ", quantity=" + quantity + ", paymentStatus=" + paymentStatus
				+ ", paymentDate=" + paymentDate + "]";
	}

	
	

}
