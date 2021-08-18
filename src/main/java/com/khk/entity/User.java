package com.khk.entity;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.Fetch;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String address;
	@Column
    private Date birthdate;
    @Column(nullable = false,unique=true)
    private String email;
    @Column
    private String password;
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sid")
	private Subscription subscription;
	public User() {
		super();
	}
	public User(Integer uid, String fname, String lname, String address, Date birthdate, String email, String password,
			Subscription subscription) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.birthdate = birthdate;
		this.email = email;
		this.password = password;
		this.subscription = subscription;
	}
	
	public User(String fname, String lname, String address, Date birthdate, String email, String password,
			Subscription subscription) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.birthdate = birthdate;
		this.email = email;
		this.password = password;
		this.subscription = subscription;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		
			this.subscription = subscription;
		
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", birthdate="
				+ birthdate + ", email=" + email + ", password=" + password + ", subscription=" + subscription + "]";
	}
    
	
}
