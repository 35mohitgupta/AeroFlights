package com.infy.aeroFlights.model;

import com.infy.aeroFlights.entity.AdministratorEntity;

public class Administrator {

	private String username;
	
	private String email;
	
	private String password;
	
	private String phoneNo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public AdministratorEntity toEntity() {
		AdministratorEntity administratorEntity = new AdministratorEntity();
		administratorEntity.setEmail(email);
		administratorEntity.setPassword(password);
		administratorEntity.setPhoneNo(phoneNo);
		administratorEntity.setUsername(username);
		return administratorEntity;
	}
	
	public static Administrator toModel(AdministratorEntity administratorEntity) {
		Administrator administrator = new Administrator();
		administrator.setEmail(administratorEntity.getEmail());
		administrator.setPassword(administratorEntity.getPassword());
		administrator.setPhoneNo(administratorEntity.getPhoneNo());
		administrator.setUsername(administratorEntity.getUsername());
		return administrator;
	}
}
