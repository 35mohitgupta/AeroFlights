package com.infy.aeroFlights.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.aeroFlights.dto.OfferStatus;
import com.infy.aeroFlights.entity.Offer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OfferRepositoryTest {

	@Autowired
	private OfferRepository offerRepository;
	
	@Test
	public void testFindByStatus() {
		Offer offerApplied = new Offer("FLY120", 15.0, OfferStatus.ACTIVE);
		offerApplied = offerRepository.saveAndFlush(offerApplied);
		
		Offer offerApplied2 = new Offer("FLY100", 10.0, OfferStatus.INACTIVE);
		offerApplied2 = offerRepository.saveAndFlush(offerApplied2);
		
		List<Offer> offersActive = offerRepository.findByStatus(OfferStatus.ACTIVE);
		
		Assert.assertThat(offersActive, hasItem(offerApplied));
	}
	
}
