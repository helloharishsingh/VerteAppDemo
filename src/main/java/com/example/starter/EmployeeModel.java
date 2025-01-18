package com.example.starter;

import java.util.Date;
import java.util.Objects;


public class EmployeeModel {

	
	private Long id;
	private String name;
	private String mobileNumber;
	private String emailId;
	private String role;
	
	
	public EmployeeModel(Long id, String name, String mobileNumber, String emailId, String role) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.role = role;
		
	}
	public EmployeeModel() {
		
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(emailId, id, mobileNumber, name, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeModel other = (EmployeeModel) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(id, other.id)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role);
	}
	
}
