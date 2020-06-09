package com.infy.aeroFlights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.aeroFlights.entity.User;

public interface UserRepositoy extends JpaRepository<User, String>{

}
