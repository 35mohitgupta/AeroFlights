package com.infy.aeroFlights.validators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.Gender;
import com.infy.aeroFlights.dto.PassengerDTO;
import com.infy.aeroFlights.exception.PassengerException;

@RunWith(SpringRunner.class)
public class PassengerValidatorTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void testValidatePassenger() throws PassengerException {
		expectedException.expect(PassengerException.class);
		expectedException.expectMessage("INVALID_PASSENGER_NAME");
		PassengerDTO passengerDTO = new PassengerDTO(121, "   ", 33, Gender.MALE);
		PassengerValidation.validatePassenger(passengerDTO);
	}
	
	@Test
	public  void testValidateAge() throws PassengerException {
		expectedException.expect(PassengerException.class);
		expectedException.expectMessage("INVALID_PASSENGER_AGE");
		PassengerValidation.validateAge(-1);
	}
	
	@Test
	public void testValidateGender() throws PassengerException {
		expectedException.expect(PassengerException.class);
		expectedException.expectMessage("INVALID_PASSENGER_GENDER");
		PassengerValidation.validateGender(null);
	}
	
	@Test
	public void testValidateName() throws PassengerException {
		expectedException.expect(PassengerException.class);
		expectedException.expectMessage("INVALID_PASSENGER_NAME");
		PassengerValidation.validateName("           ");
	}
	
}
