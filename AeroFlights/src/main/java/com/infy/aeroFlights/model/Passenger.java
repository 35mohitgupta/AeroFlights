package com.infy.aeroFlights.model;

import com.infy.aeroFlights.entity.PassengerEntity;

public class Passenger {

	private Integer passengerId;
	
	private String name;
	
	private Integer age;
	
	private Gender gender;

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passengerId == null) ? 0 : passengerId.hashCode());
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
		Passenger other = (Passenger) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passengerId == null) {
			if (other.passengerId != null)
				return false;
		} else if (!passengerId.equals(other.passengerId))
			return false;
		return true;
	}

	public PassengerEntity toEntity() {
		PassengerEntity passengerEntity = new PassengerEntity();
		passengerEntity.setPassengerId(passengerId);
		passengerEntity.setAge(age);
		passengerEntity.setGender(gender);
		passengerEntity.setName(name);
		return passengerEntity;
	}
	
	
	public static Passenger toModel(PassengerEntity passengerEntity) {
		Passenger passenger = new Passenger();
		passenger.passengerId = passengerEntity.getPassengerId();
		passenger.age = passengerEntity.getAge();
		passenger.gender = passengerEntity.getGender();
		passenger.name = passengerEntity.getName();
		return passenger;
	}
	
}
