package com.infy.aeroFlights.validators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.UserDTO;
import com.infy.aeroFlights.exception.UserException;

@RunWith(SpringRunner.class)
public class UserValidatorTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testValidateUser() throws UserException {
		expectedException.expect(UserException.class);
		expectedException.expectMessage("INVALID_USERNAME");
		UserDTO userDTO1 = new UserDTO(null, "John123@gmail.com", "john@123","9876543210");
		UserValidator.validateUser(userDTO1);
	}
	
	@Test
	public void testValidateUserName2() throws UserException {
		expectedException.expect(UserException.class);
		expectedException.expectMessage("INVALID_USERNAME");
		UserValidator.validateUsername("            ");
	}
	
	
}
