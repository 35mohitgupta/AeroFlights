package com.infy.aeroFlights.validators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.exception.OfferException;

@RunWith(SpringRunner.class)
public class OfferValidatorTests {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testValidateOfferTitle() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("INVALID_OFFER_TITLE");
		OfferValidator.validateOfferTitle("     ");
	}
	
	@Test
	public void testValidateOffer() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("INVALID_OFFER_STATUS");
		OfferDTO offerDTO = new OfferDTO("FLY120", 15.0, null);
		OfferValidator.validateOffer(offerDTO);
	}
	
	@Test
	public void testValidateDiscount() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("INVALID_DISCOUNT");
		OfferValidator.validateDiscount(111.0);
	}
	
	@Test
	public void testValidateStatus() throws OfferException {
		expectedException.expect(OfferException.class);
		expectedException.expectMessage("INVALID_OFFER_STATUS");
		OfferValidator.validateStatus(null);
	}
	
}
