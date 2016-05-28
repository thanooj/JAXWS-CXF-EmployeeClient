package com.cxfjaxws.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class EmployeeVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private String firstName;
	private String lastName;
	private EmpAddr addr;
	private String dept;
	private Date doj;

	public EmployeeVo(BigInteger id, String firstName, String lastName, EmpAddr addr, String dept, Date doj) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
		this.dept = dept;
		this.doj = doj;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmpAddr getAddr() {
		return addr;
	}

	public void setAddr(EmpAddr addr) {
		this.addr = addr;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addr=" + addr
				+ ", dept=" + dept + ", doj=" + doj + "]";
	}

}