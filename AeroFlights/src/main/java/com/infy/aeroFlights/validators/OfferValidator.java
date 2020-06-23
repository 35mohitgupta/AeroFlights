package com.infy.aeroFlights.validators;

import com.infy.aeroFlights.dto.OfferDTO;
import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.exception.OfferException;

public class OfferValidator {

	public static void validateOfferTitle(String offerTitle) throws OfferException {
		if(offerTitle == null || offerTitle.trim().equalsIgnoreCase(""))
			throw new OfferException("INVALID_OFFER_TITLE");
	}
	
	public static void validateOffer(OfferDTO offer) throws OfferException {
		validateOfferTitle(offer.getOfferTitle());
		validateDiscount(offer.getDiscount());
		validateStatus(offer.getStatus());
	}
	
	public static void validateDiscount(Double discount) throws OfferException {
		if(discount == null || discount <=0 || discount>=100)
			throw new OfferException("INVALID_DISCOUNT");
	}
	
	public static void validateStatus(OfferStatus status) throws OfferException {
		if(status == null || !(status == OfferStatus.ACTIVE || status == OfferStatus.INACTIVE))
			throw new OfferException("INVALID_OFFER_STATUS");
	}
	
}
