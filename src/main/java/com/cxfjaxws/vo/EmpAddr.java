package com.cxfjaxws.vo;

import java.math.BigInteger;

public class EmpAddr {

	protected String dNo;
	protected String line;
	protected String street;
	private String city;
	private String state;
	private String country;
	private BigInteger zipcode;

	public EmpAddr(String dNo, String line, String street, String city, String state, String country,
			BigInteger zipcode) {
		super();
		this.dNo = dNo;
		this.line = line;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getZipcode() {
		return zipcode;
	}

	public void setZipcode(BigInteger zipcode) {
		this.zipcode = zipcode;
	}

}
